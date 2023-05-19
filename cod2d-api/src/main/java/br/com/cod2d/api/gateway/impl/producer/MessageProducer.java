package br.com.cod2d.api.gateway.impl.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.SimpleResourceHolder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageProducer {

    private final RabbitTemplate template;

    public void produce(final String exchangeName,
                             final String vhost,
                             final String queueRoutingKey,
                             final Message message) {
        SimpleResourceHolder.bind(template.getConnectionFactory(), vhost);
        try {
            template.convertAndSend(exchangeName, queueRoutingKey, message);
        } finally {
            SimpleResourceHolder.unbind(template.getConnectionFactory());
        }
    }
}
