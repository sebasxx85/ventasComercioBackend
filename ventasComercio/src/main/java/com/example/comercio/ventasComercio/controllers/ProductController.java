package com.example.comercio.ventasComercio.controllers;

import com.example.comercio.ventasComercio.entities.Product;
import com.example.comercio.ventasComercio.servicies.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


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


}
