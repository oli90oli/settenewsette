package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.Clients;
import com.sette.clipping.main.services.ClientsService;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    private final ClientsService clientService;
    public ClientsController(ClientsService clientService){
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Clients>> getAllClients() {
        List<Clients> clients = clientService.findAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clients> getClientsByID(@PathVariable("id") int id) {
        Clients client = clientService.findClients(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Clients> addClients(@RequestBody Clients client) {
        Clients newClient = clientService.addClients(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public void updateClients(@PathVariable int id, @RequestBody Clients client){
        clientService.updateClients(id, client);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClientsByID(@PathVariable("id") int id) {
        clientService.deleteClients(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}