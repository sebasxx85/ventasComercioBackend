package com.example.comercio.ventasComercio.controllers;

import com.example.comercio.ventasComercio.servicies.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService service;


}
