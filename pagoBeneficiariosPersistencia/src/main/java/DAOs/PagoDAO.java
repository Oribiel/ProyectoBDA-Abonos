/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import entidades.PagoEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eduar
 */
public class PagoDAO implements IPagoDAO{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_pagoBeneficiariosPersistencia_jar_1.0-SNAPSHOTPU");

    @Override
    public PagoEntidad crear(PagoEntidad pago) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pago);
        em.getTransaction().commit();
        em.close();
        
        return pago;
    }

    @Override
    public PagoEntidad obtenerPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        PagoEntidad pago = em.find(PagoEntidad.class, id);
        em.close();
        return pago;
    }

    @Override
    public List<PagoEntidad> obtenerTodos() {
        EntityManager em = emf.createEntityManager();
        List<PagoEntidad> pagos = em.createQuery("SELECT p FROM PagoEntidad p", PagoEntidad.class).getResultList();
        em.close();
        return pagos;
    }

    @Override
    public PagoEntidad actualizar(PagoEntidad pago) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(pago);
        em.getTransaction().commit();
        em.close();
        
        return pago;
    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = emf.createEntityManager();
        PagoEntidad pago = em.find(PagoEntidad.class, id);
        if (pago != null) {
            em.getTransaction().begin();
            em.remove(pago);
            em.getTransaction().commit();
        }
        em.close();
    }
}
