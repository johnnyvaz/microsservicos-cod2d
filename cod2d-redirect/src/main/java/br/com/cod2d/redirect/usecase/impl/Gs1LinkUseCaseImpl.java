package br.com.cod2d.redirect.usecase.impl;

import br.com.cod2d.redirect.domain.dto.ShortenerAuditLogDTO;
import br.com.cod2d.redirect.domain.dto.product.OrganizationGtinSkuDTO;
import br.com.cod2d.redirect.domain.exception.NotifyExceptionEventDTO;
import br.com.cod2d.redirect.domain.model.Organization;
import br.com.cod2d.redirect.gateway.NotifyGateway;
import br.com.cod2d.redirect.gateway.impl.repository.jpa.LinkRepository;
import br.com.cod2d.redirect.gateway.impl.repository.jpa.OrganizationRepository;
import br.com.cod2d.redirect.gateway.impl.repository.jpa.SerialShippingRepository;
import br.com.cod2d.redirect.usecase.Gs1LinkUseCase;
import br.com.cod2d.redirect.usecase.LogRegisterUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class Gs1LinkUseCaseImpl implements Gs1LinkUseCase {

    @Value("${link.erro404}")
    private String erro404;

    private final OrganizationRepository organizationRepository;
    private final SerialShippingRepository serialShippingRepository;
    private final LinkRepository linkRepository;
    private final NotifyGateway notifyGateway;
    private final LogRegisterUseCase logRegisterUseCase;

    public String getOrgLinkSku(final OrganizationGtinSkuDTO object) {
        // /{organization}/{uuid}/01/{gtin}/22/{sku}
        try {
            // busca e valida empresa
            final var organization = object.getOrganization();
            log.info("busca empresa pelo nome curto {}", organization);
            final Organization findOrg = organizationRepository
                    .findByShortName(organization)
                    .orElse(null);
            log.info("Empresa encontrada : {}", findOrg);

            // busca uuid (é o pacote/faturamento)
            final var isShipping = !object.getUuid().isEmpty();
            final var shipping = object.getUuid();
            if (isShipping) {
                log.info("Busca se possui pacote/faturamento pelo uuid: {}", shipping);
                final var findShipping = serialShippingRepository.findByUuid(shipping);
                //todo: vai fazer alguma validação?
            }


            // busca gtin + sku
            final String linkFrom;
            linkFrom = object.getOrganization() +
                        "/01/" + object.getGtin() +
                        "/22/" + object.getSku();

            String link = linkRepository.findShortlink(linkFrom);

            if (isShipping) link = link + "?uuid=" + shipping;

            log.info("Post log queue: from = {}", object.getHeaders());
            final ShortenerAuditLogDTO buildLog = ShortenerAuditLogDTO.builder()
                    .shortLink(link)
                    .creationDate(new Date())
                    .host(Objects.requireNonNull(object.getHeaders().getHost()).getHostString())
                    .userAgent(object.getHeaders().getFirst("user-agent"))
                    .accept(object.getHeaders().getAccept().toString())
                    .acceptEncoding(object.getHeaders().getFirst("accept-encoding"))
                    .acceptLanguage(object.getHeaders().getAcceptLanguage().toString())
                    .connection(object.getHeaders().getConnection().toString())
                    .shippingUuid(isShipping ? shipping : null)
                    .uuid(UUID.randomUUID())
                    .build();
            logRegisterUseCase.shortenerAuditLog(buildLog);

            if (!Objects.isNull(link)) {
                return link;
            } else {
                return erro404;
            }

        } catch (final Exception exception) {
            log.error("[ShortenerUseCaseImpl] find failed with: {}", exception.getMessage());
            notifyGateway.notify(new NotifyExceptionEventDTO(this, exception));
            return erro404;
        }
    }


    public String getLinkSku(final OrganizationGtinSkuDTO object) throws JsonProcessingException {
        try {
            log.info("[ShortenerUseCaseImpl] find links");
            final String linkFrom;
            if (object.getSku().isEmpty()) {
                linkFrom = object.getOrganization() +
                        "/01/" + object.getGtin();
            } else {
                linkFrom = object.getOrganization() +
                        "/01/" + object.getGtin() +
                        "/22/" + object.getSku();
            }

            final String link = linkRepository.findShortlink(linkFrom);

            log.info("Post log queue: from = {}", object.getHeaders());
            log.info("Post log queue: msg = {}", object.getOrganization());
            final ShortenerAuditLogDTO buildLog = ShortenerAuditLogDTO.builder()
                    .shortLink(link)
                    .creationDate(new Date())
                    .host(Objects.requireNonNull(object.getHeaders().getHost()).getHostString())
                    .userAgent(object.getHeaders().getFirst("user-agent"))
                    .accept(object.getHeaders().getAccept().toString())
                    .acceptEncoding(object.getHeaders().getFirst("accept-encoding"))
                    .acceptLanguage(object.getHeaders().getAcceptLanguage().toString())
                    .connection(object.getHeaders().getConnection().toString())
                    .uuid(UUID.randomUUID())
                    .build();
            logRegisterUseCase.shortenerAuditLog(buildLog);

            if (!Objects.isNull(link)) {
                return link;
            } else {
                return erro404;
            }

        } catch (final Exception exception) {
            log.error("[ShortenerUseCaseImpl] find failed with: {}", exception.getMessage());
            notifyGateway.notify(new NotifyExceptionEventDTO(this, exception));
            return erro404;
        }
    }

}
