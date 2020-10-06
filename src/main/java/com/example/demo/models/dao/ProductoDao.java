/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.models.dao;

import com.example.demo.models.documents.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 *
 * @author PaulRCam
 */
public interface ProductoDao extends ReactiveMongoRepository<Producto, String>{
    
}
