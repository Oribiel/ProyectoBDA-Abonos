/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import DTO.PrestamoDTO;
import entidades.PrestamoEntidad;

/**
 *
 * @author oribi
 */
public class Convertidor {
      // Método para convertir de PrestamoDTO a PrestamoEntidad
    public static PrestamoEntidad convertirDTOaEntidad(PrestamoDTO dto) {
        PrestamoEntidad entidad = new PrestamoEntidad();
        entidad.setId(dto.getId()); // Si es necesario copiar el ID
        entidad.setMonto(dto.getMonto());
        entidad.setFecha(dto.getFecha());
        entidad.setParcialidades(dto.getParcialidades());
        return entidad;
    }

    // Método para convertir de PrestamoEntidad a PrestamoDTO
    public static PrestamoDTO convertirEntidadaDTO(PrestamoEntidad entidad) {
        PrestamoDTO dto = new PrestamoDTO();
        dto.setId(entidad.getId()); // Si es necesario copiar el ID
        dto.setMonto(entidad.getMonto());
        dto.setFecha(entidad.getFecha());
        dto.setParcialidades(entidad.getParcialidades());
        return dto;
    }
}
