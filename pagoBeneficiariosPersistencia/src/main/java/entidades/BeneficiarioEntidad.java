/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author eduar
 */
@javax.persistence.Entity
@Table(name = "tblBeneficiarios")
public class BeneficiarioEntidad implements Serializable {

    @Id
    @Column(name = "idBeneficiario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
     @Column(nullable = false, length = 55)
    private String claveContrato;

    @Column(nullable = false, precision = 10, scale = 2)
    private double saldo;

    @Column(nullable = false, length = 55)
    private String usuario;

    @Column(nullable = false, length = 55)
    private String contrasena;

    @Column(nullable = false, length = 55)
    private String nombres;

    @Column(nullable = false, length = 55)
    private String paterno;

    @Column(nullable = false, length = 55)
    private String materno;

    @OneToMany(mappedBy = "beneficiario")
    private List<CuentaBancariaEntidad> cuentasBancarias;

    @OneToMany(mappedBy = "beneficiario")
    private List<PagoEntidad> pagos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClaveContrato() {
        return claveContrato;
    }

    public void setClaveContrato(String clave_contrato) {
        this.claveContrato = clave_contrato;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public List<CuentaBancariaEntidad> getCuentasBancarias() {
        return cuentasBancarias;
    }

    public void setCuentasBancarias(List<CuentaBancariaEntidad> cuentasBancarias) {
        this.cuentasBancarias = cuentasBancarias;
    }

    public List<PagoEntidad> getPagos() {
        return pagos;
    }

    public void setPagos(List<PagoEntidad> pagos) {
        this.pagos = pagos;
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
        if (!(object instanceof BeneficiarioEntidad)) {
            return false;
        }
        BeneficiarioEntidad other = (BeneficiarioEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Beneficiario[ id=" + id + " ]";
    }
    
}
