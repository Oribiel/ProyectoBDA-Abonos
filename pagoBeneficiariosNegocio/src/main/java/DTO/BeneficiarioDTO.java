/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author eduar
 */
public class BeneficiarioDTO {
    private Long id;
    private String claveContrato;
    private Double saldo;
    private String usuario;
    private String contrasena;
    private String nombres;
    private String paterno;
    private String materno;

    public BeneficiarioDTO() {}

    public BeneficiarioDTO(Long id, String claveContrato, double saldo, String usuario, String contraseña, String nombres, String paterno, String materno) {
        this.id=id;
        this.claveContrato=claveContrato;
        this.saldo=saldo;
        this.usuario=usuario;
        this.contrasena=contraseña;
        this.nombres=nombres;
        this.paterno=paterno;
        this.materno=materno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClaveContrato() {
        return claveContrato;
    }

    public void setClaveContrato(String claveContrato) {
        this.claveContrato = claveContrato;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
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
}
