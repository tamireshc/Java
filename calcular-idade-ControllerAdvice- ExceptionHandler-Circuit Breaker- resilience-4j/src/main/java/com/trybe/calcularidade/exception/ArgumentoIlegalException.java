package com.trybe.calcularidade.exception;

/**
 * Classe ArgumentoIlegalException.
 **/

@SuppressWarnings("serial")
public class ArgumentoIlegalException extends RuntimeException {
  public ArgumentoIlegalException(String message) {
    super(message);
  }
}
