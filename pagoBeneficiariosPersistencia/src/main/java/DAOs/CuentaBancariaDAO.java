/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import entidades.CuentaBancariaEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 *
 * @author eduar
 */
public class CuentaBancariaDAO implements ICuentaBancariaDAO{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_pagoBeneficiariosPersistencia_jar_1.0-SNAPSHOTPU");

    @Override
    public CuentaBancariaEntidad crear(CuentaBancariaEntidad cuentaBancaria) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(cuentaBancaria);
        em.getTransaction().commit();
        em.close();
        
        return cuentaBancaria;
    }

    @Override
    public CuentaBancariaEntidad obtenerPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        CuentaBancariaEntidad cuentaBancaria = em.find(CuentaBancariaEntidad.class, id);
        em.close();
        return cuentaBancaria;
    }

    @Override
    public List<CuentaBancariaEntidad> obtenerTodos() throws PersistenceException{
        EntityManager em = emf.createEntityManager();
        List<CuentaBancariaEntidad> cuentasBancarias = em.createQuery("SELECT c FROM CuentaBancariaEntidad c", CuentaBancariaEntidad.class).getResultList();
        em.close();
        return cuentasBancarias;
    }

    @Override
    public CuentaBancariaEntidad actualizar(CuentaBancariaEntidad cuentaBancaria) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(cuentaBancaria);
        em.getTransaction().commit();
        em.close();
        
        return cuentaBancaria;
    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = emf.createEntityManager();
        CuentaBancariaEntidad cuentaBancaria = em.find(CuentaBancariaEntidad.class, id);
        if (cuentaBancaria != null) {
            em.getTransaction().begin();
            em.remove(cuentaBancaria);
            em.getTransaction().commit();
        }
        em.close();
    }
}
