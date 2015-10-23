/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service;

import java.util.List;

/**
 *
 * @author alumno
 * @param <EB>
 */
public interface GenericService <EB>{
      EB get(int id);
    void insert(EB entidadBancaria);
    void update(EB entidadBancaria);
    boolean delete(int id);
    List<EB> findAll();
}
