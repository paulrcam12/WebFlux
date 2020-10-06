/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.models.dao.PulsoDao;
import com.example.demo.models.documents.Pulso;
import com.example.demo.models.services.PulsoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author PaulRCam
 */
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})

@RestController
@RequestMapping("/api/pulsos")
public class PulsosController {

    
    private static final Logger log= LoggerFactory.getLogger(PulsosController.class);
    
    @Autowired
    private PulsoService service;
    //private PulsoDao service;

    @Tailable
    @GetMapping("/mono/tailable")
    public Mono<ResponseEntity<Flux<Pulso>>> listaTailable() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.TEXT_EVENT_STREAM)
                        .body(service.findAll())
        );
    }

    @GetMapping("/mono")
    public Mono<ResponseEntity<Flux<Pulso>>> lista() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.TEXT_EVENT_STREAM)
                        .body(service.findAll())
        );
    }

    @GetMapping(path = "/flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Pulso> streamAll() {
        return service.findAll();
    }
    
    
    
    @Tailable
    @GetMapping(path = "/Flux/tailable", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Pulso> streamAllTailable() {
        return service.findAll();
    }
    
    @GetMapping(path = "/subscribe", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
public Flux<Pulso> subscribe() {
    
    return this.service.subscribe();
}
}
