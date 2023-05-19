package br.com.cod2d.api.domain.exception;

public final class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException(final String message) {
        super("Usuário não encontrado - ".concat(message));
    }
}
