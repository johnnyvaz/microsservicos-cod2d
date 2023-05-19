package br.com.cod2d.redirect.usecase.util;

import br.com.cod2d.redirect.domain.dto.ShortenerAuditLogDTO;
import br.com.cod2d.redirect.domain.exception.JsonMapperException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.http.MediaType;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.UUID;

@NoArgsConstructor
public final class ConvertUtils {

	public static Message getMessage(final ShortenerAuditLogDTO shortener) throws JsonProcessingException {
		final byte[] messageBody = buildObjectMapper().writeValueAsBytes(shortener);
			final var messageId = UUID.randomUUID().toString();
			return MessageBuilder.withBody(messageBody)
					.setContentType(MediaType.APPLICATION_JSON_VALUE)
					.setDeliveryMode(MessageDeliveryMode.PERSISTENT)
					.setMessageId(messageId)
					.build();
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
	
}
