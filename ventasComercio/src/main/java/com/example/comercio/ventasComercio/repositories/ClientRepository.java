package com.desafioCliente.desafio.repositories;

import com.desafioCliente.desafio.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    //Se usa camelCase
    public Client findByUserAndPassword(String user, String password);



}

