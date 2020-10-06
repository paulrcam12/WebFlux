/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.models.services;

import com.example.demo.models.documents.Pulso;
import reactor.core.publisher.Flux;

/**
 *
 * @author PaulRCam
 */

public interface PulsoService {
    
    public Flux<Pulso> findAll();
    

    Flux<Pulso> subscribe();
}
