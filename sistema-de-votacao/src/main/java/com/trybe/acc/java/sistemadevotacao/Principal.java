package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe Principal da aplicação.
 */

public class Principal {

  /**
   * Método Principal da aplicação.
   */

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    boolean registerCandidate = true;

    System.out.println("----------- Bem-vindo ao Sistema de Votação -----------");

    do {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      int option1 = scanner.nextInt();

      if (option1 == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nomeCandidato = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numeroCandidato = scanner.nextInt();
        gerenciamentoVotacao.cadastrarPessoaCandidata(nomeCandidato, numeroCandidato);
      } else if (option1 == 2) {
        registerCandidate = false;
      } else {
        System.out.println("Opção invalida");
      }
    } while (registerCandidate);

    System.out.println("----------- Cadastre as pessoas eleitoras -----------");

    boolean registerVoter = true;

    do {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      int option2 = scanner.nextInt();

      if (option2 == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nomeEleitor = scanner.next();
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpfEleitor = scanner.next();
        gerenciamentoVotacao.cadastrarPessoaEleitora(nomeEleitor, cpfEleitor);
      } else if (option2 == 2) {
        registerVoter = false;
      } else {
        System.out.println("Opção invalida");
      }
    } while (registerVoter);

    System.out.println("----------- Votação iniciada! -----------");

    boolean startVote = true;

    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      int option3 = scanner.nextInt();

      if (option3 == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpfEleitorVotando = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numeroCandidatoVotado = scanner.nextInt();
        gerenciamentoVotacao.votar(cpfEleitorVotando, numeroCandidatoVotado);
      } else if (option3 == 2) {
        gerenciamentoVotacao.mostrarResultado();
      } else if (option3 == 3) {
        gerenciamentoVotacao.mostrarResultado();
        startVote = false;
      }
    } while (startVote);

  }
}

