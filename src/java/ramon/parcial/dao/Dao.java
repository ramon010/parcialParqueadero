/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramon.parcial.dao;

import java.util.List;

/**
 *
 * @author PC05
 */
public interface Dao<Modelo> {

    void guardar(Modelo modelo);

    List<Modelo> listar();

    Modelo obtener(int id);
}
