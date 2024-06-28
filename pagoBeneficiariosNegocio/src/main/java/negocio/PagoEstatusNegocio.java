/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.IPagoEstatusDAO;
import DAOs.PagoEstatusDAO;
import DTO.PagoDTO;
import DTO.PagoEstatusDTO;
import entidades.EstatusEntidad;
import entidades.PagoEntidad;
import entidades.PagoEstatusEntidad;
import excepciones.NegocioException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author eduar
 */
public class PagoEstatusNegocio implements IPagoEstatusNegocio{
    private IPagoEstatusDAO pagoEstatusDAO = new PagoEstatusDAO();

    public PagoEstatusNegocio(IPagoEstatusDAO pagoEstatusDAO) {
        this.pagoEstatusDAO = pagoEstatusDAO;
    }

    public PagoEstatusNegocio() {
    }

   
    
    @Override
    public PagoEstatusDTO crear(PagoEstatusDTO pagoEstatus, PagoDTO pago, EstatusEntidad en) throws NegocioException {
        try {
            PagoEstatusEntidad entidad = new PagoEstatusEntidad();
            entidad.setFechaHora(pagoEstatus.getFechaHora());
            System.out.println(entidad.getFechaHora().toString() +" estatus y fecha");
            entidad.setMensaje(pagoEstatus.getMensaje());
            
            PagoEntidad pagoNuevo = new PagoEntidad();
            pagoNuevo.setId(pago.getId());
            pagoNuevo.setBeneficiario(pago.getBeneficiarioId());
            pagoNuevo.setFechaHora(pago.getFechaHora());
            pagoNuevo.setMonto(pago.getMonto());
            pagoNuevo.setTipo(pago.getTipoId());
            entidad.setPago(pagoNuevo);

            entidad.setEstatus(en);
            
            
            System.out.println("antes de ");
            System.out.println(entidad.getPago().getFechaHora() + "fehcha xd");
            pagoEstatusDAO.crear(entidad);
            System.out.println("se logro");
        } catch (Exception e) {
            throw new NegocioException("Error al crear el pago estatus", e);
        }
        
        return pagoEstatus;
    }

    @Override
    public PagoEstatusDTO obtenerPorId(Long id) throws NegocioException {
        try {
            PagoEstatusEntidad entidad = pagoEstatusDAO.obtenerPorId(id);
            if (entidad == null) {
                throw new NegocioException("Pago estatus no encontrado");
            }
            return new PagoEstatusDTO(entidad.getId(), entidad.getFechaHora(), entidad.getMensaje(), entidad.getPago(), entidad.getEstatus());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener el pago estatus por id", e);
        }
    }

    @Override
    public List<PagoEstatusDTO> obtenerTodos() throws NegocioException {
        try {
            return pagoEstatusDAO.obtenerTodos().stream()
                    .map(entidad -> new PagoEstatusDTO(entidad.getId(), entidad.getFechaHora(), entidad.getMensaje(), entidad.getPago() , entidad.getEstatus()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener todos los pago estatus", e);
        }
    }

    @Override
    public PagoEstatusDTO actualizar(PagoEstatusDTO pagoEstatus) throws NegocioException {
        try {
            PagoEstatusEntidad entidad = pagoEstatusDAO.obtenerPorId(pagoEstatus.getId());
            if (entidad == null) {
                throw new NegocioException("Pago estatus no encontrado");
            }
            entidad.setFechaHora(pagoEstatus.getFechaHora());
            entidad.setMensaje(pagoEstatus.getMensaje());
            
            PagoEntidad pago = new PagoEntidad();
            pago.setId(pagoEstatus.getPagoId().getId());
            entidad.setPago(pago);
            
            EstatusEntidad estatus = new EstatusEntidad();
            estatus.setId(pagoEstatus.getEstatusId().getId());
            entidad.setEstatus(estatus);
            
            pagoEstatusDAO.actualizar(entidad);
        } catch (Exception e) {
            throw new NegocioException("Error al actualizar el pago estatus", e);
        }
        
        return pagoEstatus;
    }

    @Override
    public void eliminar(Long id) throws NegocioException {
        try {
            pagoEstatusDAO.eliminar(id);
        } catch (Exception e) {
            throw new NegocioException("Error al eliminar el pago estatus", e);
        }
    }

}
