package br.com.cod2d.redirect.domain.dto;

public class Message {
    private final String message;

    public Message(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
