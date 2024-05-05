package com.erick.backtech.services;

import com.erick.backtech.dto.ClienteDTO;
import com.erick.backtech.entities.Cliente;
import com.erick.backtech.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente saveCliente(Cliente cliente) { return repository.save(cliente) ;}

    public Cliente getCliente(Long id) {
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.orElseThrow(() -> new NoSuchElementException("Cliente com ID" + id + "Não encontrado"));
    }

    public List<Cliente> getClientes() { return repository.findAll();}

    public Cliente updateCliente(Long id, Cliente updatedCliente) {
        Cliente existingCliente = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente com ID" + id + "Não encontrado"));
        existingCliente.setNome(updatedCliente.getNome());
        existingCliente.setEmail(updatedCliente.getEmail());
        existingCliente.setTelefone((updatedCliente.getTelefone()));
        existingCliente.setEndereco((updatedCliente.getEndereco()));
        return repository.save(existingCliente);
    }



}
