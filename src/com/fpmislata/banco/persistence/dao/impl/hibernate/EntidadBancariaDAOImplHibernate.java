/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.hibernate;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.persistence.dao.EntidadBancariaDAO;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alumno
 */
public class EntidadBancariaDAOImplHibernate implements EntidadBancariaDAO {

    @Override
    public List<EntidadBancaria> findByNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    @Override
    public EntidadBancaria get(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        EntidadBancaria entidadBancaria = (EntidadBancaria) session.get(EntidadBancaria.class, id);

        session.getTransaction().commit();
        session.close();
        return entidadBancaria;

    }

    @Override
    public EntidadBancaria insert(EntidadBancaria t) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        EntidadBancaria entidadBancaria = (EntidadBancaria) session.save(t);

        session.getTransaction().commit();
        session.close();
        return entidadBancaria;

    }

    @Override
    public EntidadBancaria update(EntidadBancaria t) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(t);

        session.getTransaction().commit();
        session.close();
        return t;

    }

    @Override
    public boolean delete(int id) {

        boolean devolver;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        EntidadBancaria entidadBancaria = this.get(id);

        if (entidadBancaria != null) {
            devolver = true;
            session.delete(entidadBancaria);
        } else {
            devolver = false;
        }

        session.getTransaction().commit();
        session.close();
        return devolver;

    }

    @Override
    public List<EntidadBancaria> findAll() {

        throw new UnsupportedOperationException("Not supported yet.");

    }

}
