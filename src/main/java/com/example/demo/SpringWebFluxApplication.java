package com.example.demo;

import com.example.demo.models.dao.ProductoDao;
import com.example.demo.models.documents.Producto;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringWebFluxApplication implements CommandLineRunner {
    @Autowired
    private ProductoDao productoDao;
    @Autowired
    private ReactiveMongoTemplate mongoTemplate;
    
    private static final Logger log= LoggerFactory.getLogger(SpringWebFluxApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringWebFluxApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       /* mongoTemplate.dropCollection("productos").subscribe();
        Flux.just(
                new Producto("TV marca acme", 135.5),
                new Producto("Carro marca acme", 85.1),
                new Producto("Lavadora marca acme", 144.1),
                new Producto("Split", 300.9),
                new Producto("AC", 401.22),
                new Producto("Mesa", 842.1),
                new Producto("Cola", 222.2)
        )
        .flatMap(producto-> {
            producto.setCreateAt(new Date());
            return productoDao.save(producto);
                    })
        
        .subscribe(producto -> log.info("Insert: "+producto.getId()+" "+producto.getNombre()));
               
  */
    }

}


