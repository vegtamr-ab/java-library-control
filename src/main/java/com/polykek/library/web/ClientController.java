package com.polykek.library.web;

import com.polykek.library.entity.Client;
import com.polykek.library.exception.ClientNotFoundException;
import com.polykek.library.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private ClientService clientService;

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> list = clientService.listClients();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<>(clientService.findClient(id), HttpStatus.OK);
        } catch (ClientNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found!");
        }
    }
}
