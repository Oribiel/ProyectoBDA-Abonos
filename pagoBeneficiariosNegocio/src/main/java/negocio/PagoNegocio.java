/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.IPagoDAO;
import DAOs.IPrestamoDAO;
import DAOs.PagoDAO;
import DTO.PagoDTO;
import entidades.PagoEntidad;
import entidades.PrestamoEntidad;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.PersistenceException;

/**
 *
 * @author eduar
 */
public class PagoNegocio implements IPagoNegocio{
    
    private IPagoDAO pagoDAO = new PagoDAO();

    public PagoNegocio(IPagoDAO pagoDAO) {
        this.pagoDAO = pagoDAO;
    }

    public PagoNegocio() {
        
    }

    @Override
    public PagoDTO crear(PagoDTO pago) throws NegocioException {
        PagoEntidad entidad = new PagoEntidad();
        entidad.setBeneficiario(pago.getBeneficiarioId());
        entidad.setFechaHora(pago.getFechaHora());
        entidad.setMonto(pago.getMonto());
        entidad.setTipo(pago.getTipoId());
        
        pagoDAO.crear(entidad);
        
        return pago;
    }

    @Override
    public PagoDTO obtenerPorId(Long id) throws NegocioException {
        try {
            PagoEntidad entidad = pagoDAO.obtenerPorId(id);
            if (entidad == null) {
                throw new NegocioException("Prestamo no encontrado");
            }
            return new PagoDTO(entidad.getId(), entidad.getFechaHora(), entidad.getMonto(), entidad.getComprobante(), entidad.getBeneficiario(),entidad.getTipo());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener el prestamo por id", e);
        }
    }

    @Override
    public List<PagoDTO> obtenerTodos() throws NegocioException {
        try {
            return pagoDAO.obtenerTodos().stream()
                    .map(entidad -> new PagoDTO(entidad.getId(), entidad.getFechaHora(), entidad.getMonto(), entidad.getComprobante(), entidad.getBeneficiario(),entidad.getTipo()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener todos los prestamos", e);
        }
    }

    @Override
    public PagoDTO actualizar(PagoDTO pago) throws NegocioException {
        try {
            PagoEntidad entidad = pagoDAO.obtenerPorId(pago.getId());
            if (entidad == null) {
                throw new NegocioException("Prestamo no encontrado");
            }
            entidad.setBeneficiario(pago.getBeneficiarioId());
            entidad.setComprobante(pago.getComprobante());
            entidad.setFechaHora(pago.getFechaHora());
            entidad.setMonto(pago.getMonto());
            entidad.setTipo(pago.getTipoId());

            pagoDAO.actualizar(entidad);
        } catch (Exception e) {
            throw new NegocioException("Error al actualizar el prestamo", e);
        }
        
        return pago;
    }

    @Override
    public void eliminar(Long id) throws NegocioException {
        try {
            pagoDAO.eliminar(id);
        } catch (Exception e) {
            throw new NegocioException("Error al eliminar el prestamo", e);
        }
    }
    
}
