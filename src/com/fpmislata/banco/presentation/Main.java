/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentation;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.business.service.EntidadBancariaService;
import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        EntidadBancariaService  entidadBancariaService=context.getBean(EntidadBancariaService.class);

        EntidadBancaria entidadBancaria = new EntidadBancaria("autowire","011",new Date(),"av a","4VFHYTa");
        EntidadBancaria entidadBancaria2 = new EntidadBancaria("sabadell","02342",new Date(),"avasdb","DWTG9");
        EntidadBancaria entidadBancaria3 = new EntidadBancaria("Banco","333",new Date(),"av c","WERQ");

        entidadBancariaService.insert(entidadBancaria);
        entidadBancariaService.insert(entidadBancaria2);
        entidadBancariaService.insert(entidadBancaria3);
        //System.out.println(entidadBancariaDAO.get(1).toString());
        
//        EntidadBancaria entidadBancariaUpdated = new EntidadBancaria(1,"Bankia","011",new Date(),"Calle Verdadera 3","456468a");
//        entidadBancariaDAO.update(entidadBancariaUpdated);
        //System.out.println(entidadBancariaDAO.delete(1));
        //List<EntidadBancaria> entidades = entidadBancariaDAO.findAll();
        //for(EntidadBancaria e: entidades){
        //    System.out.println(e.toString()+"\n");
        //}
        
//        List<EntidadBancaria> entidades = entidadBancariaDAO.findByNombre("Banco");
//        for(EntidadBancaria e: entidades){
//            System.out.println(e.toString());
//        }
    }
    
}
