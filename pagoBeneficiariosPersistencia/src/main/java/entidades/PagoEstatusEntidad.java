/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author eduar
 */
@Entity
@Table(name = "tblPagosEstatus")
public class PagoEstatusEntidad implements Serializable {

    @Id
    @Column(name = "idPagoEstatus")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaHora;

    @Column(length = 55, nullable = true)
    private String mensaje;

    @ManyToOne(cascade = (CascadeType.PERSIST))
    @JoinColumn(name = "idPago", nullable = false)
    private PagoEntidad pago;

    @ManyToOne(cascade = (CascadeType.PERSIST))
    @JoinColumn(name = "idEstatus", nullable = false)
    private EstatusEntidad estatus;

    public PagoEstatusEntidad() {
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

    public PagoEntidad getPago() {
        return pago;
    }

    public void setPago(PagoEntidad pago) {
        this.pago = pago;
    }

    public EstatusEntidad getEstatus() {
        return estatus;
    }

    public void setEstatus(EstatusEntidad estatus) {
        this.estatus = estatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoEstatusEntidad)) {
            return false;
        }
        PagoEstatusEntidad other = (PagoEstatusEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PagoEstatusEntidad{" + "id=" + id + ", fechaHora=" + fechaHora + ", mensaje=" + mensaje + ", pago=" + pago + ", estatus=" + estatus + '}';
    }
    
}
