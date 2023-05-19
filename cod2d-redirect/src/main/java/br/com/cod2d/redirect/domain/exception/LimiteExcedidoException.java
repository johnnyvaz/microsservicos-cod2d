package br.com.cod2d.redirect.domain.exception;

public final class LimiteExcedidoException extends RuntimeException {
    public LimiteExcedidoException(final String message) {
        super(("Limite excedido para o cadastro de produtoDTOS: seu limite é de " +
                "").concat(message).concat(" produtoDTOS."));
    }
}
