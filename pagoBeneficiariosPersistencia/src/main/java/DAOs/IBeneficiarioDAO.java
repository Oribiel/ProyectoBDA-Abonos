/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import entidades.BeneficiarioEntidad;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author eduar
 */
public interface IBeneficiarioDAO {
    BeneficiarioEntidad crear(BeneficiarioEntidad beneficiario);
    BeneficiarioEntidad obtenerPorId(Long id);
    List<BeneficiarioEntidad> obtenerTodos() throws PersistenciaException;
    BeneficiarioEntidad actualizar(BeneficiarioEntidad beneficiario);
    void eliminar(Long id);
    BeneficiarioEntidad iniciarSesion(String usuario, String contrasena) throws PersistenciaException;
}
