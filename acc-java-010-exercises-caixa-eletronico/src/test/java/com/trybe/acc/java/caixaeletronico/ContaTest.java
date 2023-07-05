package com.trybe.acc.java.caixaeletronico;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Teste da classe Conta")
class ContaTest {

  @Test
  @DisplayName("6 - Testa o construtor da classe conta.")
  void construtorTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente1 = banco.adicionarPessoaCliente("John", "091.115.465-98", "1234");
    Conta conta = new Conta("Poupança", pessoaCliente1, banco);
    banco.adicionarConta(conta);

    assertEquals(10, conta.getIdConta().length());
    assertEquals("Poupança", conta.getTipoConta());
    assertEquals(pessoaCliente1, conta.getPessoaCliente());
  }

  @Test
  @DisplayName("7 - Testa o método adicionar transação e retornar saldo da conta.")
  void adicionarTransacaoTestRetornarSaldoTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente1 = banco.adicionarPessoaCliente("John", "091.115.465-98", "1234");
    Conta conta = new Conta("Poupança", pessoaCliente1, banco);
    conta.adicionarTransacao(500, "Deposito recebido");
    assertEquals(500, conta.getTransacoes().get(0).getQuantia());
    assertEquals("Deposito recebido", conta.getTransacoes().get(0).getDescricao());
  }

  @Test
  @DisplayName("8 - Testa o método retornar resumo está retornando uma string com os valores corretamente.")
  void retornarResumoContaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente1 = banco.adicionarPessoaCliente("John", "091.115.465-98", "1234");
    Conta conta = new Conta("Poupança", pessoaCliente1, banco);
    conta.adicionarTransacao(500, "Deposito recebido");

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    System.setOut(ps);
    conta.retornarResumoConta();

    assertTrue(baos.toString().contains("500"));
    assertTrue(baos.toString().contains("Poupança"));
  }

  @Test
  @DisplayName("9 - Testa o método retornar extrato está imprimindo os valores corretamente.")
  void retornarExtratoTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente1 = banco.adicionarPessoaCliente("John", "091.115.465-98", "1234");
    Conta conta = new Conta("Poupança", pessoaCliente1, banco);
    conta.adicionarTransacao(500, "Deposito recebido");

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    System.setOut(ps);
    conta.retornarExtrato();

    assertTrue(baos.toString().contains("500"));
    assertTrue(baos.toString().contains("Deposito recebido"));
  }

  @Test
  @DisplayName("10 - Testa o método Getter do atributo idConta está retornando.")
  void getIdContaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente1 = banco.adicionarPessoaCliente("John", "091.115.465-98", "1234");
    Conta conta = new Conta("Poupança", pessoaCliente1, banco);
    assertEquals(10, conta.getIdConta().length());

  }

  @Test
  @DisplayName("11 - Testa o método método Getter do atributo pessoaCliente está retornando.")
  void getPessoaClienteTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente1 = banco.adicionarPessoaCliente("John", "091.115.465-98", "1234");
    Conta conta = new Conta("Poupança", pessoaCliente1, banco);
    assertEquals("John", conta.getPessoaCliente().getNomeCompleto());
  }
}
