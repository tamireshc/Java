package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

/**
 * Class Gerenciamento Votação responsável pelo gerenciamento do sistema de votação.
 */

public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  private ArrayList<String> cpfComputado = new ArrayList<>();
  private int totalVotos = 0;

  /**
   * Método para cadastrar pessoa candidata.
   */

  public void cadastrarPessoaCandidata(String nome, int numero) {
    System.out.println("cadastrando canditadot");
    System.out.println(nome);
    System.out.println(numero);
    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      if (pessoaCandidata.getNumero() == numero) {
        System.out.println("Número pessoa candidata já utilizado!");
      }
    }
    PessoaCandidata candidato = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(candidato);
    System.out.println(pessoasCandidatas.get(0).nome);
  }

  /**
   * Método para cadastrar pessoa eleitora.
   */

  public void cadastrarPessoaEleitora(String nome, String cpf) {
    System.out.println("cadastrando eleirort");
    for (PessoaEleitora pessoaEleitor : pessoasEleitoras) {
      if (pessoaEleitor.getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
      }
    }
    PessoaEleitora eleitor = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(eleitor);
    System.out.println(pessoasEleitoras.get(0));
  }

  /**
   * Método para registrar votos.
   */

  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    System.out.println("votando");
    for (String cpf : cpfComputado) {
      if (cpfPessoaEleitora.equals(cpf)) {
        System.out.println("Pessoa eleitora já votou!");
      }
    }
    for (PessoaCandidata canditado : pessoasCandidatas) {
      System.out.println(numeroPessoaCandidata);
      if (canditado.getNumero() == numeroPessoaCandidata) {
        System.out.println("votou");
        canditado.receberVoto();
        cpfComputado.add(cpfPessoaEleitora);
        totalVotos = totalVotos + 1;

      }
    }
  }

  /**
   * Método para exibir no console o resultado.
   */

  public void mostrarResultado() {
    int index = 0;
    if (totalVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      System.out.println(totalVotos);
    } else {
      for (PessoaCandidata candidato : pessoasCandidatas) {
        System.out.println("Nome: " + candidato.getNome()
            + " - " + candidato.getVotos() + " ( " + this.calcularPorcentagemVotos(index) + "% )");
        index += 1;
      }
      System.out.println("Total de votos: " + totalVotos);
    }
  }

  /**
   * Método para calcular porcentagem de votos.
   */

  private double calcularPorcentagemVotos(int index) {
    float voutes = pessoasCandidatas.get(index).getNumero();
    float total = totalVotos;
    float result = Math.round((voutes / total) * 100);
    return result;
  }
}
