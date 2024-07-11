package com.example.comercio.ventasComercio.controllers;

import com.example.comercio.ventasComercio.entities.Client;
import com.example.comercio.ventasComercio.servicies.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/auth")
public class ClientController {

    @Autowired
    private ClientService service;

    //Crear Usuario
    @PostMapping("/register")
    public ResponseEntity<Client> create(@RequestBody Client client) {
        try {
            return new ResponseEntity<>(service.save(client), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    //Actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client userDetails) {
        try {
            Client client = service.findById(id);
            if (client != null) {
                client.setName(userDetails.getName());
                client.setLastname(userDetails.getLastname());
                client.setDni(userDetails.getDni());
                // Actualiza otros campos según sea necesario
                service.save(client);
                return ResponseEntity.ok(client);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

   ////////////////////// OTROS Metodos ////////////////////////////////

    @GetMapping("/")
    public ResponseEntity<List<Client>> readAll() {
        try {
            List<Client> clients = service.readAll();
            if (!clients.isEmpty()) {
                return ResponseEntity.ok(clients);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Client> readById(@PathVariable Long id) {
        try {
            Client client = service.findById(id);
            if (client != null) {
                return ResponseEntity.ok(client);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            Client client = service.findById(id);
            if (client != null) {
                service.delete(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
