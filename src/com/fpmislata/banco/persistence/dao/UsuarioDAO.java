/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao;

import com.fpmislata.banco.business.domain.Usuario;

/**
 *
 * @author danie
 */
public interface UsuarioDAO extends GenericDAO<Usuario>{
    Usuario FindByUserName(String UserName);
}
