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
public class Parqueadero {

    int id;
    String nombre;
    String descripcion;
    int valorPorHora;

    public Parqueadero() {
    }

    public Parqueadero(int id, String nombre, String descripcion, int valorPorHora) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valorPorHora = valorPorHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(int valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    @Override
    public String toString() {
        return nombre; //To change body of generated methods, choose Tools | Templates.
    }

}
