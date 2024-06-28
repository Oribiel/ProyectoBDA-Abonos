/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import entidades.PagoEstatusEntidad;
import java.util.List;

/**
 *
 * @author eduar
 */
public interface IPagoEstatusDAO {
    PagoEstatusEntidad crear(PagoEstatusEntidad pagoEstatus);
    PagoEstatusEntidad obtenerPorId(Long id);
    List<PagoEstatusEntidad> obtenerTodos();
    PagoEstatusEntidad actualizar(PagoEstatusEntidad pagoEstatus);
    void eliminar(Long id);
}
