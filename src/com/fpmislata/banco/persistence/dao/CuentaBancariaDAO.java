/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao;

import com.fpmislata.banco.business.domain.CuentaBancaria;
import com.fpmislata.banco.core.BusinessException;
import java.util.List;

/**
 *
 * @author danie
 */
public interface CuentaBancariaDAO extends GenericDAO<CuentaBancaria> {

    List<CuentaBancaria> findBySucursal(int idSucursalBancaria) throws BusinessException;

    List<CuentaBancaria> findByUsuario(int idUsuario) throws BusinessException;

    CuentaBancaria getByNumeroCuenta(String numeroCuenta) throws BusinessException;
}
