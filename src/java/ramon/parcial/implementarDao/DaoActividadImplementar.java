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
import ramon.parcial.modelo.Actividad;
import ramon.parcial.modelo.Parqueadero;
import ramon.parcial.modelo.Vehiculo;


/**
 *
 * @author PC05
 */
public class DaoActividadImplementar implements Dao<Actividad> {

    public DaoActividadImplementar() {
        try {
            DbConnectionFactory.connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoActividadImplementar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DaoActividadImplementar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void guardar(Actividad modelo) {
        Connection connection = DbConnectionFactory.getConnection();
        PreparedStatement pst;
        try {
            pst = connection.prepareStatement("INSERT INTO actividad (vehiculo_id,parqueadero_id,hora_entrada,horas,ubicacion) values(?,?,?,?)");
            pst.setInt(1, modelo.getVehiculo().getId());
            pst.setInt(2, modelo.getParqueadero().getId());
            pst.setDate(3, modelo.getHoraEntrada());
            pst.setString(4, modelo.getUbicacion());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoVehiculoImplementar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Actividad> listar() {
        List<Actividad> lista = new ArrayList<>();
        Dao<Parqueadero> daoParqueadero = new DaoParqueaderoImplementar();
        Dao<Vehiculo> daoVehiculo = new DaoVehiculoImplementar();
        Connection connection = DbConnectionFactory.getConnection();
        PreparedStatement pst;
        try {
            pst = connection.prepareStatement("Select * from Actividad");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Actividad autor = new Actividad();
                autor.setId(rs.getInt("id"));
                autor.setParqueadero(daoParqueadero.obtener(rs.getInt("parqueadero_id")));
                autor.setVehiculo(daoVehiculo.obtener(rs.getInt("vehiculo_id")));
                autor.setUbicacion(rs.getString("ubicacion"));
                autor.setHoras(rs.getInt("horas"));
                autor.setHoraEntrada(rs.getDate("hora_entrada"));
                lista.add(autor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoActividadImplementar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public Actividad obtener(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
