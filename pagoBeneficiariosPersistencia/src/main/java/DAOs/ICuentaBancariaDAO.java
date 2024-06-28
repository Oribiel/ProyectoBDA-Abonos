/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import entidades.CuentaBancariaEntidad;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author eduar
 */
public interface ICuentaBancariaDAO {
    CuentaBancariaEntidad crear(CuentaBancariaEntidad cuentaBancaria);
    CuentaBancariaEntidad obtenerPorId(Long id);
    List<CuentaBancariaEntidad> obtenerTodos() throws PersistenceException;
    CuentaBancariaEntidad actualizar(CuentaBancariaEntidad cuentaBancaria);
    void eliminar(Long id);
}
