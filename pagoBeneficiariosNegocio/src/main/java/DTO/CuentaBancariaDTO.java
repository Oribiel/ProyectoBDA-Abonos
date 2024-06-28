/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author eduar
 */
public class CuentaBancariaDTO {
    private Long id;
    private String numeroDeCuenta;
    private String clabe;
    private String banco;
    private Boolean eliminada;
    private Long beneficiarioId;

    public CuentaBancariaDTO() {}

    public CuentaBancariaDTO(Long id, String numeroDeCuenta, String clabe, String banco, Boolean eliminada, Long beneficiarioId) {
        this.id=id;
        this.numeroDeCuenta=numeroDeCuenta;
        this.clabe=clabe;
        this.banco=banco;
        this.eliminada=eliminada;
        this.beneficiarioId=beneficiarioId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Boolean getEliminada() {
        return eliminada;
    }

    public void setEliminada(Boolean eliminada) {
        this.eliminada = eliminada;
    }

    public Long getBeneficiarioId() {
        return beneficiarioId;
    }

    public void setBeneficiarioId(Long beneficiarioId) {
        this.beneficiarioId = beneficiarioId;
    }
}
