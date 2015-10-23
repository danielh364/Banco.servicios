/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.business.service.GenericService;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface EntidadBancariaService extends GenericService <EntidadBancaria> {
    List<EntidadBancaria> findByNombre(String nombre);
}
