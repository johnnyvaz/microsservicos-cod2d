package br.com.cod2d.api.usecase.impl;

import br.com.cod2d.api.domain.dto.maker.PostOrganizationMakerDTO;
import br.com.cod2d.api.domain.dto.organization.RequestOrganizationDTO;
import br.com.cod2d.api.domain.dto.organization.ResponseRegistrationDTO;
import br.com.cod2d.api.domain.exception.PasswordInvalidException;
import br.com.cod2d.api.domain.model.Organization;
import br.com.cod2d.api.domain.model.QuantidadeLimites;
import br.com.cod2d.api.gateway.NotifyGateway;
import br.com.cod2d.api.gateway.impl.repository.jpa.LimitesRepository;
import br.com.cod2d.api.gateway.impl.repository.jpa.OrganizationRepository;
import br.com.cod2d.api.usecase.RegistrationUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegistrationUseCaseImpl implements RegistrationUseCase {

    @Value("${senhaMaster}")
    private String SENHA_MASTER;
    private final NotifyGateway notifyGateway;
    private final OrganizationRepository organizationRepository;
    private final LimitesRepository limitesRepository;


    private final String TEXTO_FINAL = "Cadastro efetuado com sucesso, " +
            "guarde em lugar seguro essas informações para acesso na integração com produtoDTOS";

    @Override
    public ResponseRegistrationDTO run(final RequestOrganizationDTO request) {
        try {
            if (!request.getPassword().equals(SENHA_MASTER)) {
                throw new PasswordInvalidException("Senha inválida");
            }

            log.info("criando limites");
            final var limit = buildLimit();

            log.info("criando empresa = {}",
                    request.getNameOrganization());
            final Organization organization = Organization.builder()
                    .name(request.getNameOrganization())
                    .shortName(request.getNameShort())
                    .creationDate(new Date())
                    .linkSite(request.getLinkSiteInstitucional())
                    .linkSac(request.getLinkSac())
                    .linkLogotipo(request.getLinkLogotipo())
                    .fantasia(request.getFantasia())
                    .cnpj(request.getCnpj())
                    .limites(limit)
                    .build();
            final var response = organizationRepository.save(organization);

            final var postOrg = PostOrganizationMakerDTO.builder()
                    .organizationUuid(response.getUuid()).build();


            return buildResponse(response);
        } catch (final Exception exception) {
            log.error("[ProductUseCaseImpl] save failed with: {}", exception.getMessage());
//            notifyGateway.notify(new NotifyExceptionEventDTO(this, exception));
            throw exception;
        }
    }

    private QuantidadeLimites buildLimit() {
        final QuantidadeLimites limite = QuantidadeLimites.builder()
                .qtdeLinks(20L)
                .qtdeProdutos(20L)
                .creationDate(new Date())
                .build();
        limitesRepository.save(limite);
        return limite;
    }

    private ResponseRegistrationDTO buildResponse(final Organization organization) {
        return ResponseRegistrationDTO.builder()
                .nameOrganization(organization.getName())
                .uuid(organization.getUuid())
                .textoResposta(TEXTO_FINAL)
                .cnpj(organization.getCnpj())
                .linkSiteInstitucional(organization.getLinkSite())
                .nameShort(organization.getShortName())
                .fantasia(organization.getFantasia())
                .linkLogotipo(organization.getLinkLogotipo())
                .linkSac(organization.getLinkSac())
                .build();
    }
}
