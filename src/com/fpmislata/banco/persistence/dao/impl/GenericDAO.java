/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl;

import java.util.List;

/**
 *
 * @author alumno
 */
public interface GenericDAO <T> {
    T get(int id);
    void insert(T entidadBancaria);
    void update(T entidadBancaria);
    boolean delete(int id);
    List<T> findAll();
   
}
