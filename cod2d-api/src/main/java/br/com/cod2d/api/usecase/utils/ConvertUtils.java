package br.com.cod2d.api.usecase.utils;

import br.com.cod2d.api.domain.dto.UuidProductQueueDTO;
import br.com.cod2d.api.domain.dto.gs1.ProductGs1QueueDTO;
import br.com.cod2d.api.domain.exception.JsonMapperException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.http.MediaType;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;


public class ConvertUtils {
    public static <T> List<T> convertToList(final Set<T> set) {
        return set.stream().collect(Collectors.toList());
    }

    public static String toJson(final Object object) {
        try {
            return buildObjectMapper().writeValueAsString(object);
        } catch (final JsonProcessingException e) {
            throw new JsonMapperException(e.getMessage());
        }
    }

    public static <T> T readFileJsonToObject(final String src, final Class<T> valueType) {
        try {
            return buildObjectMapper().readValue(new File(src), valueType);
        } catch (final IOException e) {
            throw new JsonMapperException(e.getMessage());
        }
    }

    private static ObjectMapper buildObjectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
        return objectMapper;
    }

    public static Message getMessage(final UuidProductQueueDTO uuidProductQueue) throws JsonProcessingException {
        final byte[] messageBody = buildObjectMapper().writeValueAsBytes(uuidProductQueue);
        final var messageId = UUID.randomUUID().toString();
        return MessageBuilder.withBody(messageBody)
                .setContentType(MediaType.APPLICATION_JSON_VALUE)
                .setDeliveryMode(MessageDeliveryMode.PERSISTENT)
                .setMessageId(messageId)
                .build();
    }

    public static Message getGtinMessage(final ProductGs1QueueDTO gtinProductQueue) throws JsonProcessingException {
        final byte[] messageBody = buildObjectMapper().writeValueAsBytes(gtinProductQueue);
        final var messageId = UUID.randomUUID().toString();
        return MessageBuilder.withBody(messageBody)
                .setContentType(MediaType.APPLICATION_JSON_VALUE)
                .setDeliveryMode(MessageDeliveryMode.PERSISTENT)
                .setMessageId(messageId)
                .build();
    }
}
