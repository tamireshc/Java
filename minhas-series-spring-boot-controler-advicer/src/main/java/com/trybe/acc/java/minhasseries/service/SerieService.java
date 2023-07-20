package com.trybe.acc.java.minhasseries.service;

import com.trybe.acc.java.minhasseries.exception.EpisodioExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieNaoEncontradaException;
import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.model.SerieRequest;
import com.trybe.acc.java.minhasseries.repository.SerieRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerieService {
  @Autowired
  SerieRepository serieRepository;

  /**
   * Método post.
   */

  public Serie post(SerieRequest serieRequest) {
    boolean serieExist = serieRepository.existsByNome(serieRequest.getNome());
    if (serieExist) {
      throw new SerieExistenteException("Série Existente");
    }
    Serie serie = new Serie(serieRequest.getNome());
    Serie result = serieRepository.save(serie);
    return result;
  }

  /**
   * Método findAll.
   */

  public List<Serie> findAll() {
    List<Serie> series = serieRepository.findAll();
    return series;
  }

  /**
   * Método delete.
   */

  public void delete(Integer id) {
    Serie serie = serieRepository.findById(id)
        .orElseThrow(() -> new SerieNaoEncontradaException("Série não encontrada"));
    serieRepository.deleteById(id);
  }

  /**
   * Método add episodio em uma série.
   */

  public Serie addEpisodioAtSerie(Integer id, Episodio episodio) {
    Serie serie = serieRepository.findById(id)
        .orElseThrow(() -> new SerieNaoEncontradaException("Série não encontrada"));
    for (Episodio episodioSerie : serie.getEpisodios()) {
      if (episodioSerie.getNumero() == episodio.getNumero()) {
        throw new EpisodioExistenteException("Episódio Existente");
      }
    }
    Episodio episodioAdd =
        new Episodio(
          serie.getEpisodios().size(),
          episodio.getNumero(),
          episodio.getDuracaoEmMinutos(),
          serie);
    serie.adicionarEpisodio(episodioAdd);
    System.out.println(serie.getEpisodios());
    Serie serieAdded = serieRepository.save(serie);
    return serieAdded;
  }

  /**
   * Método para exibir os episódios de uma série.
   */

  public List<Episodio> showEpisodiosbySerie(Integer id) {
    Serie serie = serieRepository.findById(id)
        .orElseThrow(() -> new SerieNaoEncontradaException("Série não encontrada"));
    return serie.getEpisodios();
  }

  /**
   * Método para exibir o tempo gasto vendo séries.
   */

  public int showTimeSpentWatchingSeries() {
    List<Serie> series = this.findAll();
    int time = 0;
    for (Serie serie : series) {
      for (Episodio episodio : serie.getEpisodios()) {
        time += episodio.getDuracaoEmMinutos();
      }
    }
    return time;
  }
}
