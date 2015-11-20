/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.core;

/**
 *
 * @author alumno
 */
public class BusinessMessage {

    private String mensaje;
    private String fieldName;

    public BusinessMessage() {
    }

    public BusinessMessage(String mensaje, String fieldName) {
        this.mensaje = mensaje;
        this.fieldName = fieldName;
    }

}
