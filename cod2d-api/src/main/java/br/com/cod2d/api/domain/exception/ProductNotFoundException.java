package br.com.cod2d.api.domain.exception;

public final class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super("ProdutoDTO não encontrado ");
    }
}
