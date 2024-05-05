package com.erick.backtech.services;

import com.erick.backtech.dto.ClienteDTO;
import com.erick.backtech.entities.Cliente;
import com.erick.backtech.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional
    public List<ClienteDTO> findAll() {
        List<Cliente> list = repository.findAll();
        return list.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());
    }
    @Transactional
    public ClienteDTO insert(ClienteDTO dto) {

        Cliente cliente = new Cliente(null, dto.getNome(), dto.getEmail(), dto.getTelefone(), dto.getEndereco());

        cliente = repository.save(cliente);
        return new ClienteDTO(cliente);


    }


}
