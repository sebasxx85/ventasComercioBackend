package com.example.comercio.ventasComercio.repositories;

import com.example.comercio.ventasComercio.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //Query Methods

}