package br.com.cod2d.consumer.integration.factory;

import org.springframework.amqp.core.MessageProperties;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static br.com.cod2d.consumer.usecase.utils.ConvertUtils.toJson;

public final class CommonsMessageBuilder {

    public static String buildBody(final Object object) {
        return toJson(object);
    }

    public static MessageProperties buildMessageProperties(final Integer quantityAttempts) {
        final MessageProperties properties = new MessageProperties();
        final var map = Map.of("count", quantityAttempts);
        final List<Map<String, Integer>> maps = Collections.singletonList(map);
        properties.setHeader("x-death", maps);
        return properties;
    }
}

