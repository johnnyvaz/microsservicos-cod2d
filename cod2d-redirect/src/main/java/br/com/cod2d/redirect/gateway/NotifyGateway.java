package br.com.cod2d.redirect.gateway;

import br.com.cod2d.redirect.domain.exception.NotifyExceptionEventDTO;

public interface NotifyGateway {
    void notify(NotifyExceptionEventDTO notifyExceptionEventDTO);
}
