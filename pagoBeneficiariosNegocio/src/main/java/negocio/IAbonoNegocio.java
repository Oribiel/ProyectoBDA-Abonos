/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import DTO.AbonoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author eduar
 */
public interface IAbonoNegocio {
    AbonoDTO crear(AbonoDTO abono) throws NegocioException;
    AbonoDTO obtenerPorId(Long id) throws NegocioException;
    List<AbonoDTO> obtenerTodos() throws NegocioException;
    AbonoDTO actualizar(AbonoDTO abono) throws NegocioException;
    void eliminar(Long id) throws NegocioException;
}
