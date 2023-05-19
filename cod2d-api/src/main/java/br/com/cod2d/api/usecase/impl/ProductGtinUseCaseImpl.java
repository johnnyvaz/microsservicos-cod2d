package br.com.cod2d.api.usecase.impl;

import br.com.cod2d.api.domain.dto.UuidProductQueueDTO;
import br.com.cod2d.api.domain.dto.product.RequestProductGtinDTO;
import br.com.cod2d.api.domain.dto.product.ResponseProductGtinDTO;
import br.com.cod2d.api.domain.exception.GtinInvalidException;
import br.com.cod2d.api.domain.exception.GtinNotFoundException;
import br.com.cod2d.api.domain.exception.LimiteExcedidoException;
import br.com.cod2d.api.domain.exception.NotifyExceptionEventDTO;
import br.com.cod2d.api.domain.exception.OrganizationNotFoundException;
import br.com.cod2d.api.domain.exception.ProductUseCaseException;
import br.com.cod2d.api.domain.exception.ProfileNotFoundException;
import br.com.cod2d.api.domain.model.Organization;
import br.com.cod2d.api.domain.model.Profile;
import br.com.cod2d.api.gateway.NotifyGateway;
import br.com.cod2d.api.gateway.impl.repository.jpa.LinkRepository;
import br.com.cod2d.api.gateway.impl.repository.jpa.OrganizationRepository;
import br.com.cod2d.api.gateway.impl.repository.jpa.ProductRepository;
import br.com.cod2d.api.gateway.impl.repository.jpa.ProfileRepository;
import br.com.cod2d.api.usecase.ProductGtinUseCase;
import br.com.cod2d.api.usecase.SendQueueUseCase;
import br.com.cod2d.api.usecase.ShortenerUseCase;
import br.com.cod2d.api.usecase.utils.CodigoEan;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductGtinUseCaseImpl implements ProductGtinUseCase {

    private static final String LINK_CD2 = "https://cd2.io/";
    private static final String LINK_COD2D = "https://cod2d.com.br/";
    private static final String COD_EAN = "/01/";
    private final LinkRepository linkRepository;
    private final NotifyGateway notifyGateway;

    private final CodigoEan codigoEan;

    private final SendQueueUseCase sendQueueUseCase;

    private final ProfileRepository profileRepository;
    private final OrganizationRepository organizationRepository;
    private final ShortenerUseCase shortenerUseCase;

    private final ProductRepository productRepository;


    public ResponseProductGtinDTO sendGtin(final RequestProductGtinDTO request,
                                   final String profileUuid) throws JsonProcessingException {
        try {
            // busca profile
            log.info("busca usuario {}", profileUuid);
            final Optional<Profile> findProfile = profileRepository.findProfileBy(profileUuid);
            final Profile usuario;
            if (findProfile.isEmpty()) {
                throw new ProfileNotFoundException(profileUuid);
            } else {
                usuario = findProfile.get();
            }
            log.info("Usuário encontrado : {}", usuario);
            final var findOrganization = organizationRepository.findByOrganizationUuid(profileUuid);
            if (findOrganization.isEmpty()) {
                throw new OrganizationNotFoundException("Empresa não encontrada vinculada ao usuário");
            }

//             valida se tem limite disponível para criação de novo produtoDTO
//            log.info("Limites Ocupados : {}", findOrganization.get().getLimite());
//            final Long count = productRepository.countProductsByOrganization(organizationUuid);
//            if (count >= organization.getLimite()) {
//                throw new LimiteExcedidoException(organization.getLimite().toString());
//            }
            // UUID destes registros
            final UUID currentUuid = UUID.randomUUID();
            log.info("current uuid : {}", currentUuid);

            // criar link padrão
            log.info("criando link gs1, findOrg {}", findOrganization);

            final ResponseProductGtinDTO result =
                    builLinkDefault(request.getGtin(), findOrganization.get(), currentUuid);

            // criar objeto para fila e banco
            final UuidProductQueueDTO productUuid = UuidProductQueueDTO.builder()
                    .creationDate(new Date())
                    .gtin(request.getGtin())
                    .profileId(profileUuid)
                    .uuid(currentUuid)
                    .gs1DigitalLink(result.getGs1DigitalLink())
                    .linkReduzido(result.getLinkReduzido())
                    .urlRedirect(result.getUrlRedirect())
                    .build();

            //gravar no banco
            final var res = shortenerUseCase.run(productUuid, usuario);
            log.info("arquivo gravado no banco : {}", res);

            sendQueueUseCase.sendProductUuid(productUuid);

            return result;

        } catch (final LimiteExcedidoException exception) {
            final String msgLog = "Limite Excedido, total contratado: {} " + exception.getMessage();
            log.error(msgLog);
            notifyGateway.notify(new NotifyExceptionEventDTO(this, exception));
            throw exception;
        } catch (final Exception exception) {
            log.error("[ProductUseCaseImpl] save failed with: {}", exception.getMessage());
            notifyGateway.notify(new NotifyExceptionEventDTO(this, exception));
            throw exception;
        }
    }

    private ResponseProductGtinDTO builLinkDefault(final String gtin, final Organization organization,
                                                   final UUID currentUuid) {
        try {
            if (gtin.isEmpty()) {
                log.error("Erro: Código GTIN vazio");
                throw new GtinNotFoundException("ERRO: Código Gtin não pode ser vazio");
            }
            final CodigoEan ean13 = new CodigoEan(gtin);
            final var eanIsValid = codigoEan.validar(ean13);
            final String urlGs1;
            final String urlSite;
            final String getSequenceReduzido;
            final String urlReduzido;

            if (Boolean.TRUE.equals(eanIsValid)) {
                urlGs1 = LINK_CD2 +
                        organization.getShortName() + "/" +
                        currentUuid + COD_EAN + gtin;

                urlSite = LINK_COD2D + organization.getShortName() + "/" +
                        gtin + "?id=" + currentUuid;

                getSequenceReduzido = linkRepository.sequence();
                urlReduzido = LINK_CD2 + getSequenceReduzido;


            } else {
                log.error("Erro: Código GTIN Inválido: {}", gtin);
                throw new GtinInvalidException("Código GTIN inválido, verifique.");
            }

            return ResponseProductGtinDTO.builder()
                    .gtin(gtin)
                    .uuid(currentUuid.toString())
                    .gs1DigitalLink(urlGs1)
                    .creationDate(new Date())
                    .linkReduzido(urlReduzido)
                    .urlRedirect(urlSite)
                    .enabled(true)
                    .build();
        } catch (final RuntimeException ex) {
            log.error("Erro: {}", ex.getMessage());
            throw new ProductUseCaseException("ERRO: {} ", ex.getMessage());
        }

    }

}
