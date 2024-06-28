/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.ITipoDAO;
import DAOs.TipoDAO;
import DTO.TipoDTO;
import entidades.TipoEntidad;
import excepciones.NegocioException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author eduar
 */
public class TipoNegocio implements ITipoNegocio{
    private ITipoDAO tipoDAO = new TipoDAO();

    public TipoNegocio(ITipoDAO tipoDAO) {
        this.tipoDAO = tipoDAO;
    }

    public TipoNegocio() {
    }

    
    
    @Override
    public TipoDTO crear(TipoDTO tipo) throws NegocioException {
        try {
            TipoEntidad entidad = new TipoEntidad();
            entidad.setNombre(tipo.getNombre());
            entidad.setNumeroParcialidades(tipo.getNumeroParcialidades());
            tipoDAO.crear(entidad);
        } catch (Exception e) {
            throw new NegocioException("Error al crear el tipo", e);
        }
        
        return tipo;
    }

    @Override
    public TipoDTO obtenerPorId(Long id) throws NegocioException {
        try {
            TipoEntidad entidad = tipoDAO.obtenerPorId(id);
            if (entidad == null) {
                throw new NegocioException("Tipo no encontrado");
            }
            return new TipoDTO(entidad.getId(), entidad.getNombre(), entidad.getNumeroParcialidades());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener el tipo por id", e);
        }
    }

    @Override
    public List<TipoDTO> obtenerTodos() throws NegocioException {
        try {
            return tipoDAO.obtenerTodos().stream()
                    .map(entidad -> new TipoDTO(entidad.getId(), entidad.getNombre(), entidad.getNumeroParcialidades()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener todos los tipos", e);
        }
    }

    @Override
    public TipoDTO actualizar(TipoDTO tipo) throws NegocioException {
        try {
            TipoEntidad entidad = tipoDAO.obtenerPorId(tipo.getId());
            if (entidad == null) {
                throw new NegocioException("Tipo no encontrado");
            }
            entidad.setNombre(tipo.getNombre());
            entidad.setNumeroParcialidades(tipo.getNumeroParcialidades());
            tipoDAO.actualizar(entidad);
        } catch (Exception e) {
            throw new NegocioException("Error al actualizar el tipo", e);
        }
        
        return tipo;
    }

    @Override
    public void eliminar(Long id) throws NegocioException {
        try {
            tipoDAO.eliminar(id);
        } catch (Exception e) {
            throw new NegocioException("Error al eliminar el tipo", e);
        }
    }
}
