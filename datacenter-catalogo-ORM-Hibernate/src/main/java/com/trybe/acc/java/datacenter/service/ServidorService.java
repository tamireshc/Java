package com.trybe.acc.java.datacenter.service;

import com.trybe.acc.java.datacenter.entity.Servidor;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class ServidorService implements ServiceInterface<Servidor, Long> {
  EntityManagerFactory emf;

  public ServidorService() {
    this.emf = ServiceInterface.emf;
  }

  /**
   * Método save.
   */

  public void save(Servidor servidor) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(servidor);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public void delete(Long id) {
    EntityManager em = emf.createEntityManager();
    // Recupera se a entidade a ser deletada
    Servidor toBeDeleted = em.find(Servidor.class, id);
    em.getTransaction().begin();
    em.remove(toBeDeleted);
    em.getTransaction().commit();

    em.close();
  }

  @Override
  public void update(Servidor servidor) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.merge(servidor);
    em.getTransaction().commit();

    em.close();
  }

  @Override
  public List<Servidor> list() {
    EntityManager em = emf.createEntityManager();
    Query query = em.createQuery("from Servidor");
    return query.getResultList();
  }

  @Override
  public Servidor findById(Long id) {
    EntityManager em = emf.createEntityManager();
    Servidor servidor = em.find(Servidor.class, id);
    return servidor;
  }
}
