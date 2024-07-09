package com.example.comercio.ventasComercio.repositories;

import com.example.comercio.ventasComercio.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    //Query Methods

}