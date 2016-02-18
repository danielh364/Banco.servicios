/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.business.service.UsuarioService;
import com.fpmislata.banco.core.BusinessException;
import com.fpmislata.banco.persistence.dao.UsuarioDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author danie
 */
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario> implements UsuarioService {

    @Autowired
    UsuarioDAO usuarioDAO;

    @Override
    public Usuario FindByUserName(String UserName) throws BusinessException {
        return usuarioDAO.FindByUserName(UserName);
    }

    @Override
    public List<Usuario> findByNombre(String nombre) {
        return usuarioDAO.findByNombre(nombre);
    }

    @Override
    public Usuario getByDni(String dni) throws BusinessException {
        return usuarioDAO.getByDni(dni);
    }

}
