/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintViolation;

/**
 *
 * @author alumno
 */
public class BusinessException extends Exception {

    private List<BusinessMessage> businessMessages = new ArrayList<>();

    public BusinessException(String fieldName, String mensaje) {
        BusinessMessage businessMessage = new BusinessMessage(fieldName, mensaje);
        this.businessMessages.add(businessMessage);
    }

    public BusinessException(List<BusinessMessage> businessMessages) {
        this.businessMessages = businessMessages;
    }

    public BusinessException(org.hibernate.exception.ConstraintViolationException cve) {
        SQLException sqlException = cve.getSQLException();
        if (sqlException.getErrorCode() == 1062 && sqlException.getSQLState().equals("23000")) {
            BusinessMessage businessMessage = new BusinessMessage("valorDuplicado: ", "El valor está duplicado");
        } else {
            throw new RuntimeException(cve);
        }
    }

    public List<BusinessMessage> getBusinessMessages() {
        return businessMessages;
    }

    /**
     *
     * @param cve
     */
    public BusinessException(javax.validation.ConstraintViolationException cve) {
        for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
            
            String fieldName = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();

            businessMessages.add(new BusinessMessage(fieldName, message));
        }
    }

    public void setBusinessMessages(List<BusinessMessage> businessMessages) {
        this.businessMessages = businessMessages;
    }

}