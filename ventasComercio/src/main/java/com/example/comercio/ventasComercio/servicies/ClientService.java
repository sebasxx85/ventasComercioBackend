package com.desafioCliente.desafio.servicies;


import com.desafioCliente.desafio.entities.Client;
import com.desafioCliente.desafio.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client save(Client client){
        return repository.save(client);
    }

    public List<Client> readAll(){
        return repository.findAll();
    }

    public Optional<Client> readOne(Long id){
        return repository.findById(id);
    }

    public Client findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


    public ClientDTO login(String user, String password) {
        Client client = repository.findByUserAndPassword(user, password);
        ClientDTO clientDTO = new ClientDTO(client.getId(), client.getName(), client.getLastname(), client.getDni());
        return clientDTO;
    }

    public ClientDTO convertToDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO(client.getId(), client.getName(), client.getLastname(), client.getDni());
        return clientDTO;
    }

    // Método para convertir una lista de Client a una lista de ClientDTO
    public List<ClientDTO> convertToDTOList(List<Client> clients) {
        return clients.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


}
