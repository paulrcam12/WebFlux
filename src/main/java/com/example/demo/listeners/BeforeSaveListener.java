/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.listeners;

import com.example.demo.SpringWebFluxApplication;
import com.example.demo.domain.BaseEntity;
import com.example.demo.models.documents.Pulso;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;

/**
 *
 * @author PaulRCam
 */


public class BeforeSaveListener  extends AbstractMongoEventListener<Pulso>{
    
    
    private static final Logger log= LoggerFactory.getLogger(BeforeSaveListener.class);
     @Override
    public void onAfterSave(AfterSaveEvent<Pulso> event) {

         System.out.println("Ok");
        super.onAfterSave(event);
    }
    
    
}
