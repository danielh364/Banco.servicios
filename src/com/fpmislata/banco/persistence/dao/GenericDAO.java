/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao;

import java.util.List;

/**
 *
 * @author alumno
 * @param <T>
 */
public interface GenericDAO<T> {

    T get(int id);

    T insert(T entidadBancaria);

    T update(T entidadBancaria);

    boolean delete(int id);

    List<T> findAll();

}
