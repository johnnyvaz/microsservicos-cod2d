package br.com.cod2d.consumer.gateway.impl.notify;

import br.com.cod2d.consumer.domain.exceptions.NotifyExceptionEventDTO;
import br.com.cod2d.consumer.gateway.NotifyGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotifyGatewayImpl implements NotifyGateway {

    private final ApplicationEventPublisher publisher;

    @Override
    public void notify(final NotifyExceptionEventDTO notifyExceptionEventDTO) {
        publisher.publishEvent(notifyExceptionEventDTO);
    }
}
