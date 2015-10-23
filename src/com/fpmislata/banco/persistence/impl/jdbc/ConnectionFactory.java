/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.impl.jdbc;

import java.sql.Connection;

/**
 *
 * @author alumno
 */
public interface ConnectionFactory {
    Connection getConnection();
    void close(Connection connection);
}
