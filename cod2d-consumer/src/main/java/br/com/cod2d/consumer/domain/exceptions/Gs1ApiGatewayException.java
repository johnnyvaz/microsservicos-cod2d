package br.com.cod2d.consumer.domain.exceptions;

public final class Gs1ApiGatewayException extends RuntimeException {
    public Gs1ApiGatewayException(final String message) {
        super("ERRO GS1 API - ".concat(message));
    }
}
