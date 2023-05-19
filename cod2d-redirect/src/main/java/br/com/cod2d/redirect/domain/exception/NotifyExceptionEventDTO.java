package br.com.cod2d.redirect.domain.exception;

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