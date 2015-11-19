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
            } else {
                usuario = null;
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
            } else {
                usuario = null;
            }
            connectionFactory.close(connection);
            return usuario;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public Usuario insert(Usuario usuario) {

        try {
            Connection connection = connectionFactory.getConnection();
            String sql = "select into usuario values(null,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getNombreUsuario());
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(1, usuario.getApellido());
            preparedStatement.setString(1, usuario.getDni());
            preparedStatement.setString(1, usuario.getDireccion());
            preparedStatement.setString(1, usuario.getEmail());
            preparedStatement.setString(1, usuario.getPassword());
            preparedStatement.setString(1, usuario.getRol().name());
            preparedStatement.execute();
            ResultSet resulclave = preparedStatement.getGeneratedKeys();
            if (resulclave.next()) {
                usuario.setIdusuario(resulclave.getInt(1));
            } else {
                throw new RuntimeException("Error SQL");
            }

            connectionFactory.close(connection);
            return usuario;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public Usuario update(Usuario usuario) {
        try {
            Usuario usuarioDevolver;
            Connection connection = connectionFactory.getConnection();
            String sql = "update usuario set nombreusuario=?,nombre=?,apellido=?,dni=?,direccion=?,email=?,password=?,rol=? where idusuario=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getNombreUsuario());
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(1, usuario.getApellido());
            preparedStatement.setString(1, usuario.getDni());
            preparedStatement.setString(1, usuario.getDireccion());
            preparedStatement.setString(1, usuario.getEmail());
            preparedStatement.setString(1, usuario.getPassword());
            preparedStatement.setString(1, usuario.getRol().name());
            preparedStatement.setInt(1, usuario.getIdusuario());
            int numFilas = preparedStatement.executeUpdate();

            if (numFilas == 0) {
                usuarioDevolver = null;
            }
            if (numFilas == 1) {
                usuarioDevolver = this.get(usuario.getIdusuario());
            } else {
                throw new RuntimeException("Hay mas de una fila para modificar");
            }
            connectionFactory.close(connection);
            return usuarioDevolver;
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
            int numFilas = preparedStatement.executeUpdate();

            if (numFilas == 1) {
                comprobar = true;
            } else if (numFilas == 0) {
                comprobar = false;
            } else {
                throw new RuntimeException("Hay mas de una fila para borrar");
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
