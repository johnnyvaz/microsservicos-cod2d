package br.com.cod2d.api.domain.exception;

public final class GtinInvalidException extends RuntimeException {
    public GtinInvalidException(final String message) {
        super(message);
    }
}
