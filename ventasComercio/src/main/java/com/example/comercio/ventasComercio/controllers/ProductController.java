package com.example.comercio.ventasComercio.controllers;

import com.example.comercio.ventasComercio.entities.Product;
import com.example.comercio.ventasComercio.servicies.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @Autowired
    private ProductService service;

    //Crear Producto
    @PostMapping()
    public ResponseEntity<Product> create(@RequestBody Product product) {
        try {
            return new ResponseEntity<>(service.save(product), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Leer productos
    @GetMapping("/")
    public ResponseEntity<List<Product>> readAll() {
        try {
            List<Product> products = service.readAll();
            if (!products.isEmpty()) {
                return ResponseEntity.ok(products);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    //leer por id
    @GetMapping("/{id}")
    public ResponseEntity<Product> readById(@PathVariable Long id) {
        try {
            Product product = service.findById(id);
            if (product != null) {
                return ResponseEntity.ok(product);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //actualizar por id
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product productDetails) {
        try {
            Product product = service.findById(id);
            if (product != null) {
                product.setDescripcion(productDetails.getDescripcion());
                product.setCode(productDetails.getCode());
                product.setStock(productDetails.getStock());
                product.setPrecio(productDetails.getPrecio());
                // Actualiza otros campos según sea necesario
                service.save(product);
                return ResponseEntity.ok(product);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    ////////////////////// OTROS Metodos ////////////////////////////////

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            Product product = service.findById(id);
            if (product != null) {
                service.delete(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
