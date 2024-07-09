package com.example.comercio.ventasComercio.servicies;

import com.example.comercio.ventasComercio.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository repository;
}
