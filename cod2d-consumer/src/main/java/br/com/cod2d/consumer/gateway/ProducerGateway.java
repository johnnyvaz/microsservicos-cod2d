package br.com.cod2d.consumer.gateway;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ProducerGateway<T> {

    String execute(T message) throws JsonProcessingException;

}

