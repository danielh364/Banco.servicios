/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.jdbc.impl;

import com.fpmislata.banco.persistence.jdbc.DatabaseMigration;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author danie
 */
public class DatabaseMigrationImplFlyWay implements DatabaseMigration {
@Autowired
DataSource dataSource;

    @Override
    public void migrate(String datasourceName, String packageName) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setLocations("./scripts");
        flyway.setEncoding("utf-8");
        flyway.migrate();
    }

}
