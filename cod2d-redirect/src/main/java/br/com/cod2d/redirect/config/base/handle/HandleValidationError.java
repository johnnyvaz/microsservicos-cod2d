package br.com.cod2d.redirect.config.base.handle;

import br.com.cod2d.redirect.config.base.error.ErrorDTO;
import br.com.cod2d.redirect.config.base.error.factory.HandleValidationType;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

public class HandleValidationError {
    public HandleValidationError() {
    }

    public List<ErrorDTO> createErrorsFromList(final List<FieldError> fieldErrorList) {
        return (List)fieldErrorList.stream().map(this::createError).collect(Collectors.toList());
    }

    public ErrorDTO createError(final FieldError fieldError) {
        final HandleValidationType error = (HandleValidationType) ValidationErrorFactory
                .getOperation(fieldError.getCode()).orElseThrow(() -> {
            return new IllegalArgumentException("Invalid Error");
        });
        return error.create(fieldError);
    }
}
