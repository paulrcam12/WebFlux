/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.listeners;

import com.example.demo.domain.BaseEntity;
import java.util.Date;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;

/**
 *
 * @author PaulRCam
 */
public class BeforeSaveListener  extends AbstractMongoEventListener<BaseEntity>{
     @Override
    public void onBeforeSave(BeforeSaveEvent<BaseEntity> event) {

        Date timestamp = new Date();

        // Add a timestamp to the created date if it does not yet exist
        if (event.getSource().getCreatedAt() == null)
            event.getSource().setCreatedAt(timestamp);

        // Update the timestamp to the current time
        event.getSource().setLastModified(timestamp);

        super.onBeforeSave(event);
    }
    
    
}
