package com.trybe.acc.java.sistemadevotacao;

/**
 * Classe Pessoa Candidata a eleição.
 */

public class PessoaCandidata extends Pessoa {
  private int numero;
  private int votos;

  /**
   * Construtor da classe Pessoa.
   */

  public PessoaCandidata(String nome, int numero) {
    this.nome = nome;
    this.numero = numero;
    this.votos = 0;
  }

  public void receberVoto() {
    this.votos += 1;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void setVotos(int votos) {
    this.votos = votos;
  }
}
