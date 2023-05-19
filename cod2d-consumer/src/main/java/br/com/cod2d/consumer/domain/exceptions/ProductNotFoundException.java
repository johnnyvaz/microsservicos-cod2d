package br.com.cod2d.consumer.domain.exceptions;

public final class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super("ProdutoDTO não encontrado ");
    }
}
