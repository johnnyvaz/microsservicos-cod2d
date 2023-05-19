package br.com.cod2d.redirect.domain.exception;

public final class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super("ProdutoDTO não encontrado ");
    }
}
