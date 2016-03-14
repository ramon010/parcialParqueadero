/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramon.parcial.implementarDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ramon.parcial.conexion.DbConnectionFactory;
import ramon.parcial.dao.Dao;
import ramon.parcial.modelo.Vehiculo;

/**
 *
 * @author PC05
 */
public class DaoVehiculoImplementar implements Dao<Vehiculo> {

    public DaoVehiculoImplementar() {
        try {
            DbConnectionFactory.connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoVehiculoImplementar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DaoVehiculoImplementar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void guardar(Vehiculo vehiculo) {
        Connection connection = DbConnectionFactory.getConnection();
        PreparedStatement pst;
        try {
            pst = connection.prepareStatement("INSERT INTO vehiculo(nombre_dueno,marca,descripcion_del_auto,placa) values(?,?,?,?)");
            pst.setString(1, vehiculo.getNombreDueno());
            pst.setString(2, vehiculo.getMarca());
            pst.setString(3, vehiculo.getDescripcionDelAuto());
            pst.setString(4, vehiculo.getPlaca());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoVehiculoImplementar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Vehiculo> listar() {
        List<Vehiculo> lista = new ArrayList<>();
        Connection connection = DbConnectionFactory.getConnection();
        PreparedStatement pst;
        try {
            pst = connection.prepareStatement("Select * from vehiculo");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setId(rs.getInt("id"));
                vehiculo.setNombreDueno(rs.getString("nombre_dueno"));
                vehiculo.setDescripcionDelAuto(rs.getString("descripcion_del_auto"));
                vehiculo.setMarca(rs.getString("marca"));
                vehiculo.setPlaca(rs.getString("placa"));
                lista.add(vehiculo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoVehiculoImplementar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public Vehiculo obtener(int id) {
        String sql = "Select * from vehiculo where id=?";

        Connection connection = DbConnectionFactory.getConnection();
        Vehiculo vehiculo = new Vehiculo();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                vehiculo.setId(id);
                vehiculo.setNombreDueno(resultSet.getString("nombre_dueno"));
                vehiculo.setDescripcionDelAuto(resultSet.getString("descripcion_del_auto"));
                vehiculo.setMarca(resultSet.getString("marca"));
                vehiculo.setPlaca(resultSet.getString("placa"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoVehiculoImplementar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehiculo;
    }

}
