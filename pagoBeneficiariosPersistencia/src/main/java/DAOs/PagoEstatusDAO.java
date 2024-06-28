/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import entidades.PagoEstatusEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eduar
 */
public class PagoEstatusDAO implements IPagoEstatusDAO{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_pagoBeneficiariosPersistencia_jar_1.0-SNAPSHOTPU");

    @Override
    public PagoEstatusEntidad crear(PagoEstatusEntidad pagoEstatus) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pagoEstatus);
        em.getTransaction().commit();
        em.close();
        
        return pagoEstatus;
    }

    @Override
    public PagoEstatusEntidad obtenerPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        PagoEstatusEntidad pagoEstatus = em.find(PagoEstatusEntidad.class, id);
        em.close();
        return pagoEstatus;
    }

    @Override
    public List<PagoEstatusEntidad> obtenerTodos() {
        EntityManager em = emf.createEntityManager();
        List<PagoEstatusEntidad> pagoEstatusList = em.createQuery("SELECT pe FROM PagoEstatusEntidad pe", PagoEstatusEntidad.class).getResultList();
        em.close();
        return pagoEstatusList;
    }

    @Override
    public PagoEstatusEntidad actualizar(PagoEstatusEntidad pagoEstatus) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(pagoEstatus);
        em.getTransaction().commit();
        em.close();
        
        return pagoEstatus;
    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = emf.createEntityManager();
        PagoEstatusEntidad pagoEstatus = em.find(PagoEstatusEntidad.class, id);
        if (pagoEstatus != null) {
            em.getTransaction().begin();
            em.remove(pagoEstatus);
            em.getTransaction().commit();
        }
        em.close();
    }
}
