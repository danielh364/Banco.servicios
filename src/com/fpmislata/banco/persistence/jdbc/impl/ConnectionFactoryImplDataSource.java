package com.fpmislata.banco.persistence.jdbc.impl;

import com.fpmislata.banco.persistence.jdbc.ConnectionFactory;
import com.fpmislata.banco.persistence.jdbc.DataSourceFactory;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ConnectionFactoryImplDataSource implements ConnectionFactory {

    @Autowired
    DataSourceFactory dataSourceFactory;

    @Override
    public Connection getConnection() {

        try {
            Connection connection = null;

            DataSource dataSource = dataSourceFactory.getDataSource("MySQLDS");

            connection = dataSource.getConnection();
            return connection;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
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
