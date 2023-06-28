package com.trybe.simuladordepix;

public class ServidorFake implements Servidor {

  @Override
  public Conexao abrirConexao() {
    return new Conexao() {

      @Override
      public void close() {
      }

      @Override
      public String enviarPix(int valor, String chave) {

        return CodigosDeRetorno.SUCESSO;
      }
    };
  }
}
