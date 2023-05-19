package br.com.cod2d.redirect.usecase.impl;

import br.com.cod2d.redirect.domain.dto.ShortenerAuditLogDTO;
import br.com.cod2d.redirect.domain.exception.NotifyExceptionEventDTO;
import br.com.cod2d.redirect.gateway.NotifyGateway;
import br.com.cod2d.redirect.gateway.RepositoryGateway;
import br.com.cod2d.redirect.gateway.impl.repository.jpa.ShortenerRepository;
import br.com.cod2d.redirect.usecase.LogRegisterUseCase;
import br.com.cod2d.redirect.usecase.ShortenerUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShortenerUseCaseImpl implements ShortenerUseCase {

    @Value("${link.erro404}")
    private String erro404;
    private final RepositoryGateway repositoryGateway;

    private final ShortenerRepository shortenerRepository;
    private final LogRegisterUseCase logRegisterUseCase;

    private final NotifyGateway notifyGateway;

    public String getLink(final String shortLink, final HttpHeaders headers) throws JsonProcessingException {
        try {
            log.info("[ShortenerUseCaseImpl] find link: {}", shortLink);
            final var link = repositoryGateway.findShortlink(shortLink);

            log.info("Post log queue: from = {}", link);
            log.info("Post log queue: from = {}", headers);
            log.info("Post log queue: msg = {}", shortLink);
            final ShortenerAuditLogDTO buildLog = ShortenerAuditLogDTO.builder()
                    .shortLink(shortLink)
                    .creationDate(new Date())
                    .host(Objects.requireNonNull(headers.getHost()).getHostString())
                    .userAgent(headers.getFirst("user-agent"))
                    .accept(headers.getAccept().toString())
                    .acceptEncoding(headers.getFirst("accept-encoding"))
                    .acceptLanguage(headers.getAcceptLanguage().toString())
                    .connection(headers.getConnection().toString())
                    .uuid(UUID.randomUUID())

                    .build();
            logRegisterUseCase.shortenerAuditLog(buildLog);

            if (!Objects.isNull(link)) {
                return link.getRedirectLink();
            } else {
                return erro404;
            }

        } catch (final Exception exception) {
            log.error("[ShortenerUseCaseImpl] find failed with: {}", exception.getMessage());
            notifyGateway.notify(new NotifyExceptionEventDTO(this, exception));
            throw exception;
        }


    }
}
