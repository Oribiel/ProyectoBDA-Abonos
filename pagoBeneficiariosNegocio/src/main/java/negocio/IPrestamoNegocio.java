/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import DTO.PrestamoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Arturo ITSON
 */
public interface IPrestamoNegocio {
    
    PrestamoDTO crear(PrestamoDTO prestamo) throws NegocioException;
    PrestamoDTO obtenerPorId(Long id) throws NegocioException;
    List<PrestamoDTO> obtenerTodos() throws NegocioException;
    PrestamoDTO actualizar(PrestamoDTO prestamo) throws NegocioException;
    void eliminar(Long id) throws NegocioException;
    
}
