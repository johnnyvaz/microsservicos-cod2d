package br.com.cod2d.consumer.config.base.error.factory;

import br.com.cod2d.consumer.config.base.error.ErrorDTO;
import org.springframework.validation.FieldError;

public interface HandleValidationType {
    ErrorDTO create(FieldError fieldError);
}
