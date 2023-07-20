package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.exception.EpisodioExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieNaoEncontradaException;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GerenciadorExceptionController {

  /**
   * Controlador do erro SerieExistenteException.
   */

  @ExceptionHandler(SerieExistenteException.class)
  public ResponseEntity<Map<String, String>> handleSerieExistenteException(
      SerieExistenteException exception
  ) {
    Map<String, String> map = new HashMap<>();
    map.put("error", exception.getMessage());
    return ResponseEntity
      .status(HttpStatus.CONFLICT)
      .body(map);
  }

  /**
   * Controlador do erro EpisodioExistenteException.
   */

  @ExceptionHandler(EpisodioExistenteException.class)
  public ResponseEntity<Map<String, String>> handleEpisodioExistenteException(
      EpisodioExistenteException exception
  ) {
    Map<String, String> map = new HashMap<>();
    map.put("error", exception.getMessage());
    return ResponseEntity
      .status(HttpStatus.CONFLICT)
      .body(map);
  }

  /**
   * Controlador do erro SerieNaoEncontradaException .
   */

  @ExceptionHandler(SerieNaoEncontradaException.class)
  public ResponseEntity<Map<String, String>> handleESerieNaoEncontradaException(
      SerieNaoEncontradaException exception
  ) {
    Map<String, String> map = new HashMap<>();
    map.put("error", exception.getMessage());
    return ResponseEntity
      .status(HttpStatus.NOT_FOUND)
      .body(map);
  }
}
