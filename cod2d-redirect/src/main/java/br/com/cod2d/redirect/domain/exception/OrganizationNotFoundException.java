package br.com.cod2d.redirect.domain.exception;

public final class OrganizationNotFoundException extends RuntimeException {
    public OrganizationNotFoundException(final String message) {
        super("Empresa não encontrada - ".concat(message));
    }
}
