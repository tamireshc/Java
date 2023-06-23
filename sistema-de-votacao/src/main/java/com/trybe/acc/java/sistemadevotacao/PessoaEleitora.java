package com.trybe.acc.java.sistemadevotacao;

/**
 * Classe que representa um eleitor.
 */

public class PessoaEleitora extends Pessoa {
  private String cpf;

  /**
   * Construtor da classe Pessoa eleitora.
   */

  public PessoaEleitora(String nome, String cpf) {
    this.cpf = cpf;
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
