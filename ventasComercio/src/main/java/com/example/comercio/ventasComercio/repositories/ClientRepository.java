package com.example.comercio.ventasComercio.repositories;


import com.example.comercio.ventasComercio.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    //Se usa camelCase
    public Client findByUserAndPassword(String user, String password);



}

