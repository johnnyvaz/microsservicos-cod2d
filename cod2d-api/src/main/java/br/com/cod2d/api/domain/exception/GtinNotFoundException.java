package br.com.cod2d.api.domain.exception;

public final class GtinNotFoundException extends RuntimeException {
    public GtinNotFoundException(final String message) {
        super(message);
    }
}
