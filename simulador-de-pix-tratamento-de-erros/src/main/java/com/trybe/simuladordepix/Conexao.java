package com.trybe.simuladordepix;

import java.io.Closeable;
import java.io.IOException;

public interface Conexao extends Closeable {

  String enviarPix(int valor, String chave) throws IOException;
}
