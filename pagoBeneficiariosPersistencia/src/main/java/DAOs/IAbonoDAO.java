/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import entidades.AbonoEntidad;
import java.util.List;

/**
 *
 * @author eduar
 */
public interface IAbonoDAO {
    AbonoEntidad crear(AbonoEntidad abono);
    AbonoEntidad obtenerPorId(Long id);
    List<AbonoEntidad> obtenerTodos();
    AbonoEntidad actualizar(AbonoEntidad abono);
    void eliminar(Long id);
}
