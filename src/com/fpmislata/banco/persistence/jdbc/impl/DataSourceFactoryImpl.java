/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.jdbc.impl;

import com.fpmislata.banco.persistence.jdbc.DataSourceFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author danie
 */
public class DataSourceFactoryImpl implements DataSourceFactory {

    @Override
    public DataSource getDataSource(String dataSourceName) {
        try {
            InitialContext initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource dataSource = (DataSource) envCtx.lookup("jdbc/"+dataSourceName);

            return dataSource;

        } catch (NamingException ex) {
            throw new RuntimeException(ex);

        }
    }

}
