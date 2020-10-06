/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.models.services;

import com.example.demo.models.dao.ProductoDao;
import com.example.demo.models.documents.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 *
 * @author PaulRCam
 */

@Service
public class ProductoImp implements ProductoService{

    @Autowired
    ProductoDao productoDao;
    
    
    @Override
    public Flux<Producto> findAll() {
       return productoDao.findAll();
         
    }
    
}
