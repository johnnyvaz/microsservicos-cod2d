package br.com.cod2d.redirect.domain.exception;

public final class ShortenerNotFoundException extends RuntimeException {
    public ShortenerNotFoundException(final String message) {
        super("Link não encontrado: ".concat(message));
    }
}
