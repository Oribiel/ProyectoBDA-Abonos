/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import entidades.TipoEntidad;
import java.util.List;

/**
 *
 * @author eduar
 */
public interface ITipoDAO {
    TipoEntidad crear(TipoEntidad tipo);
    TipoEntidad obtenerPorId(Long id);
    List<TipoEntidad> obtenerTodos();
    TipoEntidad actualizar(TipoEntidad tipo);
    void eliminar(Long id);
}
