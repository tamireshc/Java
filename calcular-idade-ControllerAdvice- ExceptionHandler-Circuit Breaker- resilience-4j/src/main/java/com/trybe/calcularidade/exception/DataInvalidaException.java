package com.trybe.calcularidade.exception;

/**
 * Classe DataInvalidaException.
 **/

@SuppressWarnings("serial")
public class DataInvalidaException extends RuntimeException {
  public DataInvalidaException(String message) {
    super(message);
  }
}
