/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import DTO.EstatusDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author eduar
 */
public interface IEstatusNegocio {
    EstatusDTO crear(EstatusDTO estatus) throws NegocioException;
    EstatusDTO obtenerPorId(Long id) throws NegocioException;
    List<EstatusDTO> obtenerTodos() throws NegocioException;
    EstatusDTO actualizar(EstatusDTO estatus) throws NegocioException;
    void eliminar(Long id) throws NegocioException;
}
