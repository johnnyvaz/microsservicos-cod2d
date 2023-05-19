package br.com.cod2d.consumer.usecase;

import br.com.cod2d.consumer.domain.dto.UuidProductQueueDTO;

public interface FindGtinProductUseCase {

  void run(UuidProductQueueDTO uuidProduct);

}
