package com.erick.backtech.controllers;

import com.erick.backtech.dto.ClienteDTO;
import com.erick.backtech.dto.PedidoDTO;
import com.erick.backtech.entities.Cliente;
import com.erick.backtech.services.ClienteService;
import com.erick.backtech.services.PedidoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService service;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> findAll() {
        List<PedidoDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="/pedidos/{clienteId}")
    public ResponseEntity<List<PedidoDTO>> findByCliente( @PathVariable Long clienteId) {

        List<PedidoDTO> list = service.findByCliente(clienteId);
        return ResponseEntity.ok(list);


    }


    @PostMapping
    public ResponseEntity<PedidoDTO> insert(@RequestBody PedidoDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    //public ResponseEntity<PedidoDTO>




}
