/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import entidades.EstatusEntidad;
import entidades.PagoEntidad;
import java.util.Date;

/**
 *
 * @author eduar
 */
public class PagoEstatusDTO {
    private Long id;
    private Date fechaHora;
    private String mensaje;
    private PagoEntidad pagoId;
    private EstatusEntidad estatusId;

    public PagoEstatusDTO() {
    
    }

    public PagoEstatusDTO(Long id, Date fechaHora, String mensaje, PagoEntidad pagoId, EstatusEntidad estatusId) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
        this.pagoId = pagoId;
        this.estatusId = estatusId;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public PagoEntidad getPagoId() {
        return pagoId;
    }

    public void setPagoId(PagoEntidad pagoId) {
        this.pagoId = pagoId;
    }

    public EstatusEntidad getEstatusId() {
        return estatusId;
    }

    public void setEstatusId(EstatusEntidad estatusId) {
        this.estatusId = estatusId;
    }
}
