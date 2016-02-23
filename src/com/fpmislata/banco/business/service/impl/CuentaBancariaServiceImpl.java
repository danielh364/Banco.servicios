/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.CuentaBancaria;
import com.fpmislata.banco.business.service.CuentaBancariaService;
import com.fpmislata.banco.core.BusinessException;
import com.fpmislata.banco.persistence.dao.CuentaBancariaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author danie
 */
public class CuentaBancariaServiceImpl extends GenericServiceImpl<CuentaBancaria> implements CuentaBancariaService {

    @Autowired
    CuentaBancariaDAO cuentaBancariaDAO;

    @Override
    public List<CuentaBancaria> findBySucursal(int idSucursalBancaria) throws BusinessException {
        return cuentaBancariaDAO.findBySucursal(idSucursalBancaria);

    }

    @Override
    public List<CuentaBancaria> findByUsuario(int idUsuario) throws BusinessException {
        return cuentaBancariaDAO.findByUsuario(idUsuario);
    }

    @Override
    public CuentaBancaria getByNumeroCuenta(String numeroCuenta) throws BusinessException {
        return cuentaBancariaDAO.getByNumeroCuenta(numeroCuenta);

    }

}
