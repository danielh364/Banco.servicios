/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.jdbc;

import com.fpmislata.banco.business.domain.Rol;
import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.persistence.dao.UsuarioDAO;
import com.fpmislata.banco.persistence.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author danie
 */
public class UsuarioDAOImplJDBC implements UsuarioDAO {

    @Autowired
    ConnectionFactory connectionFactory;

    @Override
    public Usuario FindByUserName(String UserName) {

        try {
            Connection connection = connectionFactory.getConnection();
            String sql = "select * from usuario where nombreUsuario=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, UserName);
            ResultSet resultSet = preparedStatement.executeQuery();
            Usuario usuario = null;
            if (resultSet.next()) {
                int idusuario = resultSet.getInt("idusuario");
                String nombreUsuario = resultSet.getString("nombreUsuario");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String dni = resultSet.getString("dni");
                String direccion = resultSet.getString("direccion");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String rol = resultSet.getString("rol");
                String rolUpper = rol.toUpperCase();
                Rol rolUsuario = Rol.valueOf(rolUpper);
                usuario = new Usuario(idusuario, nombreUsuario, nombre, apellido, dni, direccion, email, password, rolUsuario);
            }
            connectionFactory.close(connection);
            return usuario;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Usuario get(int id) {
        try {
            Connection connection = connectionFactory.getConnection();
            String sql = "select * from usuario where idUsuario=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Usuario usuario = null;
            if (resultSet.next()) {
                int idusuario = resultSet.getInt("idusuario");
                String nombreUsuario = resultSet.getString("nombreUsuario");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String dni = resultSet.getString("dni");
                String direccion = resultSet.getString("direccion");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String rol = resultSet.getString("rol");
                String rolUpper = rol.toUpperCase();
                Rol rolUsuario = Rol.valueOf(rolUpper);
                usuario = new Usuario(idusuario, nombreUsuario, nombre, apellido, dni, direccion, email, password, rolUsuario);
            }
            connectionFactory.close(connection);
            return usuario;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void insert(Usuario Usuario) {

        try {
            Connection connection = connectionFactory.getConnection();
            String sql = "select into usuario values(null,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Usuario.getNombreUsuario());
            preparedStatement.setString(1, Usuario.getNombre());
            preparedStatement.setString(1, Usuario.getApellido());
            preparedStatement.setString(1, Usuario.getDni());
            preparedStatement.setString(1, Usuario.getDireccion());
            preparedStatement.setString(1, Usuario.getEmail());
            preparedStatement.setString(1, Usuario.getPassword());
            preparedStatement.setString(1, Usuario.getRol().name());
            preparedStatement.execute();

            connectionFactory.close(connection);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void update(Usuario Usuario) {
        try {
            Connection connection = connectionFactory.getConnection();
            String sql = "update usuario set nombreusuario=?,nombre=?,apellido=?,dni=?,direccion=?,email=?,password=?,rol=? where idusuario=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Usuario.getNombreUsuario());
            preparedStatement.setString(1, Usuario.getNombre());
            preparedStatement.setString(1, Usuario.getApellido());
            preparedStatement.setString(1, Usuario.getDni());
            preparedStatement.setString(1, Usuario.getDireccion());
            preparedStatement.setString(1, Usuario.getEmail());
            preparedStatement.setString(1, Usuario.getPassword());
            preparedStatement.setString(1, Usuario.getRol().name());
            preparedStatement.setInt(1, Usuario.getIdusuario());
            preparedStatement.executeUpdate();
            connectionFactory.close(connection);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean delete(int id) {

        try {
            boolean comprobar;
            Connection connection = connectionFactory.getConnection();
            String sql = "delete from usuario where idusuario=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int filas = preparedStatement.executeUpdate();

            if (filas == 0) {
                comprobar = false;
            } else {
                comprobar = true;
            }
            connectionFactory.close(connection);
            return comprobar;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public List<Usuario> findAll() {

        try {
            ArrayList<Usuario> usuarios = new ArrayList();
            Connection connection = connectionFactory.getConnection();
            String sql = "select * from usuario";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            Usuario usuario = null;
            while (resultSet.next()) {
                int idusuario = resultSet.getInt("idusuario");
                String nombreUsuario = resultSet.getString("nombreUsuario");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String dni = resultSet.getString("dni");
                String direccion = resultSet.getString("direccion");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String rol = resultSet.getString("rol");
                String rolUpper = rol.toUpperCase();
                Rol rolUsuario = Rol.valueOf(rolUpper);
                usuario = new Usuario(idusuario, nombreUsuario, nombre, apellido, dni, direccion, email, password, rolUsuario);
                usuarios.add(usuario);
            }
            connectionFactory.close(connection);
            return usuarios;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

}
