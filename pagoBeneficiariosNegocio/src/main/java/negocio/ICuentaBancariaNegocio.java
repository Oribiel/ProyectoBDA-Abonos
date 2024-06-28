/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import DTO.CuentaBancariaDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author eduar
 */
public interface ICuentaBancariaNegocio {
    CuentaBancariaDTO crear(CuentaBancariaDTO cuentaBancaria) throws NegocioException;
    CuentaBancariaDTO obtenerPorId(Long id) throws NegocioException;
    List<CuentaBancariaDTO> obtenerTodos() throws NegocioException;
    CuentaBancariaDTO actualizar(CuentaBancariaDTO cuentaBancaria) throws NegocioException;
    void eliminar(Long id) throws NegocioException;
    public List<CuentaBancariaDTO> buscarCuentaTabla() throws NegocioException;
    
    

}
