/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.models.services;

import com.example.demo.models.dao.PulsoDao;
import com.example.demo.models.documents.Pulso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 *
 * @author PaulRCam
 */

@Service
public class PulsoImp implements PulsoService{

    
    @Autowired
    PulsoDao pulsoDao;
    
    
    @Override
    public Flux<Pulso> findAll() {
        
        return pulsoDao.findAll();
    }
    
}
