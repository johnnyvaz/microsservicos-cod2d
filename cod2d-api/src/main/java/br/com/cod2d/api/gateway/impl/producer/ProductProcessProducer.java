package br.com.cod2d.api.gateway.impl.producer;


import br.com.cod2d.api.domain.dto.UuidProductQueueDTO;
import br.com.cod2d.api.gateway.ProducerGateway;
import br.com.cod2d.api.usecase.utils.ConvertUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductProcessProducer implements ProducerGateway<UuidProductQueueDTO> {

    private final MessageProducer messageProducer;

    @Value("${spring.rabbitmq.vhosts}")
    private String vhost;

    @Value("${spring.rabbitmq.events.newProduct.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.events.newProduct.queueRoutingKey}")
    private String routingKey;

    @Override
    public String execute(final UuidProductQueueDTO shortener) throws JsonProcessingException {
        final var message = ConvertUtils.getMessage(shortener);
        log.info("[ProductProcessProducer] - Sending message to, "
            + "exchange={}, routingKey={}, message={}", exchange, routingKey, message);
        messageProducer.produce(exchange, vhost, routingKey, message);
        return message.getMessageProperties().getMessageId();
    }
}
