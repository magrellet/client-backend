package com.client.controller;

import com.client.entity.Client;
import com.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getClients (){
        return clientService.findAll();
    }

    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable Long id){
        return clientService.findById(id);
    }

    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@RequestBody Client client){
        return clientService.save(client);
    }

    @PutMapping("/clients/{id}")
    public Client update(@RequestBody Client client, @PathVariable Long id){
        Client clientToEdit = clientService.findById(id);
        clientToEdit.setName(client.getName());
        clientToEdit.setLastName(client.getLastName());
        clientToEdit.setEmail(client.getEmail());
        return clientService.save(clientToEdit);
    }

    @DeleteMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id){
        clientService.delete(id);
    }

}
