package com.fpmislata.banco.persistence.security.impl;

import com.fpmislata.banco.persistence.security.PasswordManager;
import org.jasypt.util.password.BasicPasswordEncryptor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alumno
 */
public class PasswordManagerEncryptingImplJasypt implements PasswordManager {

    @Override
    public String encrypt(String password) {
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        return passwordEncryptor.encryptPassword(password);
    }

    @Override
    public boolean compare(String password, String encyptedPassword) {
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        return passwordEncryptor.checkPassword(password, encyptedPassword);

    }

}
