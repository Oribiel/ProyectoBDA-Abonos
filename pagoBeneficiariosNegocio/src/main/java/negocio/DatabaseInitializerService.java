/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import entidades.EstatusEntidad;
import entidades.TipoEntidad;
import excepciones.NegocioException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author eduar
 */
public class DatabaseInitializerService {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("com.mycompany_pagoBeneficiariosPersistencia_jar_1.0-SNAPSHOTPU");

    public void initializeDatabase() throws NegocioException {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

        try {
            em.getTransaction().begin();

            if (!tipoExists(em, 1L)) {
                insertTipo(em, 1L, "SABATICO", 7);
            }
            if (!estatusExists(em, 0L)) {
                insertEstatus(em, 0L, "CREADO");
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new NegocioException("Error al inicializar la base de datos: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    private boolean tipoExists(EntityManager em, Long idTipo) {
        try {
            TipoEntidad tipo = em.find(TipoEntidad.class, idTipo);
            return tipo != null;
        } catch (NoResultException e) {
            return false;
        }
    }

    private void insertTipo(EntityManager em, Long id, String nombre, int numeroParcialidades) {
        TipoEntidad tipo = new TipoEntidad();
        tipo.setId(id);
        tipo.setNombre(nombre);
        tipo.setNumeroParcialidades(numeroParcialidades);
        em.persist(tipo);
    }

    private boolean estatusExists(EntityManager em, Long idEstatus) {
        try {
            EstatusEntidad estatus = em.find(EstatusEntidad.class, idEstatus);
            return estatus != null;
        } catch (NoResultException e) {
            return false;
        }
    }

    private void insertEstatus(EntityManager em, Long id, String nombre) {
        EstatusEntidad estatus = new EstatusEntidad();
        estatus.setId(id);
        estatus.setNombre(nombre);
        em.persist(estatus);
    }
}
