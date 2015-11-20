/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.core;

import java.util.List;

/**
 *
 * @author alumno
 */
public class BusinessException extends Exception {

    private List<BusinessMessage> bms;
    private String propiedad;
    private String mensaje;

    public BusinessException() {
    }

    public BusinessException(String propiedad, String mensaje) {
        this.propiedad = propiedad;
        this.mensaje = mensaje;
    }

    public BusinessException(List<BusinessMessage> bms, String propiedad, String mensaje) {
        this.bms = bms;
        this.propiedad = propiedad;
        this.mensaje = mensaje;
    }
    
    

}
