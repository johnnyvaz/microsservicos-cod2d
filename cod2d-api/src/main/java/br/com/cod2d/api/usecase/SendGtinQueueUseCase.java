package br.com.cod2d.api.usecase;

import br.com.cod2d.api.domain.dto.gs1.ProductGs1QueueDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface SendGtinQueueUseCase {

    void sendProductUuid(final ProductGs1QueueDTO dto) throws JsonProcessingException;
}
