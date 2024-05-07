package com.erick.backtech.controllers;

import com.erick.backtech.common.PedidoRequest;
import com.erick.backtech.dto.ClienteDTO;
import com.erick.backtech.dto.PedidoDTO;
import com.erick.backtech.entities.Cliente;
import com.erick.backtech.entities.Pedido;
import com.erick.backtech.entities.StatusPedido;
import com.erick.backtech.services.ClienteService;
import com.erick.backtech.services.PedidoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService service;

    @PostMapping("/addPedido")
    public ResponseEntity<Object> addPedido(@RequestBody PedidoDTO dto) {
        try {
            Pedido pedido = service.createPedido(dto);
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getPedidos() {
        try {
            List<Pedido> pedidosList = service.getPedidos();
            // Create a response object with key "pedidos"
            return new ResponseEntity<>(Map.of("pedidos", pedidosList), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/cliente/id")
    public ResponseEntity<Object> getByClienteId(@RequestParam Long id) {
        try {
            List<Pedido> pedidosList = service.getPedidosByCliente(id);
            // Create a response object with key "pedidos"
            return new ResponseEntity<>(Map.of("pedidos", pedidosList), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/editPedido/{id}")
    public ResponseEntity<Object> updatePedido(@PathVariable Long id, @RequestBody PedidoDTO dto) {
        try {
            Pedido pedido = service.updatePedido(id, dto);
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/{id}/aceito")
    public ResponseEntity<Object> setAceito(@PathVariable Long id) {
        try {
            Pedido pedido = service.setAceito(id);
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/{id}/recusado")
    public ResponseEntity<Object> setRecusado(@PathVariable Long id) {
        try {
            Pedido pedido = service.setRecusado(id);
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
