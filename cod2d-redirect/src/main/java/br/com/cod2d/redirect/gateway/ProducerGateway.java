package br.com.cod2d.redirect.gateway;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ProducerGateway<T> {

    String execute(T message) throws JsonProcessingException;

}

