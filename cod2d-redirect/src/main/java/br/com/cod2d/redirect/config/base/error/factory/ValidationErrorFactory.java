package br.com.cod2d.redirect.config.base.error.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

final public class ValidationErrorFactory {

    private ValidationErrorFactory() {
    }

    static Map<String, HandleValidationType> operationMap = new HashMap<>();
    static {
        operationMap.put("NotNull", new NotNullValidation());
        operationMap.put("NotEmpty", new NotEmptyValidation());
        operationMap.put("Min", new MinValidation());
    }

    public static Optional<HandleValidationType> getOperation(final String operator) {
        return Optional.ofNullable(operationMap.get(operator));
    }

}
