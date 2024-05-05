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

    @Transactional
    public ClienteDTO insert(ClienteDTO dto) {

        Cliente cliente = new Cliente(null, dto.getNome(), dto.getEmail(), dto.getTelefone(), dto.getEndereco());

        cliente = repository.save(cliente);
        return new ClienteDTO(cliente);


    }

    @Transactional
    public List<ClienteDTO> findAll() {
        List<Cliente> list = repository.findAll();
        return list.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());
    }
    @Transactional
    public ClienteDTO getCliente(Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // Convert Cliente entity to ClienteDTO
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNome(cliente.getNome());
        // Set other properties as needed

        return clienteDTO;
    }
}
