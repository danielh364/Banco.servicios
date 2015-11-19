/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.security.impl;

import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.security.Authorization;

/**
 *
 * @author alumno
 */
public class AuthorizationImplDummy implements Authorization {

    @Override
    public boolean authorizedURL(Usuario user, String URL, String metodo) {

        boolean autorizado;

        if (URL.equalsIgnoreCase("/Banco.api/api/login")) {
            autorizado = true;
        } else {
            if (user != null) {
                autorizado = true;
            } else {
                autorizado = false;
            }
        }
        return autorizado;
    }

}
