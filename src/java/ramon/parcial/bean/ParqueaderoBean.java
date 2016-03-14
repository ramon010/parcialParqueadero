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
import ramon.parcial.implementarDao.DaoParqueaderoImplementar;
import ramon.parcial.modelo.Parqueadero;
import ramon.parcial.utilidades.Mensajes;

/**
 *
 * @author PC05
 */
@ManagedBean
@ViewScoped
public class ParqueaderoBean implements Serializable {

    public Parqueadero parqueadero = new Parqueadero();
    private Dao<Parqueadero> dao = new DaoParqueaderoImplementar();
    private List<Parqueadero> listarParqueadero = new ArrayList<>();

    public ParqueaderoBean() {
        listarParqueadero = dao.listar();
    }

    
    public Parqueadero getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    public List<Parqueadero> getListar() {
        return listarParqueadero;
    }

    public void registrar() {
        dao.guardar(parqueadero);
        Mensajes.addInfoMessage("Registrado!");
    }

}
