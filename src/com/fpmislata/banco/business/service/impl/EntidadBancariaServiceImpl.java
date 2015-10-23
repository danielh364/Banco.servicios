/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.business.service.EntidadBancariaService;
import com.fpmislata.banco.persistence.EntidadBancariaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author alumno
 */
public class EntidadBancariaServiceImpl implements EntidadBancariaService {

    @Autowired
    EntidadBancariaDAO entidadBancaria;

    @Override
    public List<EntidadBancaria> findByNombre(String nombre) {
        return entidadBancaria.findByNombre(nombre);
    }

    @Override
    public EntidadBancaria get(int id) {
        return entidadBancaria.get(id);
    }

    @Override
    public void insert(EntidadBancaria entidadBancaria) {
        this.entidadBancaria.insert(entidadBancaria);
    }

    @Override
    public void update(EntidadBancaria entidadBancaria) {
        this.entidadBancaria.update(entidadBancaria);
    }

    @Override
    public boolean delete(int id) {
        return entidadBancaria.delete(id);
    }

    @Override
    public List<EntidadBancaria> findAll() {
        return entidadBancaria.findAll();
    }

}
