/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service;

import com.fpmislata.banco.business.domain.SucursalBancaria;
import com.fpmislata.banco.core.BusinessException;
import java.util.List;

/**
 *
 * @author danie
 */
public interface SucursalBancariaService extends GenericService<SucursalBancaria> {

    List<SucursalBancaria> getByEntidad(int idEntidadBancaria) throws BusinessException;


}
