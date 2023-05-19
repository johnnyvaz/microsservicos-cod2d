package br.com.cod2d.redirect.gateway.impl.producer;

import br.com.cod2d.redirect.domain.dto.ShortenerAuditLogDTO;
import br.com.cod2d.redirect.gateway.ProducerGateway;
import br.com.cod2d.redirect.usecase.util.ConvertUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductProcessProducer implements ProducerGateway<ShortenerAuditLogDTO> {

    private final MessageProducer messageProducer;

    @Value("${spring.rabbitmq.vhosts}")
    private String vhost;

    @Value("${spring.rabbitmq.events.logRedirect.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.events.logRedirect.routingkey}")
    private String routingKey;

    @Override
    public String execute(final ShortenerAuditLogDTO shortener) throws JsonProcessingException {
        final var message = ConvertUtils.getMessage(shortener);
        log.info("[ProductProcessProducer] - Sending message to, "
            + "exchange={}, routingKey={}, message={}", exchange, routingKey, message);
        messageProducer.produce(exchange, vhost, routingKey, message);
        return message.getMessageProperties().getMessageId();
    }
}
