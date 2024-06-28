/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author eduar
 */
public class TipoDTO {
    private Long id;
    private String nombre;
    private int numeroParcialidades;

    public TipoDTO() {}

    public TipoDTO(Long id, String nombre, int numeroParcialidades) {
        this.id=id;
        this.nombre=nombre;
        this.numeroParcialidades=numeroParcialidades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroParcialidades() {
        return numeroParcialidades;
    }

    public void setNumeroParcialidades(int numeroParcialidades) {
        this.numeroParcialidades = numeroParcialidades;
    }
}
