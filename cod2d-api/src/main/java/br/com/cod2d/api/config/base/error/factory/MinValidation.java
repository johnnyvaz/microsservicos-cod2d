package br.com.cod2d.api.config.base.error.factory;

import br.com.cod2d.api.config.base.error.ErrorDTO;
import br.com.cod2d.api.config.base.error.ErrorDTOFactory;
import org.springframework.validation.FieldError;

public class MinValidation implements HandleValidationType {
    @Override
    public ErrorDTO create(final FieldError fieldError) {
        int minValue = 0;
        final var arguments = fieldError.getArguments();
        assert arguments != null;
        if (arguments.length >= 2) {
            final Long minArgument = (Long) arguments[1];
            minValue = minArgument.intValue();
        }

        return ErrorDTOFactory.getGreaterOrEqualsMessage("value", fieldError.getField(), minValue);
    }
}
