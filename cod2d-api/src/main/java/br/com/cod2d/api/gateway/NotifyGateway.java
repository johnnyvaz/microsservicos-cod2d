package br.com.cod2d.api.gateway;

import br.com.cod2d.api.domain.exception.NotifyExceptionEventDTO;

public interface NotifyGateway {
    void notify(NotifyExceptionEventDTO notifyExceptionEventDTO);
}
