/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import entidades.EstatusEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eduar
 */
public class EstatusDAO implements IEstatusDAO{
    
private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_pagoBeneficiariosPersistencia_jar_1.0-SNAPSHOTPU");

    @Override
    public EstatusEntidad crear(EstatusEntidad estatus) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(estatus);
        em.getTransaction().commit();
        em.close();
        
        return estatus;
    }

    @Override
    public EstatusEntidad obtenerPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        EstatusEntidad estatus = em.find(EstatusEntidad.class, id);
        em.close();
        return estatus;
    }

    @Override
    public List<EstatusEntidad> obtenerTodos() {
        EntityManager em = emf.createEntityManager();
        List<EstatusEntidad> estatuses = em.createQuery("SELECT e FROM EstatusEntidad e", EstatusEntidad.class).getResultList();
        em.close();
        return estatuses;
    }

    @Override
    public EstatusEntidad actualizar(EstatusEntidad estatus) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(estatus);
        em.getTransaction().commit();
        em.close();
        
        return estatus;
    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = emf.createEntityManager();
        EstatusEntidad estatus = em.find(EstatusEntidad.class, id);
        if (estatus != null) {
            em.getTransaction().begin();
            em.remove(estatus);
            em.getTransaction().commit();
        }
        em.close();
    }
}
