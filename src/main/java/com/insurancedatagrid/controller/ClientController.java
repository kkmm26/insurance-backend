package com.insurancedatagrid.controller;

import com.insurancedatagrid.service.ClientService;
import java.util.List;
import com.insurancedatagrid.model.ClientEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/clients")
@CrossOrigin(origins = "http://localhost:5173")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public List<ClientEntity> findAllClients() {
        return service.getAllClients();
    }

    @PostMapping
    public void addClient(@RequestBody ClientEntity client) {
        service.saveClient(client);
    }

    @DeleteMapping("/{clientId}")
    public void deleteClient(@PathVariable Integer clientId) {
        ClientEntity client = service.getClientById(clientId);
        service.deleteClient(client);
    }

    
}
