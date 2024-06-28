/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import DTO.TipoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author eduar
 */
public interface ITipoNegocio {
    TipoDTO crear(TipoDTO tipo) throws NegocioException;
    TipoDTO obtenerPorId(Long id) throws NegocioException;
    List<TipoDTO> obtenerTodos() throws NegocioException;
    TipoDTO actualizar(TipoDTO tipo) throws NegocioException;
    void eliminar(Long id) throws NegocioException;
}
