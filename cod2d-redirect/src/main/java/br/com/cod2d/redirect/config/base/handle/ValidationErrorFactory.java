package br.com.cod2d.redirect.config.base.handle;

import br.com.cod2d.redirect.config.base.error.factory.HandleValidationType;
import br.com.cod2d.redirect.config.base.error.factory.MinValidation;
import br.com.cod2d.redirect.config.base.error.factory.NotEmptyValidation;
import br.com.cod2d.redirect.config.base.error.factory.NotNullValidation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class ValidationErrorFactory {
    static Map<String, HandleValidationType> operationMap = new HashMap();

    private ValidationErrorFactory() {
    }

    public static Optional<HandleValidationType> getOperation(final String operator) {
        return Optional.ofNullable((HandleValidationType)operationMap.get(operator));
    }

    static {
        operationMap.put("NotNull", new NotNullValidation());
        operationMap.put("NotEmpty", new NotEmptyValidation());
        operationMap.put("Min", new MinValidation());
    }
}
