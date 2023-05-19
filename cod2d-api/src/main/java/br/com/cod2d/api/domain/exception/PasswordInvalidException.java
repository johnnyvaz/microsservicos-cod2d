package br.com.cod2d.api.domain.exception;

public final class PasswordInvalidException extends RuntimeException {
    public PasswordInvalidException(final String message) {
        super(message);
    }
}
