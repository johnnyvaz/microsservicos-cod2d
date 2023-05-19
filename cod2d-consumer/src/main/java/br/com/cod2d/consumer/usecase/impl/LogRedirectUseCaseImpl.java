package br.com.cod2d.consumer.usecase.impl;

import br.com.cod2d.consumer.domain.dto.ShortenerAuditLogDTO;
import br.com.cod2d.consumer.domain.exceptions.LogUseCaseException;
import br.com.cod2d.consumer.domain.model.ShortenerAuditLog;
import br.com.cod2d.consumer.gateway.IpInfoClientGateway;
import br.com.cod2d.consumer.gateway.impl.repository.jpa.ShortenerAuditLogRepository;
import br.com.cod2d.consumer.usecase.LogRedirectUseCase;
import io.ipinfo.api.model.IPResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Service
public class LogRedirectUseCaseImpl implements LogRedirectUseCase {

    private final ShortenerAuditLogRepository repositoryGateway;

    private final IpInfoClientGateway ipInfoClientGateway;

    @Override
    public void run(final ShortenerAuditLogDTO logDto) {
        log.info("[LogRedirectUseCaseImpl] Starting **: {}", logDto);
        try {

            log.info("[LogRedirectUseCaseImpl] Starting find Address by IP: {}", logDto.getHost());
            final var response = ipInfoClientGateway.findAddress(logDto.getHost());

            log.info("[LogRedirectUseCaseImpl] Save to database: {}", response);
            repositoryGateway.save(buildShortenerLog(response, logDto)); //todo: inserir um gateway aqui com try catch

        } catch (final Exception ex) {
            log.error("[LogRedirectUseCaseImpl] - Error use case : {}", ex.getMessage());
            throw new LogUseCaseException(ex.getMessage());
        }
    }

    ShortenerAuditLog buildShortenerLog(final IPResponse ip,
                                        final ShortenerAuditLogDTO dto) {
        return ShortenerAuditLog.builder()
                .shortLink(dto.getShortLink())
                .creationDate(new Date())
                .host(dto.getHost())
                .userAgent(dto.getUserAgent())
                .accept(dto.getAccept())
                .acceptEncoding(dto.getAcceptEncoding())
                .acceptLanguage(dto.getAcceptLanguage())
                .connection(dto.getConnection())
                .uuid(dto.getUuid())
                .ip(ip.getIp())
                .hostname(ip.getHostname())
                .city(ip.getCity())
                .region(ip.getRegion())
                .country(ip.getCountryCode())
                .loc(ip.getLatitude() + "," + ip.getLongitude())
                .org(ip.getOrg())
                .postal(ip.getPostal())
                .timezone(ip.getTimezone())
                .build();
    }

}
