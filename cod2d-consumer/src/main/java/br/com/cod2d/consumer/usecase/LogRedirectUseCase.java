package br.com.cod2d.consumer.usecase;

import br.com.cod2d.consumer.domain.dto.ShortenerAuditLogDTO;

public interface LogRedirectUseCase {

  void run(ShortenerAuditLogDTO shortenerAuditLogDTO);
}
