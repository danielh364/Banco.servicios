/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author alumno
 */

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public enum Rol {

    cliente, trabajador;
}


