/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.models.services;

import com.example.demo.models.dao.PulsoDao;
import com.example.demo.models.documents.Pulso;
import static com.mongodb.client.model.Filters.where;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ChangeStreamEvent;
import org.springframework.data.mongodb.core.ChangeStreamOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author PaulRCam
 */
@Service
public class PulsoImp implements PulsoService {

    @Autowired
    PulsoDao pulsoDao;

    @Autowired
    ReactiveMongoTemplate reactiveTemplate;

    @Override
    public Flux<Pulso> findAll() {

        return pulsoDao.findAll();
    }

    @Override
    public Flux<Pulso> subscribe() {
        //Aggregation fluxAggregation = new Aggregation(match(where("fullDocument._id").is(new ObjectId(Machine))));
//Aggregation fluxAggregation= Aggregation.newAggregation(match(where("fullDocument._id").is("19")));
        //Aggregation fluxAggregation = newAggregation(match(where("fullDocument._id").is(new ObjectId(postId))));

        MatchOperation match = new MatchOperation(Criteria.where("fullDocument.idPulses").is(19));

        
        Aggregation fluxAggregation= Aggregation.newAggregation(match);
        ChangeStreamOptions options = ChangeStreamOptions.builder()
                .returnFullDocumentOnUpdate()
                .filter(fluxAggregation)
                .build();

        return reactiveTemplate.changeStream("pulsos",
                options,
                Pulso.class)
                .map(ChangeStreamEvent::getBody);

    }

    @Override
    public Mono<Pulso> find(String pulsoId) {
        return this.pulsoDao.findById(pulsoId);
    }

    @Override
    public Flux<Pulso> subscribe1(String pulsoId) {
           
    Aggregation fluxAggregation = Aggregation.newAggregation(new MatchOperation (Criteria.where("fullDocument._id").is(new ObjectId(pulsoId))));


    ChangeStreamOptions options = ChangeStreamOptions.builder()
                                                     .returnFullDocumentOnUpdate()
                                                     .filter(fluxAggregation)
                                                     .build();

    return reactiveTemplate.changeStream("Pulsos",
                                         options,
                                         Pulso.class)
                           .map(ChangeStreamEvent::getBody);

    }
    


}
