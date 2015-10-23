package com.fpmislata.banco.persistence.impl.jdbc;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.persistence.EntidadBancariaDAO;
import com.fpmislata.banco.util.DateConverter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class EntidadBancariaDAOImplJDBC implements EntidadBancariaDAO {
    @Autowired
    ConnectionFactory connectionFactory;
    
    
   
    public EntidadBancariaDAOImplJDBC() {     
//        connectionFactory = new ConnectionFactoryImplDriverManager();  
    }
    
    @Override
    public EntidadBancaria get(int idEntidadBancaria) {
        Connection connection;
        connection = connectionFactory.getConnection();
        EntidadBancaria entidadBancaria = null;
        ResultSet resultSet = null;
        String sql = "SELECT * from entidadBancaria WHERE idEntidadBancaria = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idEntidadBancaria);
            
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                entidadBancaria = new EntidadBancaria(resultSet.getInt("idEntidadBancaria"),resultSet.getString("nombre"), resultSet.getString("codigoEntidad"), resultSet.getDate("fechaCreacion"), resultSet.getString("direccion"), resultSet.getString("cif"));
            } else {
                entidadBancaria = null;
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error SQL: " + ex.getMessage());
        }
        connectionFactory.close(connection);
        return entidadBancaria;
    }
    
    @Override
    public void insert(EntidadBancaria entidadBancaria) {
        Connection connection;
        connection = connectionFactory.getConnection();
        try {
            String sql = "INSERT INTO entidadBancaria VALUES (null,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setString(2, entidadBancaria.getCodigoEntidad());
            java.sql.Date fechaSQL = new java.sql.Date(entidadBancaria.getFechaCreacion().getTime());
            preparedStatement.setDate(3, fechaSQL);
            preparedStatement.setString(4, entidadBancaria.getDireccion());
            preparedStatement.setString(5, entidadBancaria.getCif());
            preparedStatement.execute();
            ResultSet resulclave = preparedStatement.getGeneratedKeys();
            if (resulclave.next()) {
                entidadBancaria.setIdEntidadBancaria(resulclave.getInt(1));
            } else {
                throw new RuntimeException("Error SQL");
            }
            
            connectionFactory.close(connection);
            
            
        } catch (SQLException ex) {
            throw new RuntimeException("Error SQL: " + ex.getMessage());
        }
        
    }
    
    @Override
    public void update(EntidadBancaria entidadBancaria) {
        Connection connection;
        connection = connectionFactory.getConnection();
        try {
            String sql = "UPDATE entidadBancaria set nombre=?,codigoEntidad=?,fechaCreacion=?,direccion=?,cif=? where idEntidadBancaria = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setString(2, entidadBancaria.getCodigoEntidad());
            preparedStatement.setDate(3, DateConverter.utilDateToSqlDate(entidadBancaria.getFechaCreacion()));
            preparedStatement.setString(4, entidadBancaria.getDireccion());
            preparedStatement.setString(5, entidadBancaria.getCif());
            preparedStatement.setInt(6, entidadBancaria.getIdEntidadBancaria());
            preparedStatement.executeUpdate();
            connectionFactory.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException("Error SQL: " + e.getMessage());
        }
    }
    
    @Override
    public boolean delete(int idEntidadBancaria) {
        Connection connection;
        connection = connectionFactory.getConnection();
        boolean borrado = false;
        String sql = "DELETE from entidadBancaria WHERE idEntidadBancaria = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idEntidadBancaria);
            int filas = preparedStatement.executeUpdate();
            if (filas == 1) {
                borrado = true;
            } else {
                borrado = false;
                
            }
            connectionFactory.close(connection);
            
        } catch (SQLException e) {
            throw new RuntimeException("Error SQL: " + e.getMessage());
        }
        return borrado;
    }
    
    @Override
    public List<EntidadBancaria> findAll() {
        Connection connection;
        connection = connectionFactory.getConnection();
        List<EntidadBancaria> entidades = new ArrayList();
        String sql = "SELECT * FROM entidadBancaria;";        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EntidadBancaria entidadBancaria = new EntidadBancaria(resultSet.getInt("idEntidadBancaria"),
                        resultSet.getString("nombre"),
                        resultSet.getString("codigoEntidad"),
                        resultSet.getDate("fechaCreacion"),
                        resultSet.getString("direccion"),
                        resultSet.getString("cif"));
                entidades.add(entidadBancaria);
            }
   //         Thread.sleep(14000);
            connectionFactory.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException("Error SQL:" + e.getMessage());
        } 
        return entidades;
    }
    @Override
    public List<EntidadBancaria> findByNombre(String nombre) {
        Connection connection;
        connection = connectionFactory.getConnection();
        List<EntidadBancaria> entidades = new ArrayList<>();
        String sql = "SELECT * FROM entidadBancaria WHERE nombre = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombre);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                EntidadBancaria entidadBancaria = new EntidadBancaria(resultSet.getInt("idEntidadBancaria"),
                        resultSet.getString("nombre"),
                        resultSet.getString("codigoEntidad"),
                        resultSet.getDate("fechaCreacion"),
                        resultSet.getString("direccion"),
                        resultSet.getString("cif"));
                entidades.add(entidadBancaria);
            }
             connectionFactory.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException("Error SQL: " + e.getMessage());
        }
        return entidades;
    }
    
}
