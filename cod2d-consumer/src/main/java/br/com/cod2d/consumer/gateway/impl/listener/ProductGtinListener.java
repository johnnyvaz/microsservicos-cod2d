package br.com.cod2d.consumer.gateway.impl.listener;

import br.com.cod2d.consumer.domain.dto.UuidProductQueueDTO;
import br.com.cod2d.consumer.usecase.FindGtinProductUseCase;
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
public class ProductGtinListener {

  private static final String FIND = "find-product";
  private final MessageConverter converter;
  private final FindGtinProductUseCase findGtinProductUseCase;

  @RabbitListener(queues = "${spring.rabbitmq.events.newProduct.queue}")
  @EnableRabbitRetryAndParkingLot(event = FIND)
  public void consumer(final Message message) throws JsonProcessingException {
    log.info("[ProductListener] Find Product: {}", message);
    try {
      final UuidProductQueueDTO dto = converter.convert(message, UuidProductQueueDTO.class);
      log.info("Executing FindProductGtinUseCase: {}", dto);
      findGtinProductUseCase.run(dto);
    } catch (final Exception exception) {
      log.error("an error has occurred, exceptionMessage={}", exception.getMessage());
      throw exception;
    }


  }

}
