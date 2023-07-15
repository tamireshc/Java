package com.trybe.calcularidade.controller;

import com.trybe.calcularidade.exception.ArgumentoIlegalException;
import com.trybe.calcularidade.exception.DataError;
import com.trybe.calcularidade.exception.DataFuturaException;
import com.trybe.calcularidade.exception.DataInvalidaException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



/**
 * Classe GerenciadorAdvice.
 **/

@ControllerAdvice
public class GerenciadorAdvice {


  /**
   * Métodos.
   **/
  @ExceptionHandler(ArgumentoIlegalException.class)

  public ResponseEntity handlerInternalServerError(Exception exception) {
    Map<String, String> map = new HashMap<>();
    map.put("error", exception.getMessage());

    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(map);
  }

  /**
   * Métodos.
   **/

  @ExceptionHandler({DataInvalidaException.class, DataFuturaException.class})
  public ResponseEntity handlerBadRequest(Exception exception) {
    Map<String, String> map = new HashMap<>();
    map.put("error", exception.getMessage());

    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(map);
  }

  //  @ExceptionHandler(DataInvalidaException.class)
  //  public ResponseEntity<String> handlerBadRequest(DataFuturaException exception) {
  //    return ResponseEntity
  //      .status(HttpStatus.BAD_REQUEST)
  //      .body("error: " + exception.getMessage());
  //  }
}
