/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.hibernate;

import com.fpmislata.banco.core.BusinessException;
import com.fpmislata.banco.persistence.dao.GenericDAO;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author danie
 * @param <T>
 */
public class GenericDAOImplHibernate<T> implements GenericDAO<T> {

    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T get(int id) {
      Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        T t = (T) session.get(getEntityClass(), id);

        session.getTransaction().commit();
        session.close();

        return t;
    }

    @Override
    public T insert (T t) throws BusinessException {
      Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();

            return t;
        } catch (org.hibernate.exception.ConstraintViolationException ex) {
            throw new BusinessException(ex);
        } catch (javax.validation.ConstraintViolationException cve) {
            throw new BusinessException(cve);
        }
    }

    @Override
    public T update(T t) throws BusinessException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            session.update(t);
            session.getTransaction().commit();

            return t;
        } catch (org.hibernate.exception.ConstraintViolationException ex) {
            throw new BusinessException(ex);
        } catch (javax.validation.ConstraintViolationException cve) {
            throw new BusinessException(cve);
        }
    }

    @Override
    public boolean delete(int id) {
        boolean devolver;
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        T t = this.get(id);

        if (t != null) {
            devolver = true;
            session.delete(t);
        } else {
            devolver = false;
        }

        session.getTransaction().commit();
        session.close();
        return devolver;
    }

    @Override
    public List<T> findAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT e FROM " + getEntityClass().getName() + " e");
        List<T> tes = query.list();

        session.getTransaction().commit();
        return tes;
    }

}