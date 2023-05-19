package br.com.cod2d.redirect.usecase;

import br.com.cod2d.redirect.domain.dto.ShortenerAuditLogDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface LogRegisterUseCase {

    void shortenerAuditLog(final ShortenerAuditLogDTO dto) throws JsonProcessingException;
}
