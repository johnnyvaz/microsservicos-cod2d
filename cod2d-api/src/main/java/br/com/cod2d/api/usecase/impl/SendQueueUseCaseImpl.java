package br.com.cod2d.api.usecase.impl;

import br.com.cod2d.api.config.slack.SlackServiceNotifier;
import br.com.cod2d.api.domain.dto.UuidProductQueueDTO;
import br.com.cod2d.api.domain.enums.MessageLevelEnum;
import br.com.cod2d.api.gateway.ProducerGateway;
import br.com.cod2d.api.usecase.SendQueueUseCase;
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
public class SendQueueUseCaseImpl implements SendQueueUseCase {

    private final ProducerGateway<UuidProductQueueDTO> producerGateway;
    private final SlackServiceNotifier slackServiceNotifier;

    @Override
    @Async
    public void sendProductUuid(final UuidProductQueueDTO shortener) throws JsonProcessingException {
        try {
           producerGateway.execute(shortener);
        } catch (final Exception ex) {
           final var error = Stream.of(ex.getStackTrace())
               .map(StackTraceElement::toString)
               .collect(Collectors.joining(System.lineSeparator()));
           slackServiceNotifier.slackNotifier("Erro ao enviar mensagens para fila",
                   error, MessageLevelEnum.ALERT);
           log.error("[SendQueueUseCaseImpl] Error executing enqueue process "
               + "for shortener: {}, error: {}", shortener, error);
           throw ex;
        }
    }
}
