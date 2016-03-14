/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramon.parcial.modelo;

/**
 *
 * @author PC05
 */
public class Vehiculo {
    
    int id;
    String nombreDueno;
    String marca;
    String descripcionDelAuto;
    String placa;

    public Vehiculo() {
    }

     
    public Vehiculo(int id, String nombreDueno, String marca, String descripcionDelAuto, String placa) {
        this.id = id;
        this.nombreDueno = nombreDueno;
        this.marca = marca;
        this.descripcionDelAuto = descripcionDelAuto;
        this.placa = placa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcionDelAuto() {
        return descripcionDelAuto;
    }

    public void setDescripcionDelAuto(String descripcionDelAuto) {
        this.descripcionDelAuto = descripcionDelAuto;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return nombreDueno +" "+ marca; //To change body of generated methods, choose Tools | Templates.
    }
    
}
