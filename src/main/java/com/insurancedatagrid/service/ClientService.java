package com.insurancedatagrid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insurancedatagrid.model.ClientEntity;
import com.insurancedatagrid.repository.ClientRepository;

@Service
public class ClientService {
    
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientEntity> getAllClients() {
        return clientRepository.findAll();
    }

    public ClientEntity saveClient(ClientEntity client) {
        return clientRepository.save(client);
    }

    public ClientEntity getClientById(Integer id) {
        return clientRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
    }

    public ClientEntity getClientByPhone(Integer phone) {
        return clientRepository.findByClientPhone(phone)
            .orElseThrow(() -> new RuntimeException("Client not found with phone: " + phone));
    }

    public ClientEntity getClientByName(String name) {
        return clientRepository.findByClientName(name)
            .orElseThrow(() -> new RuntimeException("Client not found with name: " + name));
    }

    public void deleteClient(ClientEntity client) {
        clientRepository.delete(client);
    }

    public ClientEntity findOrCreateClient(ClientEntity client) {
        ClientEntity existingClient = clientRepository.findByClientPhoneAndClientName(client.getClientPhone(), client.getClientName());
        if (existingClient != null) {
            return existingClient;
        }
        return clientRepository.save(client);
    }

}
