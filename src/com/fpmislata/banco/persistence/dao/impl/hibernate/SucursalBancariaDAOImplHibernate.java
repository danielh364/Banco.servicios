/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.hibernate;

import com.fpmislata.banco.business.domain.SucursalBancaria;
import com.fpmislata.banco.core.BusinessException;
import com.fpmislata.banco.persistence.dao.SucursalBancariaDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author danie
 */
public class SucursalBancariaDAOImplHibernate extends GenericDAOImplHibernate<SucursalBancaria> implements SucursalBancariaDAO {

  
    @Override
    public List<SucursalBancaria> getByEntidad(int idEntidadBancaria) throws BusinessException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT sucursalbancaria FROM SucursalBancaria sucursalbancaria WHERE idEntidadBancaria=?");
        query.setInteger(0, idEntidadBancaria);
        List<SucursalBancaria> sucursalesBancarias = query.list();
        
        session.getTransaction().commit();

        return sucursalesBancarias;
    }

    @Override
    public SucursalBancaria getByCodigoSucursal(int codigoSucursal) throws BusinessException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT sucursalbancaria FROM SucursalBancaria sucursalbancaria WHERE codigoSucursalBancaria=?");
        query.setInteger(0, codigoSucursal);
        List<SucursalBancaria> sucursalesBancarias = query.list();
        SucursalBancaria sucursalBancaria = sucursalesBancarias.get(0);
        
        session.getTransaction().commit();
        
        return sucursalBancaria;
        
    }


}
