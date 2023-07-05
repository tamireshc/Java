package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

public class PessoaCliente {

  private String nomeCompleto;
  private String cpf;
  private String senha;
  private ArrayList<Conta> contas = new ArrayList<>();

  /**
   * Método Construtor.
   */

  public PessoaCliente(String nomeCompleto, String cpf, String senha) {
    this.nomeCompleto = nomeCompleto;
    this.cpf = cpf;
    this.senha = senha;
    System.out.println("Nova pessoa cliente " + this.nomeCompleto
        + " com CPF: " + this.cpf + " criada!");
  }

  public void adicionarConta(Conta conta) {
    contas.add(conta);
  }

  public int retornaNumeroDeContas() {
    return contas.size();
  }

  public double retornarSaldoContaEspecifica(int indice) {
    return contas.get(indice).retornarSaldo();
  }

  public String retornarIdContaEspecifica(int indice) {
    return contas.get(indice).getIdConta();
  }

  public void retornarExtratoContaEspecifica(int indice) {
    contas.get(indice).retornarExtrato();
  }

  public void adicionarTransacaoContaEspecifica(int indice, double quantia, String descricao) {
    contas.get(indice).adicionarTransacao(quantia, descricao);
  }

  public boolean validarSenha(String senha) {
    return this.senha.equals(senha);
  }

  /**
   * Método para retornar resumo das contas.
   */

  public void retornarResumoContas() {
    System.out.println("\nResumo das Contas da pessoa " + this.getNomeCompleto() + ":\n");
    for (Conta conta : contas) {
      System.out.print(contas.indexOf(conta) + 1 + ") ");
      conta.retornarResumoConta();
    }
  }

  public String getNomeCompleto() {
    return nomeCompleto;
  }

  public String getCpf() {
    return cpf;
  }

  public String getSenha() {
    return senha;
  }

  public ArrayList<Conta> getContas() {
    return contas;
  }
}
