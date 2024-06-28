/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.EstatusDAO;
import DAOs.IEstatusDAO;
import DTO.EstatusDTO;
import entidades.EstatusEntidad;
import excepciones.NegocioException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author eduar
 */
public class EstatusNegocio implements IEstatusNegocio{
    private IEstatusDAO estatusDAO = new EstatusDAO();

    public EstatusNegocio(IEstatusDAO estatusDAO) {
        this.estatusDAO = estatusDAO;
    }

    public EstatusNegocio() {
    }

    
    
    
    @Override
    public EstatusDTO crear(EstatusDTO estatus) throws NegocioException {
        try {
            EstatusEntidad entidad = new EstatusEntidad();
            entidad.setNombre(estatus.getNombre());
            estatusDAO.crear(entidad);
        } catch (Exception e) {
            throw new NegocioException("Error al crear el estatus", e);
        }
        
        return estatus;
    }

    @Override
    public EstatusDTO obtenerPorId(Long id) throws NegocioException {
        try {
            EstatusEntidad entidad = estatusDAO.obtenerPorId(id);
            if (entidad == null) {
                throw new NegocioException("Estatus no encontrado");
            }
            return new EstatusDTO(entidad.getId(), entidad.getNombre());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener el estatus por id", e);
        }
    }

    @Override
    public List<EstatusDTO> obtenerTodos() throws NegocioException {
        try {
            return estatusDAO.obtenerTodos().stream()
                    .map(entidad -> new EstatusDTO(entidad.getId(), entidad.getNombre()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener todos los estatus", e);
        }
    }

    @Override
    public EstatusDTO actualizar(EstatusDTO estatus) throws NegocioException {
        try {
            EstatusEntidad entidad = estatusDAO.obtenerPorId(estatus.getId());
            if (entidad == null) {
                throw new NegocioException("Estatus no encontrado");
            }
            entidad.setNombre(estatus.getNombre());
            estatusDAO.actualizar(entidad);
        } catch (Exception e) {
            throw new NegocioException("Error al actualizar el estatus", e);
        }
        
        return estatus;
    }

    @Override
    public void eliminar(Long id) throws NegocioException {
        try {
            estatusDAO.eliminar(id);
        } catch (Exception e) {
            throw new NegocioException("Error al eliminar el estatus", e);
        }
    }
}
