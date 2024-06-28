/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import DTO.PagoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author eduar
 */
public interface IPagoNegocio {
    PagoDTO crear(PagoDTO pago) throws NegocioException;
    PagoDTO obtenerPorId(Long id) throws NegocioException;
    List<PagoDTO> obtenerTodos() throws NegocioException;
    PagoDTO actualizar(PagoDTO pago) throws NegocioException;
    void eliminar(Long id) throws NegocioException;
}
