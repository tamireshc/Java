package com.trybe.calcularidade.controller;

import com.trybe.calcularidade.domain.Idade;
import com.trybe.calcularidade.service.CalculadoraService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Classe CalcularDataController.
 **/

@RestController
@RequestMapping(value = "/")
public class CalcularDataController {

  /**
   * Atributos.
   **/
  @Autowired
  CalculadoraService calculadoraService;

  /**
   * Métodos.
   **/

  @GetMapping
  //  @CircuitBreaker(name = "idade", fallbackMethod = "fallback")
  public Map<String, Integer> calcularIdade(@RequestParam("data") String data) {
    Map<String, Integer> map = new HashMap<String, Integer>();
    int idadeNumber = calculadoraService.calcularIdade(data);
    map.put("idade", idadeNumber);
    return map;
  }

  /**
   * Métodos fallback.
   **/

  public Map<String, Integer> fallback(RuntimeException e) {
    Map<String, Integer> map = new HashMap<String, Integer>();
    map.put("idade", 0);
    return map;
  }
}
