/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramon.parcial.modelo;

import java.sql.Date;

/**
 *
 * @author PC05
 */
public class Actividad {
 
    int id;
    Vehiculo vehiculo;
    Parqueadero parqueadero;
    Date horaEntrada;
    int horas;
    String ubicacion;

    public Actividad() {
    }

    public Actividad(int id, Vehiculo vehiculo, Parqueadero parqueadero, Date horaEntrada, int horas, String ubicacion) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.parqueadero = parqueadero;
        this.horaEntrada = horaEntrada;
        this.horas = horas;
        this.ubicacion = ubicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Parqueadero getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }        
}
