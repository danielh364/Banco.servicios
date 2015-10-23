/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.persistence.impl.GenericDAO;
import java.util.List;


/**
 *
 * @author alumno
 */
public interface EntidadBancariaDAO extends GenericDAO<EntidadBancaria>{
     List<EntidadBancaria> findByNombre(String nombre);
}
