package com.example.comercio.ventasComercio.servicies;

import com.example.comercio.ventasComercio.repositories.InvoiceDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceDetailsService {
    @Autowired
    private InvoiceDetailsRepository repository;
}
