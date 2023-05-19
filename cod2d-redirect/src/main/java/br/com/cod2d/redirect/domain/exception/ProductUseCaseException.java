package br.com.cod2d.redirect.domain.exception;

public final class ProductUseCaseException extends RuntimeException {
    public ProductUseCaseException(final String message, final String exMessage) {
        super(exMessage + message);
    }
}
