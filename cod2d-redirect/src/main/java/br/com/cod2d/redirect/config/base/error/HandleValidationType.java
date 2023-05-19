package br.com.cod2d.redirect.config.base.error;

import org.springframework.validation.FieldError;

public interface HandleValidationType {
    ErrorDTO create(FieldError var1);
}
