/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.CuentaBancariaDAO;
import DAOs.ICuentaBancariaDAO;
import DTO.CuentaBancariaDTO;
import entidades.BeneficiarioEntidad;
import entidades.CuentaBancariaEntidad;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author eduar
 */
public class CuentaBancariaNegocio implements ICuentaBancariaNegocio{
    
    private ICuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAO();

    public CuentaBancariaNegocio(ICuentaBancariaDAO cuentaBancariaDAO) {
        this.cuentaBancariaDAO = cuentaBancariaDAO;
    }

    
    public CuentaBancariaNegocio() {
    }
    
    

    @Override
    public CuentaBancariaDTO crear(CuentaBancariaDTO cuentaBancaria) throws NegocioException {
        try {
            CuentaBancariaEntidad entidad = new CuentaBancariaEntidad();
            entidad.setNumeroDeCuenta(cuentaBancaria.getNumeroDeCuenta());
            entidad.setClabe(cuentaBancaria.getClabe());
            entidad.setBanco(cuentaBancaria.getBanco());
            entidad.setEliminada(cuentaBancaria.getEliminada());
            BeneficiarioEntidad beneficiario = new BeneficiarioEntidad();
            beneficiario.setId(cuentaBancaria.getBeneficiarioId());
            entidad.setBeneficiario(beneficiario);
            cuentaBancariaDAO.crear(entidad);
        } catch (Exception e) {
            throw new NegocioException("Error al crear la cuenta bancaria", e);
        }
        
        return cuentaBancaria;
    }

    @Override
    public CuentaBancariaDTO obtenerPorId(Long id) throws NegocioException {
        try {
            CuentaBancariaEntidad entidad = cuentaBancariaDAO.obtenerPorId(id);
            if (entidad == null) {
                throw new NegocioException("Cuenta bancaria no encontrada");
            }
            return new CuentaBancariaDTO(entidad.getId(), entidad.getNumeroDeCuenta(), entidad.getClabe(), entidad.getBanco(), entidad.getEliminada(), entidad.getBeneficiario().getId());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener la cuenta bancaria por id", e);
        }
    }

    @Override
    public List<CuentaBancariaDTO> obtenerTodos() throws NegocioException {
        try {
            return cuentaBancariaDAO.obtenerTodos().stream()
                    .map(entidad -> new CuentaBancariaDTO(entidad.getId(), entidad.getNumeroDeCuenta(), entidad.getClabe(), entidad.getBanco(), entidad.getEliminada(), entidad.getBeneficiario().getId()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener todas las cuentas bancarias", e);
        }
    }

    @Override
    public CuentaBancariaDTO actualizar(CuentaBancariaDTO cuentaBancaria) throws NegocioException {
        try {
            CuentaBancariaEntidad entidad = cuentaBancariaDAO.obtenerPorId(cuentaBancaria.getId());
            if (entidad == null) {
                throw new NegocioException("Cuenta bancaria no encontrada");
            }
            entidad.setNumeroDeCuenta(cuentaBancaria.getNumeroDeCuenta());
            entidad.setClabe(cuentaBancaria.getClabe());
            entidad.setBanco(cuentaBancaria.getBanco());
            entidad.setEliminada(cuentaBancaria.getEliminada());
            BeneficiarioEntidad beneficiario = new BeneficiarioEntidad();
            beneficiario.setId(cuentaBancaria.getBeneficiarioId());
            entidad.setBeneficiario(beneficiario);
            cuentaBancariaDAO.actualizar(entidad);
        } catch (Exception e) {
            throw new NegocioException("Error al actualizar la cuenta bancaria", e);
        }
        
        return cuentaBancaria;
    }

    @Override
    public void eliminar(Long id) throws NegocioException {
        try {
            cuentaBancariaDAO.eliminar(id);
        } catch (Exception e) {
            throw new NegocioException("Error al eliminar la cuenta bancaria", e);
        }
    }
    
    
    
    @Override
    public List<CuentaBancariaDTO> buscarCuentaTabla() throws NegocioException {
        List<CuentaBancariaEntidad> cuentas = this.cuentaBancariaDAO.obtenerTodos();
        return this.convertirCuentaDTO(cuentas);
    }    
    
    private List<CuentaBancariaDTO> convertirCuentaDTO(List<CuentaBancariaEntidad> cuentas) throws NegocioException {
        if (cuentas == null) {
            throw new NegocioException("No se pudieron obtener los benefeficiarios. No hay registros.");
        }
        
            List<CuentaBancariaDTO> cuentaBancariaDTO = new ArrayList<>();
        for (CuentaBancariaEntidad cuenta : cuentas) {
            CuentaBancariaDTO dto = new CuentaBancariaDTO();
            dto.setBanco(cuenta.getBanco());
            dto.setBeneficiarioId(cuenta.getBeneficiario().getId());
            dto.setClabe(cuenta.getClabe());
            dto.setEliminada(cuenta.getEliminada());
            dto.setId(cuenta.getId());
            dto.setNumeroDeCuenta(cuenta.getNumeroDeCuenta());

            cuentaBancariaDTO.add(dto);
        }
        return cuentaBancariaDTO;
    }      
    
    
}
