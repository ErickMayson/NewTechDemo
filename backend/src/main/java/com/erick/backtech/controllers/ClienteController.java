package com.erick.backtech.controllers;

import com.erick.backtech.dto.ClienteDTO;
import com.erick.backtech.entities.Cliente;
import com.erick.backtech.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public Cliente saveCliente(@RequestBody Cliente cliente) {return service.saveCliente((cliente));}

    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable Long id) { return service.getCliente(id);}

    @GetMapping
    public ResponseEntity<Object> getClientes() {
        List<Cliente> clientesList = service.getClientes();

        // Create a response object with key "Clientes"
        return new ResponseEntity<>(Map.of("clientes", clientesList), HttpStatus.OK);
    }




}
