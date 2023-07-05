package com.trybe.acc.java.caixaeletronico;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Transacao {
  private double quantia;
  private String instante;
  private String descricao;
  private Conta conta;

  /**
   * Método Construtor.
   */

  public Transacao(double quantia, String descricao) {
    this.quantia = quantia;
    this.descricao = descricao;
    this.instante = retornarInstante();
  }

  public double getQuantia() {
    return quantia;
  }

  public String getDescricao() {
    return descricao;
  }

  /**
   * Método para retornar resumo da transação.
   */

  public String retornarResumoTransacao() {
    Locale locale = new Locale("en", "US");
    DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getNumberInstance(locale);
    decimalFormat.applyPattern("0.00");

    return this.instante + " -------- " + this.descricao + ": R$ "
        + decimalFormat.format(this.quantia);
  }

  /**
   * Método para retornar instante de uma transação.
   */

  public String retornarInstante() {
    String formato = "dd/MM/yyyy HH:mm:ss";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
    LocalDateTime dataHora = LocalDateTime.now();

    return dataHora.format(formatter);
  }
}

