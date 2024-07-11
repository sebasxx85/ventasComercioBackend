package com.example.comercio.ventasComercio.servicies;


import com.example.comercio.ventasComercio.entities.Client;
import com.example.comercio.ventasComercio.entities.Product;
import com.example.comercio.ventasComercio.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product save(Product product){
        return repository.save(product);
    }

    public List<Product> readAll(){
        return repository.findAll();
    }

    public Optional<Product> readOne(Long id){
        return repository.findById(id);
    }

    public Product findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
