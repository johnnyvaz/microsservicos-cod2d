package br.com.cod2d.consumer.gateway;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.core.Message;

public interface RabbitMQListener {
    void consumer(Message message) throws JsonProcessingException;
}
