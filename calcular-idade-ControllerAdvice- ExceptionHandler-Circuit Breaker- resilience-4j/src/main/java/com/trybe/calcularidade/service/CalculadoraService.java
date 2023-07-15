package com.trybe.calcularidade.service;

import com.trybe.calcularidade.exception.ArgumentoIlegalException;
import com.trybe.calcularidade.exception.DataFuturaException;
import com.trybe.calcularidade.exception.DataInvalidaException;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

/**
 * Classe CalculadoraService.
 **/

@Service
public class CalculadoraService {

  /**
   * Atributos.
   **/


  /**
   * Métodos.
   **/

  public int calcularIdade(String data) {
    String[] componentesData = data.split("-");

    if (componentesData.length != 3) {
      throw new DataInvalidaException("Data Inválida");
    }
    try {
      int dia = Integer.parseInt(componentesData[0]);
      int mes = Integer.parseInt(componentesData[1]);
      int ano = Integer.parseInt(componentesData[2]);

      if (ano > LocalDate.now().getYear()) {
        throw new DataFuturaException("Data Futura");
      }
      if (mes > LocalDate.now().getMonthValue()) {
        return LocalDate.now().getYear() - (ano + 2);
      }
      return LocalDate.now().getYear() - (ano + 1);

    } catch (NumberFormatException e) {
      throw new ArgumentoIlegalException("Data não é número");
    }
  }

}
