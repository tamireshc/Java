package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes para a classe Banco")
class BancoTest {

  @Test
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {
    Banco banco = new Banco();
    String numeroConta = banco.gerarNumeroNovaConta();
    assertEquals(10, numeroConta.length());
  }

  @Test
  @DisplayName("2 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = banco.adicionarPessoaCliente("John", "091.115.465-98", "1234");
    assertEquals(PessoaCliente.class, pessoaCliente.getClass());
  }

  @Test
  @DisplayName("3 - Testa o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = banco.adicionarPessoaCliente("John", "091.115.465-98", "1234");
    PessoaCliente pessoaClienteLogin = banco.pessoaClienteLogin("091.115.465-98", "1234");
    assertEquals(PessoaCliente.class, pessoaClienteLogin.getClass());

  }

  @Test
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente1 = banco.adicionarPessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    banco.adicionarConta(new Conta("Poupança", pessoaCliente1, banco));
    banco.adicionarConta(new Conta("Corrente", pessoaCliente1, banco));

    banco.depositar(pessoaCliente1, 0, 1000);
    assertEquals(1000, pessoaCliente1.retornarSaldoContaEspecifica(0));

    banco.transferirFundos(pessoaCliente1, 0, 1, 500);
    assertEquals(500, pessoaCliente1.retornarSaldoContaEspecifica(0));
    assertEquals(500, pessoaCliente1.retornarSaldoContaEspecifica(1));
  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente1 = banco.adicionarPessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    banco.adicionarConta(new Conta("Poupança", pessoaCliente1, banco));
    banco.adicionarConta(new Conta("Corrente", pessoaCliente1, banco));

    banco.depositar(pessoaCliente1, 0, 1000);
    assertEquals(1000, pessoaCliente1.retornarSaldoContaEspecifica(0));
    banco.sacar(pessoaCliente1, 0, 200);
    assertEquals(800, pessoaCliente1.retornarSaldoContaEspecifica(0));
  }

}
