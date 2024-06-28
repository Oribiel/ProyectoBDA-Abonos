/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import entidades.PagoEntidad;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author eduar
 */
public interface IPagoDAO {
    
    PagoEntidad crear(PagoEntidad pago);
    PagoEntidad obtenerPorId(Long id);
    List<PagoEntidad> obtenerTodos();
    PagoEntidad actualizar(PagoEntidad pago);
    void eliminar(Long id);
}
