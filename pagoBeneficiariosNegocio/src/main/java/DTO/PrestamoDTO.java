/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;



public class PrestamoDTO {
    private Long id;
    private double monto;
    private String fecha;
    private int parcialidades;

    public PrestamoDTO() {
    }

    public PrestamoDTO( double monto, String fecha, int parcialidades) {
   
        this.monto = monto;
        this.fecha = fecha;
        this.parcialidades = parcialidades;
    }

    public PrestamoDTO(Long id, double monto, String fecha, int parcialidades) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.parcialidades = parcialidades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getParcialidades() {
        return parcialidades;
    }

    public void setParcialidades(int parcialidades) {
        this.parcialidades = parcialidades;
    }
    

   
}