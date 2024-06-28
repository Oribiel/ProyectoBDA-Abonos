package DAOs;

import entidades.PrestamoEntidad;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PrestamoDAO implements IPrestamoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_pagoBeneficiariosPersistencia_jar_1.0-SNAPSHOTPU");

    @Override
    public PrestamoEntidad crear(PrestamoEntidad prestamo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(prestamo);
        em.getTransaction().commit();
        em.close();
        
        return prestamo;
    }

    @Override
    public PrestamoEntidad obtenerPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        PrestamoEntidad prestamo = em.find(PrestamoEntidad.class, id);
        em.close();
        return prestamo;
        
    }

    @Override
    public List<PrestamoEntidad> obtenerTodos() {
        EntityManager em = emf.createEntityManager();
        List<PrestamoEntidad> prestamos = em.createQuery("SELECT p FROM PrestamoEntidad p", PrestamoEntidad.class).getResultList();
        em.close();
        return prestamos;
    }

    @Override
    public PrestamoEntidad actualizar(PrestamoEntidad prestamo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(prestamo);
        em.getTransaction().commit();
        em.close();
        
        return prestamo;
    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = emf.createEntityManager();
        PrestamoEntidad prestamo = em.find(PrestamoEntidad.class, id);
        if (prestamo != null) {
            em.getTransaction().begin();
            em.remove(prestamo);
            em.getTransaction().commit();
        }
        em.close();
    }
}
