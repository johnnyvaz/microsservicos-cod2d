package br.com.cod2d.redirect.usecase.impl;

import br.com.cod2d.redirect.config.slack.MessageLevelEnum;
import br.com.cod2d.redirect.config.slack.SlackServiceNotifier;
import br.com.cod2d.redirect.domain.dto.ShortenerAuditLogDTO;
import br.com.cod2d.redirect.gateway.ProducerGateway;
import br.com.cod2d.redirect.usecase.LogRegisterUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class LogRegisterUseCaseImpl implements LogRegisterUseCase {

    private final ProducerGateway<ShortenerAuditLogDTO> producerGateway;
    private final SlackServiceNotifier slackServiceNotifier;

    @Override
    @Async
    public void shortenerAuditLog(final ShortenerAuditLogDTO shortener) throws JsonProcessingException {
        try {
           producerGateway.execute(shortener);
        } catch (final Exception ex) {
           final var error = Stream.of(ex.getStackTrace())
               .map(StackTraceElement::toString)
               .collect(Collectors.joining(System.lineSeparator()));
            slackServiceNotifier.slackNotifier("Erro ao enviar mensagens para fila",
                    error, MessageLevelEnum.ALERT);
           log.error("[LogRegisterUseCaseImpl] Error executing enqueue process "
               + "for billingDto: {}, error: {}", shortener, error);
           throw ex;
        }
    }
}
