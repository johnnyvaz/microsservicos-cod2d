package br.com.cod2d.consumer.usecase.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.core.Message;

public interface MessageConverter {
    <T> T convert(final Message message, final Class<T> targetClass) throws JsonProcessingException;
}
