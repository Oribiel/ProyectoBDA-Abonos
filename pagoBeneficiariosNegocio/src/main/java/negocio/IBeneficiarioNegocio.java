/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import DTO.BeneficiarioDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author eduar
 */
public interface IBeneficiarioNegocio {
    
   public List<BeneficiarioDTO> buscarBeneficiarioTabla() throws NegocioException;
    BeneficiarioDTO crear(BeneficiarioDTO beneficiario) throws NegocioException;
    BeneficiarioDTO obtenerPorId(Long id) throws NegocioException;
    List<BeneficiarioDTO> obtenerTodos() throws NegocioException;
    BeneficiarioDTO actualizar(BeneficiarioDTO beneficiario) throws NegocioException;
    void eliminar(Long id) throws NegocioException;
    BeneficiarioDTO iniciarSesion(String usuario, String contrasena) throws NegocioException;
}
