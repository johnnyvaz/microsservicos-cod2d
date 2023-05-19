package br.com.cod2d.consumer.domain.exceptions;

public class InvalidMessageException extends Exception {
	public InvalidMessageException(final String message) {
		super(String.format("Invalid Message unexpected exception: ### %s", message));
	}

}
