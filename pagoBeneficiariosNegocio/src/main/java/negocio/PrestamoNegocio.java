/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.IPrestamoDAO;
import DAOs.PrestamoDAO;
import DTO.PrestamoDTO;
import entidades.PrestamoEntidad;
import excepciones.NegocioException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Arturo ITSON
 */
public class PrestamoNegocio implements IPrestamoNegocio{
   
   private IPrestamoDAO prestamoDAO = new PrestamoDAO();

    public PrestamoNegocio(IPrestamoDAO prestamoDAO) {
        this.prestamoDAO = prestamoDAO;
    }

    public PrestamoNegocio() {
        
    }

    @Override
    public PrestamoDTO crear(PrestamoDTO prestamo) throws NegocioException {
        PrestamoEntidad entidad = new PrestamoEntidad();
        entidad.setMonto(prestamo.getMonto());
        System.out.println(prestamo.getMonto());
        entidad.setFecha(prestamo.getFecha());
        System.out.println(prestamo.getFecha());
        entidad.setParcialidades(prestamo.getParcialidades());
        System.out.println(prestamo.getParcialidades());
        prestamoDAO.crear(entidad);
        
        return prestamo;
    }

    @Override
    public PrestamoDTO obtenerPorId(Long id) throws NegocioException {
        try {
            PrestamoEntidad entidad = prestamoDAO.obtenerPorId(id);
            if (entidad == null) {
                throw new NegocioException("Prestamo no encontrado");
            }
            return new PrestamoDTO(entidad.getId(), entidad.getMonto(), entidad.getFecha(), entidad.getParcialidades());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener el prestamo por id", e);
        }
    }

    @Override
    public List<PrestamoDTO> obtenerTodos() throws NegocioException {
        try {
            return prestamoDAO.obtenerTodos().stream()
                    .map(entidad -> new PrestamoDTO(entidad.getId(), entidad.getMonto(), entidad.getFecha(), entidad.getParcialidades()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener todos los prestamos", e);
        }
    }

    @Override
    public PrestamoDTO actualizar(PrestamoDTO prestamo) throws NegocioException {
        try {
            PrestamoEntidad entidad = prestamoDAO.obtenerPorId(prestamo.getId());
            if (entidad == null) {
                throw new NegocioException("Prestamo no encontrado");
            }
            entidad.setMonto(prestamo.getMonto());
            entidad.setFecha(prestamo.getFecha());
            entidad.setParcialidades(prestamo.getParcialidades());
            prestamoDAO.actualizar(entidad);
        } catch (Exception e) {
            throw new NegocioException("Error al actualizar el prestamo", e);
        }
        
        return prestamo;
    }

    @Override
    public void eliminar(Long id) throws NegocioException {
        try {
            prestamoDAO.eliminar(id);
        } catch (Exception e) {
            throw new NegocioException("Error al eliminar el prestamo", e);
        }
    }
    
}

