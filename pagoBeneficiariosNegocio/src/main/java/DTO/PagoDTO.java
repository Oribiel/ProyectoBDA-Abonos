/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import entidades.BeneficiarioEntidad;
import entidades.EstatusEntidad;
import entidades.TipoEntidad;
import java.util.Date;

/**
 *
 * @author eduar
 */
public class PagoDTO {
    private Long id;
    private Date fechaHora;
    private Double monto;
    private String comprobante;
    private BeneficiarioEntidad beneficiarioId;
    private BeneficiarioEntidad beneficiario;
    private TipoEntidad tipoId;

    public PagoDTO(Long id, Date fechaHora, Double monto, String comprobante, BeneficiarioEntidad beneficiarioId, TipoEntidad tipoId) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.comprobante = comprobante;
        this.beneficiarioId = beneficiarioId;
        this.tipoId = tipoId;
    }

    
    

    

    public PagoDTO() {}

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

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public BeneficiarioEntidad getBeneficiarioId() {
        return beneficiarioId;
    }

    public void setBeneficiarioId(BeneficiarioEntidad beneficiarioId) {
        this.beneficiarioId = beneficiarioId;
    }

    
    
    public TipoEntidad getTipoId() {
        return tipoId;
    }

    public void setTipoId(TipoEntidad tipoId) {
        this.tipoId = tipoId;
    }
}
