package com.trybe.acc.java.datacenter.service;

import com.trybe.acc.java.datacenter.entity.Datacenter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class DatacenterService implements ServiceInterface<Datacenter, Long> {
  EntityManagerFactory emf;

  public DatacenterService() {
    this.emf = ServiceInterface.emf;
  }
  /**
   * Método save.
   */

  public void save(Datacenter datacenter) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(datacenter);
    em.getTransaction().commit();
    em.close();
  }


  @Override
  public void delete(Long id) {
    EntityManager em = emf.createEntityManager();
    // Recupera se a entidade a ser deletada
    Datacenter toBeDeleted = em.find(Datacenter.class, id);
    em.getTransaction().begin();
    em.remove(toBeDeleted);
    em.getTransaction().commit();

    em.close();
  }

  @Override
  public void update(Datacenter datacenter) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.merge(datacenter);
    em.getTransaction().commit();

    em.close();
  }

  @Override
  public List<Datacenter> list() {
    EntityManager em = emf.createEntityManager();
    Query query = em.createQuery("from Datacenter");
    return query.getResultList();
  }

  @Override
  public Datacenter findById(Long id) {
    EntityManager em = emf.createEntityManager();
    Datacenter datacenter = em.find(Datacenter.class, id);
    return datacenter;
  }

}
