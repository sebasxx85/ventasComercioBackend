package com.example.comercio.ventasComercio.repositories;

import com.example.comercio.ventasComercio.entities.InvoiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDetailsRepository extends JpaRepository<InvoiceDetails, Integer> {

    //Query Methods

}
