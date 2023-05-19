package br.com.cod2d.redirect.domain.exception;

public final class PasswordInvalidException extends RuntimeException {
    public PasswordInvalidException(final String message) {
        super(message);
    }
}
