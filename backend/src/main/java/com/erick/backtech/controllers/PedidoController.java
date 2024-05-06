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

@RestController
@RequestMapping(value="/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService service;

    @PostMapping("/addPedido")
    public Pedido addPedido (@RequestBody PedidoDTO dto) {
        return service.createPedido(dto);
    }

    @GetMapping
    public ResponseEntity<Object>  getPedidos() {

        List<Pedido> pedidosList = service.getPedidos();

        // Create a response object with key "Clientes"
        return new ResponseEntity<>(Map.of("pedidos", pedidosList), HttpStatus.OK);

    }

    @GetMapping(path="/cliente/id")
    public List<Pedido> getByClienteId(@RequestParam Long id) {

        return service.getPedidosByCliente(id);
    }
    @PutMapping(path="/{id}/aceito")
    public Pedido setAceito(@PathVariable Long id) {
        return service.setAceito(id);

    }
    @PutMapping(path="/{id}/recusado")
    public Pedido setRecusado(@PathVariable Long id) {
        return service.setRecusado(id);

    }


}
