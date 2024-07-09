package com.example.comercio.ventasComercio.servicies;


import com.example.comercio.ventasComercio.entities.Product;
import com.example.comercio.ventasComercio.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product save(Product product){
        return repository.save(product);
    }

}
