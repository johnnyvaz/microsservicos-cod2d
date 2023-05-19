package br.com.cod2d.consumer.gateway;

import br.com.cod2d.consumer.domain.exceptions.NotifyExceptionEventDTO;

public interface NotifyGateway {
    void notify(NotifyExceptionEventDTO notifyExceptionEventDTO);
}
