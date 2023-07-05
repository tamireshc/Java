package com.trybe.acc.java.caixaeletronico;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Teste dos métodos da classe PessoaCliente")
class PessoaClienteTest {

  @Test
  @DisplayName("12 - Testa o construtor da classe Pessoa Cliente.")
  void construtorTest() {
    PessoaCliente pessoaCliente1 = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    assertEquals("Alexiania Pereira", pessoaCliente1.getNomeCompleto());
    assertEquals("842.074.410-77", pessoaCliente1.getCpf());
    assertEquals("1234", pessoaCliente1.getSenha());
  }

  @Test
  @DisplayName("13 - Testa o método adicionar conta e o método retornar número de contas.")
  void adicionarContaTestRetornaNumeroDeContasTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente1 = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Poupança", pessoaCliente1, banco);
    pessoaCliente1.adicionarConta(conta);
    assertEquals(1, pessoaCliente1.retornaNumeroDeContas());
  }

  @Test
  @DisplayName("14 - Testa o método retornar saldo de uma conta específica da pessoa cliente.")
  void retornarSaldoContaEspecificaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente1 = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Poupança", pessoaCliente1, banco);
    pessoaCliente1.adicionarConta(conta);
    banco.depositar(pessoaCliente1, 0, 200);

    assertEquals(200, pessoaCliente1.retornarSaldoContaEspecifica(0));
  }


  @Test
  @DisplayName("15 - Testa o método retornar id de uma conta específica da pessoa cliente.")
  void retornarIdContaEspecificaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente1 = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Poupança", pessoaCliente1, banco);
    pessoaCliente1.adicionarConta(conta);

    assertEquals(10, pessoaCliente1.retornarIdContaEspecifica(0).length());
  }

  @Test
  @DisplayName("16 - Testa o método retornar o extrato de uma conta específica da pessoa cliente.")
  void retornarExtratoContaEspecificaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente1 = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Poupança", pessoaCliente1, banco);
    pessoaCliente1.adicionarConta(conta);
    banco.depositar(pessoaCliente1, 0, 200);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    System.setOut(ps);
    pessoaCliente1.retornarExtratoContaEspecifica(0);
    assertTrue(baos.toString().contains("200"));
  }

  @Test
  @DisplayName("17 - Testa o método adiciona transacao de uma conta específica da pessoa cliente.")
  void adicionarTransacaoContaEspecificaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente1 = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Poupança", pessoaCliente1, banco);
    pessoaCliente1.adicionarConta(conta);
    pessoaCliente1.adicionarTransacaoContaEspecifica(0, 300, "Deposito recebido");
    assertEquals(300, conta.getTransacoes().get(0).getQuantia());
  }

  @Test
  @DisplayName("18 - Testa o método validar senha.")
  void validarSenhaTest() {
    PessoaCliente pessoaCliente1 = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    assertTrue(pessoaCliente1.validarSenha(pessoaCliente1.getSenha()));
  }

  @Test
  @DisplayName("19 - Testa o método retornar resumo contas.")
  void retornarResumoContasTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente1 = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Poupança", pessoaCliente1, banco);
    pessoaCliente1.adicionarConta(conta);
    banco.depositar(pessoaCliente1, 0, 200);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    System.setOut(ps);
    pessoaCliente1.retornarResumoContas();
    assertTrue(baos.toString().contains("200"));
    assertTrue(baos.toString().contains("Alexiania Pereira"));
    assertTrue(baos.toString().contains("Poupança"));
  }

  @Test
  @DisplayName("20 - Testa o método Getter do atributo cpf está retornando.")
  void getCpfTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente1 = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    assertEquals("842.074.410-77", pessoaCliente1.getCpf());
  }

}
