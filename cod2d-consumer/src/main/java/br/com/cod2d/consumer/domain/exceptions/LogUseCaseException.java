package br.com.cod2d.consumer.domain.exceptions;

public class LogUseCaseException extends RuntimeException {
  public LogUseCaseException(final String message) {
    super(message);
  }
}
