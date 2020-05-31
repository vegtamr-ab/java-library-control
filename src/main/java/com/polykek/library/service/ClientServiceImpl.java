package com.polykek.library.service;

import com.polykek.library.entity.Client;
import com.polykek.library.exception.ClientNotFoundException;
import com.polykek.library.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public List<Client> listClients() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Client findClient(long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            return optionalClient.get();
        } else {
            throw new ClientNotFoundException("Client not found!");
        }
    }

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(long id, Client client) {
        Client existingClient = findClient(id);
        BeanUtils.copyProperties(client, existingClient);
        return clientRepository.save(existingClient);
    }

    @Override
    public void deleteClient(long id) {
        clientRepository.delete(findClient(id));
    }
}
