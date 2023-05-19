package br.com.cod2d.consumer.gateway.impl.listener;

import br.com.cod2d.consumer.domain.dto.ShortenerAuditLogDTO;
import br.com.cod2d.consumer.usecase.LogRedirectUseCase;
import br.com.cod2d.consumer.usecase.utils.MessageConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sansao.annotation.EnableRabbitRetryAndParkingLot;
import com.sansao.annotation.Listener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
@RequiredArgsConstructor
@Listener
public class LogRedirectListener {

  private static final String LOGREDIRECT = "log-redirect";
  private final MessageConverter converter;
  private final LogRedirectUseCase logRedirectUseCase;

  @RabbitListener(queues = "${spring.rabbitmq.events.logRedirect.queue}")
  @EnableRabbitRetryAndParkingLot(event = LOGREDIRECT)
  public void consumer(final Message message) throws JsonProcessingException {
    log.info("[LogRedirectListener] Receiving log Message: {}", message);
    final ShortenerAuditLogDTO dto = converter.convert(message, ShortenerAuditLogDTO.class);
    log.info("Executing LogRedirectUseCase: {}", dto);
    logRedirectUseCase.run(dto);
  }

}
