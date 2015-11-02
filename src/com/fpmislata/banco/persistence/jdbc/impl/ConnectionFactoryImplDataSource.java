package com.fpmislata.banco.persistence.jdbc.impl;

import com.fpmislata.banco.persistence.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactoryImplDataSource implements ConnectionFactory {

    @Override
    public Connection getConnection() {

        try {
            Connection connection = null;
            InitialContext initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource dataSource = (DataSource) envCtx.lookup("jdbc/banco");
            connection = dataSource.getConnection();
            return connection;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (NamingException ex) {
            throw new RuntimeException("Fallo al conectar con la DB.");
        }

    }

    @Override
    public void close(Connection connection) {

        try {
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Fallo al cerrar la BD.");
        }
    }
}
