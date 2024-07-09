package com.example.comercio.ventasComercio.controllers;


import com.example.comercio.ventasComercio.servicies.InvoiceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/invoiceDetails")
public class InvoiceDetailsController {

    @Autowired
    private InvoiceDetailsService service;


}

