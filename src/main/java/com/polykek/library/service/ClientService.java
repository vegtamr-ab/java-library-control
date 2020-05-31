package com.polykek.library.service;

import com.polykek.library.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> listClients();

    Client findClient(long id);
    Client addClient(Client client);
}
