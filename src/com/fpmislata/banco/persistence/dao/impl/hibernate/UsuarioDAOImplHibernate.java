/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.hibernate;

import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.core.BusinessException;
import com.fpmislata.banco.persistence.dao.UsuarioDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author danie
 */
public class UsuarioDAOImplHibernate extends GenericDAOImplHibernate<Usuario> implements UsuarioDAO {

    @Override
    public Usuario FindByUserName(String UserName) throws BusinessException {
Usuario usuario;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT usuario FROM Usuario usuario where nick=? ");
        query.setString(0, UserName);
       List<Usuario> usuarios = query.list();

        if (usuarios.isEmpty() || usuarios == null) {
            throw new BusinessException("nick: ", "No existe");
        } else {
            usuario = usuarios.get(0);
            session.getTransaction().commit();
        } 
        return usuario;
    }
    
     @Override
    public List<Usuario> findByNombre(String nombre) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT usuario FROM Usuario usuario WHERE nombre=?");
        query.setString(0, nombre);
        List<Usuario> usuarios = query.list();

    session.getTransaction().commit();
        return usuarios;
    }
    
    @Override
    public Usuario getByDni(String dni) throws BusinessException {
        Usuario usuario;

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT usuario FROM Usuario usuario WHERE dni=?");
        query.setString(0, dni);

        List<Usuario> usuarios = query.list();
        
        if (usuarios.isEmpty() ) {
            throw new BusinessException("DNI", "No existe");
        } else {
            usuario = usuarios.get(0);
            session.getTransaction().commit();
        }

        return usuario;
    }

}
