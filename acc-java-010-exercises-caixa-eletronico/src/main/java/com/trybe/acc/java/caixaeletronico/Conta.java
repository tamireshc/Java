package com.trybe.acc.java.caixaeletronico;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Conta {

  private String tipoConta;
  private String idConta;
  private PessoaCliente pessoaCliente;
  private ArrayList<Transacao> transacoes = new ArrayList<>();

  /**
   * Método Construtor.
   */

  public Conta(String tipoConta, PessoaCliente pessoaCliente, Banco banco) {
    this.tipoConta = tipoConta;
    this.pessoaCliente = pessoaCliente;
    this.idConta = banco.gerarNumeroNovaConta();
  }

  /**
   * Método para adicionar transação.
   */

  public void adicionarTransacao(double quantia, String descricao) {
    Transacao transacao = new Transacao(quantia, descricao);
    transacoes.add(transacao);
  }

  /**
   * Método para retornar saldo.
   */

  public double retornarSaldo() {
    double saldo = 0;
    for (Transacao transacao : transacoes) {
      saldo += transacao.getQuantia();
    }
    return saldo;
  }

  /**
   * Método para retornar resumo da conta.
   */

  public String retornarResumoConta() {
    Locale locale = new Locale("en", "US");
    DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getNumberInstance(locale);
    decimalFormat.applyPattern("0.00");

    System.out.println(this.idConta + " : R$" + decimalFormat.format(retornarSaldo())
        + " : " + this.tipoConta + "\n");
    return "";
  }

  /**
   * Método para retornar extrato.
   */


  public void retornarExtrato() {
    for (Transacao transacao : transacoes) {
      if (transacao.getQuantia() < 0) {
        System.out.println(transacao.retornarResumoTransacao() + " -");
      } else {
        System.out.println(transacao.retornarResumoTransacao() + " +");
      }
    }
  }

  public String getTipoConta() {
    return tipoConta;
  }

  public PessoaCliente getPessoaCliente() {
    return pessoaCliente;
  }

  public String getIdConta() {
    return idConta;
  }

  public ArrayList<Transacao> getTransacoes() {
    return transacoes;
  }
}
