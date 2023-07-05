package com.trybe.acc.java.caixaeletronico;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes dos métodos da classe Transacao")
class TransacaoTest {


  @Test
  @DisplayName("21 - Testa o método construtor da classe Transacao.")
  void construtorTest() {
    Transacao transacao = new Transacao(200, "Deposito recebido");
    assertEquals(200, transacao.getQuantia());
    assertEquals("Deposito recebido", transacao.getDescricao());
  }


  @Test
  @DisplayName("22 - Testa o método Getter do atributo quantia.")
  void getQuantiaTest() {
    Transacao transacao = new Transacao(200, "Deposito recebido");
    assertEquals(200, transacao.getQuantia());
  }

  @Test
  @DisplayName("23 - Testa o método retornar resumo transacao.")
  void retornarResumoTransacaoTest() {
    Transacao transacao = new Transacao(200, "Deposito recebido");
    assertTrue(transacao.retornarResumoTransacao().contains("Deposito recebido"));
    assertTrue(transacao.retornarResumoTransacao().contains("200"));
  }

  @Test
  @DisplayName("24 - Testa o método instante está gerando o instante corretamente.")
  void retornarInstanteTest() {
    Transacao transacao = new Transacao(200, "Deposito recebido");
    assertTrue(transacao.retornarInstante().length() == 19);
  }
}
