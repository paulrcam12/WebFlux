/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.models.dao.PulsoDao;
import com.example.demo.models.documents.Pulso;
import com.example.demo.models.services.PulsoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    //private PulsoService service;
    private PulsoDao service;

    @GetMapping
    public Mono<ResponseEntity<Flux<Pulso>>> lista() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .body(service.findAll()
                        )
        );
    }

}
