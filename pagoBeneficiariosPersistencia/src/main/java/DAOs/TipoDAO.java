/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import entidades.TipoEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eduar
 */
public class TipoDAO implements ITipoDAO{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_pagoBeneficiariosPersistencia_jar_1.0-SNAPSHOTPU");

    @Override
    public TipoEntidad crear(TipoEntidad tipo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(tipo);
        em.getTransaction().commit();
        em.close();
        
        return tipo;
    }
 
    @Override
    public TipoEntidad obtenerPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        TipoEntidad tipo = em.find(TipoEntidad.class, id);
        em.close();
        return tipo;
    }

    @Override
    public List<TipoEntidad> obtenerTodos() {
        EntityManager em = emf.createEntityManager();
        List<TipoEntidad> tipos = em.createQuery("SELECT t FROM TipoEntidad t", TipoEntidad.class).getResultList();
        em.close();
        return tipos;
    }

    @Override
    public TipoEntidad actualizar(TipoEntidad tipo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(tipo);
        em.getTransaction().commit();
        em.close();
        
        return tipo;
    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = emf.createEntityManager();
        TipoEntidad tipo = em.find(TipoEntidad.class, id);
        if (tipo != null) {
            em.getTransaction().begin();
            em.remove(tipo);
            em.getTransaction().commit();
        }
        em.close();
        
    }
}
