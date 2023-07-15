package com.trybe.calcularidade.exception;

/**
 * Classe DataFuturaException.
 **/

@SuppressWarnings("serial")
public class DataFuturaException extends RuntimeException {
  public DataFuturaException(String message) {
    super(message);
  }
}
