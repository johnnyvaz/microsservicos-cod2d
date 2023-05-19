package br.com.cod2d.consumer.domain.exceptions;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class NotifyExceptionEventDTO extends ApplicationEvent {

    @Getter
    private final Exception exception;

    public NotifyExceptionEventDTO(final Object source, final Exception exception) {
        super(source);
        this.exception = exception;
    }

}