package br.com.cod2d.api.domain.exception;

public final class MakerApiGatewayException extends RuntimeException {
    public MakerApiGatewayException(final String message) {
        super("ERRO MAKER API - ".concat(message));
    }
}
