package com.example.comercio.ventasComercio.controllers;

import com.example.comercio.ventasComercio.servicies.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @Autowired
    private ProductService service;



}
