/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.domain;

import java.io.Serializable;

/**
 *
 * @author alumno
 */
public class SucursalBancaria implements Serializable  {
    
    String nombre;
    String direccion;
    String telefono;
    String director;

    public SucursalBancaria() {
    }

    public SucursalBancaria(String nombre, String direccion, String telefono, String director) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.director = director;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
}
