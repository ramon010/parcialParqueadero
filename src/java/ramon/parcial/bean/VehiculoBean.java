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
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import ramon.parcial.dao.Dao;
import ramon.parcial.implementarDao.DaoVehiculoImplementar;
import ramon.parcial.modelo.Vehiculo;
import ramon.parcial.utilidades.Mensajes;

/**
 *
 * @author PC05
 */
@ManagedBean
@ViewScoped
public class VehiculoBean implements Serializable {

    public Vehiculo vehiculo = new Vehiculo();
    private Dao<Vehiculo> dao = new DaoVehiculoImplementar();
    private List<Vehiculo> listarVehiculo = new ArrayList<>();

    public VehiculoBean() {
        listarVehiculo = dao.listar();
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public List<Vehiculo> getListar() {
        return listarVehiculo;
    }

    public void registrar() {
        dao.guardar(vehiculo);
        Mensajes.addInfoMessage("Registrado!");
    }

}
