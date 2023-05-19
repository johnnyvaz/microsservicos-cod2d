package br.com.cod2d.api.domain.exception;

public final class SoftupClientGatewayException extends RuntimeException {
    public SoftupClientGatewayException(final String message) {
        super("find softup product error - ".concat(message));
    }
}
