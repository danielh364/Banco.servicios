package com.fpmislata.banco.security;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public interface PasswordManager  {
    public String encrypt(String password);
    public boolean compare(String password, String encyptedPassword);
}
