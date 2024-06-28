/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.AbonoDAO;
import DAOs.IAbonoDAO;
import DTO.AbonoDTO;
import entidades.AbonoEntidad;
import entidades.PagoEntidad;
import excepciones.NegocioException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author eduar
 */
public class AbonoNegocio implements IAbonoNegocio{
    private IAbonoDAO abonoDAO = new AbonoDAO();

    public AbonoNegocio(IAbonoDAO abonoDAO) {
        this.abonoDAO = abonoDAO;
    }

    @Override
    public AbonoDTO crear(AbonoDTO abono) throws NegocioException {
        try {
            AbonoEntidad entidad = new AbonoEntidad();
            entidad.setFechaHora(abono.getFechaHora());
            entidad.setMonto(abono.getMonto());
            PagoEntidad pago = new PagoEntidad();
            pago.setId(abono.getPagoId());
            entidad.setPago(pago);
            abonoDAO.crear(entidad);
        } catch (Exception e) {
            throw new NegocioException("Error al crear el abono", e);
        }
        
        return abono;
    }

    @Override
    public AbonoDTO obtenerPorId(Long id) throws NegocioException {
        try {
            AbonoEntidad entidad = abonoDAO.obtenerPorId(id);
            if (entidad == null) {
                throw new NegocioException("Abono no encontrado");
            }
            return new AbonoDTO(entidad.getId(), entidad.getFechaHora(), entidad.getMonto(), entidad.getPago().getId());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener el abono por id", e);
        }
    }

    @Override
    public List<AbonoDTO> obtenerTodos() throws NegocioException {
        try {
            return abonoDAO.obtenerTodos().stream()
                    .map(entidad -> new AbonoDTO(entidad.getId(), entidad.getFechaHora(), entidad.getMonto(), entidad.getPago().getId()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener todos los abonos", e);
        }
    }

    @Override
    public AbonoDTO actualizar(AbonoDTO abono) throws NegocioException {
        try {
            AbonoEntidad entidad = abonoDAO.obtenerPorId(abono.getId());
            if (entidad == null) {
                throw new NegocioException("Abono no encontrado");
            }
            entidad.setFechaHora(abono.getFechaHora());
            entidad.setMonto(abono.getMonto());
            PagoEntidad pago = new PagoEntidad();
            pago.setId(abono.getPagoId());
            entidad.setPago(pago);
            abonoDAO.actualizar(entidad);
        } catch (Exception e) {
            throw new NegocioException("Error al actualizar el abono", e);
        }
        
        return abono;
    }

    @Override
    public void eliminar(Long id) throws NegocioException {
        try {
            abonoDAO.eliminar(id);
        } catch (Exception e) {
            throw new NegocioException("Error al eliminar el abono", e);
        }
    }
}
