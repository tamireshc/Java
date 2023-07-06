package com.trybe.acc.java.datacenter.service;

import com.trybe.acc.java.datacenter.entity.Aplicacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class AplicacaoService implements ServiceInterface<Aplicacao, Long> {
  EntityManagerFactory emf;

  public AplicacaoService() {
    this.emf = ServiceInterface.emf;
  }

  /**
   * Método save.
   */

  public void save(Aplicacao aplicacao) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(aplicacao);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public void delete(Long id) {
    EntityManager em = emf.createEntityManager();
    // Recupera se a entidade a ser deletada
    Aplicacao toBeDeleted = em.find(Aplicacao.class, id);
    em.getTransaction().begin();
    em.remove(toBeDeleted);
    em.getTransaction().commit();

    em.close();
  }

  @Override
  public void update(Aplicacao aplicacao) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.merge(aplicacao);
    em.getTransaction().commit();

    em.close();
  }

  @Override
  public List<Aplicacao> list() {
    EntityManager em = emf.createEntityManager();
    Query query = em.createQuery("from Aplicacao");
    return query.getResultList();
  }

  @Override
  public Aplicacao findById(Long id) {
    EntityManager em = emf.createEntityManager();
    Aplicacao aplicacao = em.find(Aplicacao.class, id);
    return aplicacao;
  }

}
