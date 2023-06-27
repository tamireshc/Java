package com.trybe.conversorcsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


public class Conversor {

  /**
   * Função utilizada apenas para validação da solução do desafio.
   *
   * @param args Não utilizado.
   * @throws IOException Caso ocorra algum problema ao ler os arquivos de entrada ou
   *                     gravar os arquivos de saída.
   */
  public static void main(String[] args) throws NullPointerException {
    try{
      File pastaDeEntradas = new File("./entradas/");
      File pastaDeSaidas = new File("./saidas/");
      new Conversor().converterPasta(pastaDeEntradas, pastaDeSaidas);
    }catch (NullPointerException e){
      System.out.println(e.getMessage());
    }
  }

  /**
   * Converte todos os arquivos CSV da pasta de entradas. Os resultados são gerados
   * na pasta de saídas, deixando os arquivos originais inalterados.
   *
   * @param pastaDeEntradas Pasta contendo os arquivos CSV gerados pela página web.
   * @param pastaDeSaidas   Pasta em que serão colocados os arquivos gerados no formato
   *                        requerido pelo subsistema.
   */
  public void converterPasta(File pastaDeEntradas, File pastaDeSaidas) {
    BufferedWriter bufferedWriter = null;
    BufferedReader bufferedReader = null;
    String linha;

    if (!pastaDeSaidas.exists()) {
      pastaDeSaidas.mkdir();
    }

    try {
      for (File file : Objects.requireNonNull(pastaDeEntradas.listFiles())) {
        bufferedReader = new BufferedReader(new FileReader(file));
        bufferedWriter = new BufferedWriter(new FileWriter(pastaDeSaidas + "/" + file.getName()));

        while ((linha = bufferedReader.readLine()) != null) {
          String[] itemLinha = linha.split(",");
          if (!itemLinha[0].equals("Nome completo")
              && !itemLinha[1].equals("Data de nascimento")
              && !itemLinha[2].equals("Email")
              && !itemLinha[3].equals("CPF")) {
            bufferedWriter.write(itemLinha[0].toUpperCase() + ",");
            bufferedWriter.write(formatadorData(itemLinha[1]) + ",");
            bufferedWriter.write(itemLinha[2] + ",");
            bufferedWriter.write(itemLinha[3].substring(0, 3) + "."
                + itemLinha[3].substring(3, 6) + "." + itemLinha[3].substring(6, 9)
                + "-" + itemLinha[3].substring(9, 11));
            bufferedWriter.flush();
            bufferedWriter.newLine();
          } else {
            bufferedWriter.write(itemLinha[0] + ",");
            bufferedWriter.write(itemLinha[1] + ",");
            bufferedWriter.write(itemLinha[2] + ",");
            bufferedWriter.write(itemLinha[3]);
            bufferedWriter.flush();
            bufferedWriter.newLine();
          }
        }
      }
    } catch (IOException | NullPointerException e) {
      System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
    } finally {
      closeFile(bufferedReader, bufferedWriter);
    }
  }

  /**
   * Método Formatador de datas.
   */

  private String formatadorData(String data) {
    String formatoEntradaData = "dd/MM/yyyy";
    String novoFormatoData = "yyyy-MM-dd";

    DateFormat formatoEntrada = new SimpleDateFormat(formatoEntradaData);
    DateFormat formatoSaida = new SimpleDateFormat(novoFormatoData);

    try {
      Date dataEntrada = formatoEntrada.parse(data);
      return formatoSaida.format(dataEntrada);
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Método para fechar arquivos abertos.
   */

  private void closeFile(BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
    try {
      bufferedReader.close();
      bufferedWriter.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}