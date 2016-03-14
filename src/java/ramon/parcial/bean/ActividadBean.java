/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramon.parcial.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import ramon.parcial.dao.Dao;
import ramon.parcial.implementarDao.DaoActividadImplementar;
import ramon.parcial.modelo.Actividad;
import ramon.parcial.modelo.Parqueadero;
import ramon.parcial.modelo.Vehiculo;
import ramon.parcial.utilidades.Mensajes;

/**
 *
 * @author PC05
 */
@ManagedBean
@ViewScoped
public class ActividadBean implements Serializable {

    public Actividad actividad = new Actividad();
    private Dao<Actividad> dao = new DaoActividadImplementar();
    private List<Actividad> listarActividades = new ArrayList<>();

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public ActividadBean() {
        listarActividades = dao.listar();
    }

    public List<Actividad> getListar() {
        return listarActividades;
    }

    public void registrar(Vehiculo vehiculo,Parqueadero parqueadero) {
        actividad.setParqueadero(parqueadero);
        actividad.setVehiculo(vehiculo);
        dao.guardar(actividad);
        Mensajes.addInfoMessage("Registrado!");
    }
}
