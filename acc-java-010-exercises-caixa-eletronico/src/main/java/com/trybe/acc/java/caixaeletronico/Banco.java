package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.Random;

public class Banco {
  private ArrayList<PessoaCliente> pessoasClientes = new ArrayList<>();
  private ArrayList<Conta> contas = new ArrayList<>();

  /**
   * Método de gerar numero para as contas.
   */

  public String gerarNumeroNovaConta() {
    Random ran = new Random();
    StringBuilder stringBuilder = new StringBuilder();
    StringBuilder numeroConta = new StringBuilder();
    while (numeroConta.length() < 10) {
      int numeroAleatorio = ran.nextInt(9) + 1;
      numeroConta.append(numeroAleatorio);
    }
    if (contas.contains(numeroConta.toString())) {
      numeroConta = new StringBuilder();
    }

    return numeroConta.toString();
  }

  /**
   * Método para adicionar Pessoa Cliente.
   */

  public PessoaCliente adicionarPessoaCliente(String nome, String cpf, String senha) {
    PessoaCliente pessoaCliente = new PessoaCliente(nome, cpf, senha);
    pessoasClientes.add(pessoaCliente);
    return pessoaCliente;
  }

  /**
   * Método para adicionar Conta.
   */

  public void adicionarConta(Conta conta) {
    contas.add(conta);
    conta.getPessoaCliente().adicionarConta(conta);
  }

  /**
   * Método para fazer login.
   */

  public PessoaCliente pessoaClienteLogin(String cpf, String senha) {
    for (PessoaCliente pessoaCliente : pessoasClientes) {
      if (pessoaCliente.getCpf().equals(cpf) && pessoaCliente.getSenha().equals(senha)) {
        return pessoaCliente;
      }
    }
    return null;
  }

  /**
   * Método para fazer transferencias.
   */

  public void transferirFundos(
      PessoaCliente pessoaCliente,
      int daConta,
      int paraConta,
      double quantia
  ) {
    pessoaCliente.adicionarTransacaoContaEspecifica(daConta, -quantia, "Tranferencia enviada");
    pessoaCliente.adicionarTransacaoContaEspecifica(paraConta, quantia, "Tranferencia recebida");
  }

  /**
   * Método para realizar saques.
   */

  public void sacar(PessoaCliente pessoaCliente, int daConta, double quantia) {
    pessoaCliente.adicionarTransacaoContaEspecifica(daConta, -quantia, "Saque realizado");
  }

  /**
   * Método para realizar depositos.
   */

  public void depositar(PessoaCliente pessoaCliente, int daConta, double quantia) {
    pessoaCliente.adicionarTransacaoContaEspecifica(daConta, quantia, "Deposito recebido");
  }

  /**
   * Método para mostrar extratos.
   */

  public void mostrarExtrato(PessoaCliente pessoaCliente, int contaIndex) {
    System.out.println("\n" + "Extrato da conta "
        + pessoaCliente.getContas().get(contaIndex).getIdConta() + "\n");
    pessoaCliente.getContas().get(contaIndex).retornarExtrato();
  }

}
