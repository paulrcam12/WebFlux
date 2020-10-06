/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.example.demo.controllers;

import com.example.demo.models.dao.ProductoDao;
import com.example.demo.models.documents.Producto;
import com.example.demo.models.services.ProductoService;
import java.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

/**
 *
 * @author PaulRCam
 */

@Controller
public class ProductoController {
    
    @Autowired
    //private ProductoDao productoDao;
    private ProductoService productoService;
    
    private static final Logger log = LoggerFactory.getLogger(ProductoController.class);
	
    @GetMapping({"listar", "/"})
    public String listar(Model model){
        Flux<Producto> productos= productoService.findAll();
        
        model.addAttribute("productos", productos);
        model.addAttribute("titulo", "Listado de Productos");
        return "listar";
    }
    	@GetMapping("/listar-datadriver")
	public String listarDataDriver(Model model) {
		
		Flux<Producto> productos = productoService.findAll().delayElements(Duration.ofSeconds(1));
		
		productos.subscribe(prod -> log.info(prod.getNombre()));
		
		model.addAttribute("productos", new ReactiveDataDriverContextVariable(productos, 1));
		model.addAttribute("titulo", "Listado de productos");
		return "listar";
	}
        
        	@GetMapping("/listar-full")
	public String listarFull(Model model) {
		
		Flux<Producto> productos = productoService.findAll();
		
		model.addAttribute("productos", productos);
		model.addAttribute("titulo", "Listado de productos");
		return "listar";
	}
	
	@GetMapping("/listar-chunked")
	public String listarChunked(Model model) {
		
		Flux<Producto> productos = productoService.findAll();
		
		model.addAttribute("productos", productos);
		model.addAttribute("titulo", "Listado de productos");
		return "listar-chunked";
	}
}
