/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.BeneficiarioDAO;
import DAOs.IBeneficiarioDAO;
import DTO.BeneficiarioDTO;
import entidades.BeneficiarioEntidad;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author eduar
 */
public class BeneficiarioNegocio implements IBeneficiarioNegocio{
    
    private IBeneficiarioDAO beneficiarioDAO = new BeneficiarioDAO();

    public BeneficiarioNegocio(IBeneficiarioDAO beneficiarioDAO) {
        this.beneficiarioDAO = beneficiarioDAO;
    }

    public BeneficiarioNegocio() {

    }
    
    @Override
    public List<BeneficiarioDTO> buscarBeneficiarioTabla() throws NegocioException {
        try {
            List<BeneficiarioEntidad> beneficiarios = this.beneficiarioDAO.obtenerTodos();
            return this.convertirBeneficiarioDTO(beneficiarios);
        } catch (PersistenciaException ex) {
            System.out.println(ex.getMessage());
            throw new NegocioException(ex.getMessage());
        }
    }    
    
    private List<DTO.BeneficiarioDTO> convertirBeneficiarioDTO(List<BeneficiarioEntidad> beneficiarios) throws NegocioException {
        if (beneficiarios == null) {
            throw new NegocioException("No se pudieron obtener los benefeficiarios. No hay registros.");
        }
        
            List<BeneficiarioDTO> beneficiarioDTO = new ArrayList<>();
        for (BeneficiarioEntidad beneficiario : beneficiarios) {
            BeneficiarioDTO dto = new BeneficiarioDTO();
            dto.setClaveContrato(beneficiario.getClaveContrato());
            dto.setContrasena(beneficiario.getContrasena());
            dto.setId(beneficiario.getId());
            dto.setMaterno(beneficiario.getMaterno());
            dto.setNombres(beneficiario.getNombres());
            dto.setPaterno(beneficiario.getPaterno());
            dto.setSaldo(beneficiario.getSaldo());
            dto.setUsuario(beneficiario.getUsuario());
            beneficiarioDTO.add(dto);
        }
        return beneficiarioDTO;
    }    
    
    
    @Override
    public BeneficiarioDTO crear(BeneficiarioDTO beneficiario) throws NegocioException {
        try {
            BeneficiarioEntidad entidad = new BeneficiarioEntidad();
            entidad.setClaveContrato(beneficiario.getClaveContrato());
            entidad.setSaldo(beneficiario.getSaldo());
            entidad.setUsuario(beneficiario.getUsuario());
            entidad.setContrasena(beneficiario.getContrasena());
            entidad.setNombres(beneficiario.getNombres());
            entidad.setPaterno(beneficiario.getPaterno());
            entidad.setMaterno(beneficiario.getMaterno());
            beneficiarioDAO.crear(entidad);
        } catch (Exception e) {
            throw new NegocioException("Error al crear el beneficiario", e);
        }
        
        return beneficiario;
    }

    @Override
    public BeneficiarioDTO obtenerPorId(Long id) throws NegocioException {
        try {
            BeneficiarioEntidad entidad = beneficiarioDAO.obtenerPorId(id);
            if (entidad == null) {
                throw new NegocioException("Beneficiario no encontrado");
            }
            return new BeneficiarioDTO(entidad.getId(), entidad.getClaveContrato(), entidad.getSaldo(), entidad.getUsuario(), entidad.getContrasena(), entidad.getNombres(), entidad.getPaterno(), entidad.getMaterno());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener el beneficiario por id", e);
        }
    }

    @Override
    public List<BeneficiarioDTO> obtenerTodos() throws NegocioException {
        try {
            return beneficiarioDAO.obtenerTodos().stream()
                    .map(entidad -> new BeneficiarioDTO(entidad.getId(), entidad.getClaveContrato(), entidad.getSaldo(), entidad.getUsuario(), entidad.getContrasena(), entidad.getNombres(), entidad.getPaterno(), entidad.getMaterno()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener todos los beneficiarios", e);
        }
    }

    @Override
    public BeneficiarioDTO actualizar(BeneficiarioDTO beneficiario) throws NegocioException {
        try {
            BeneficiarioEntidad entidad = beneficiarioDAO.obtenerPorId(beneficiario.getId());
            if (entidad == null) {
                throw new NegocioException("Beneficiario no encontrado");
            }
            entidad.setClaveContrato(beneficiario.getClaveContrato());
            entidad.setSaldo(beneficiario.getSaldo());
            entidad.setUsuario(beneficiario.getUsuario());
            entidad.setContrasena(beneficiario.getContrasena());
            entidad.setNombres(beneficiario.getNombres());
            entidad.setPaterno(beneficiario.getPaterno());
            entidad.setMaterno(beneficiario.getMaterno());
            beneficiarioDAO.actualizar(entidad);
        } catch (Exception e) {
            throw new NegocioException("Error al actualizar el beneficiario", e);
        }
        
        return beneficiario;
    }

    @Override
    public void eliminar(Long id) throws NegocioException {
        try {
            beneficiarioDAO.eliminar(id);
        } catch (Exception e) {
            throw new NegocioException("Error al eliminar el beneficiario", e);
        }
    }

    @Override
    public BeneficiarioDTO iniciarSesion(String usuario, String contrasena) throws NegocioException {
        try {
            BeneficiarioEntidad beneficiarioEntidad = beneficiarioDAO.iniciarSesion(usuario, contrasena);
            if (beneficiarioEntidad == null) {
                return null;
            }
            return new BeneficiarioDTO(
                beneficiarioEntidad.getId(),
                beneficiarioEntidad.getClaveContrato(),
                beneficiarioEntidad.getSaldo(),
                beneficiarioEntidad.getUsuario(),
                beneficiarioEntidad.getContrasena(),
                beneficiarioEntidad.getNombres(),
                beneficiarioEntidad.getPaterno(),
                beneficiarioEntidad.getMaterno()
            );
        } catch (Exception e) {
            throw new NegocioException("Error al iniciar sesión", e);
        }
    }
}
