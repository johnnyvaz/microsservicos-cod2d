package br.com.cod2d.api.usecase;

import br.com.cod2d.api.domain.dto.UuidProductQueueDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface SendQueueUseCase {

    void sendProductUuid(final UuidProductQueueDTO dto) throws JsonProcessingException;
}
