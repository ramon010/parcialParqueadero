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
import ramon.parcial.modelo.Parqueadero;

/**
 *
 * @author PC05
 */
public class DaoParqueaderoImplementar implements Dao<Parqueadero> {

    public DaoParqueaderoImplementar() {
        try {
            DbConnectionFactory.connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoParqueaderoImplementar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DaoParqueaderoImplementar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void guardar(Parqueadero parqueadero) {
        Connection connection = DbConnectionFactory.getConnection();
        PreparedStatement pst;
        try {
            pst = connection.prepareStatement("INSERT INTO parqueadero(nombre,descripcion,valor_por_hora) values(?,?,?)");
            pst.setString(1, parqueadero.getNombre());
            pst.setString(2, parqueadero.getDescripcion());
            pst.setInt(3, parqueadero.getValorPorHora());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoVehiculoImplementar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Parqueadero> listar() {
        List<Parqueadero> lista = new ArrayList<>();
        Connection connection = DbConnectionFactory.getConnection();
        PreparedStatement pst;
        try {
            pst = connection.prepareStatement("Select * from parqueadero");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Parqueadero parqueadero = new Parqueadero();
                parqueadero.setId(rs.getInt("id"));
                parqueadero.setNombre(rs.getString("nombre"));
                parqueadero.setValorPorHora(rs.getInt("valor_por_hora"));
                parqueadero.setDescripcion(rs.getString("descripcion"));
                lista.add(parqueadero);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoParqueaderoImplementar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public Parqueadero obtener(int id) {
        String sql = "Select * from parqueadero where id=?";
        Connection connection = DbConnectionFactory.getConnection();
        Parqueadero parqueadero = new Parqueadero();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                parqueadero.setId(id);
                parqueadero.setNombre(resultSet.getString("nombre"));
                parqueadero.setDescripcion(resultSet.getString("descripcion"));
                parqueadero.setValorPorHora(resultSet.getInt("valor_por_hora"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoVehiculoImplementar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return parqueadero;
    }

}
