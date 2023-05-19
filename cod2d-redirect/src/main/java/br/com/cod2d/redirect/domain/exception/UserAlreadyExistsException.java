package br.com.cod2d.redirect.domain.exception;

public final class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(final String message) {
        super(message);
    }
}
