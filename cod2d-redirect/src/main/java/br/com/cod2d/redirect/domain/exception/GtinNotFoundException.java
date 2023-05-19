package br.com.cod2d.redirect.domain.exception;

public final class GtinNotFoundException extends RuntimeException {
    public GtinNotFoundException(final String message) {
        super(message);
    }
}
