/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao;

import com.fpmislata.banco.business.domain.SucursalBancaria;
import com.fpmislata.banco.core.BusinessException;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface SucursalBancariaDAO extends GenericDAO<SucursalBancaria> {

    List<SucursalBancaria> getByEntidad(int idEntidadBancaria) throws BusinessException;

    SucursalBancaria getByCodigoSucursal(int codigoSucursal) throws BusinessException;

}
