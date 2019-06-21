package com.client.service;

import com.client.repository.ClientRepository;
import com.client.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
