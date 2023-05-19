package br.com.cod2d.api.gateway.impl.producer;


import br.com.cod2d.api.domain.dto.gs1.ProductGs1QueueDTO;
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
public class GtinProcessProducer implements ProducerGateway<ProductGs1QueueDTO> {

    private final MessageProducer messageProducer;

    @Value("${spring.rabbitmq.vhosts}")
    private String vhost;

    @Value("${spring.rabbitmq.events.gtin.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.events.gtin.queueRoutingKey}")
    private String routingKey;

    @Override
    public String execute(final ProductGs1QueueDTO gtin) throws JsonProcessingException {
        final var message = ConvertUtils.getGtinMessage(gtin);
        log.info("[ProductProcessProducer] - Sending message to, "
            + "exchange={}, routingKey={}, message={}", exchange, routingKey, message);
        messageProducer.produce(exchange, vhost, routingKey, message);
        return message.getMessageProperties().getMessageId();
    }

}
