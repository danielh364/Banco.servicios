/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.security.impl;

import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.persistence.security.Authorization;

/**
 *
 * @author alumno
 */
public class AuthorizationImplDummy implements Authorization {

    @Override
    public boolean authorizedURL(Usuario user, String URL, String metodo) {

        boolean autorizado = false;

        if (user.getNombre().equalsIgnoreCase("Daniel")) {
            autorizado = true;
        }

        if (URL.equals("/api/login")) {
            autorizado = true;
        }

        return autorizado;
    }

}
