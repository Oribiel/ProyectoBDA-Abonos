/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author eduar
 */
public class AbonoDTO {
    private Long id;
    private Date fechaHora;
    private Double monto;
    private Long pagoId;

    public AbonoDTO() {
    
    }

    public AbonoDTO(Long id, Date fechaHora, Double monto, Long pagoId) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.pagoId = pagoId;
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

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Long getPagoId() {
        return pagoId;
    }

    public void setPagoId(Long pagoId) {
        this.pagoId = pagoId;
    }
}
