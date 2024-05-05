package com.erick.backtech.controllers;

import com.erick.backtech.common.PedidoRequest;
import com.erick.backtech.dto.ClienteDTO;
import com.erick.backtech.dto.PedidoDTO;
import com.erick.backtech.entities.Cliente;
import com.erick.backtech.entities.Pedido;
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

    @PostMapping("/addPedido")
    public Pedido addPedido (@RequestBody PedidoDTO dto) {
        return service.createPedido(dto);
    }

    @GetMapping
    public List<Pedido> getPedidos() { return service.getPedidos(); }

    @GetMapping(path="/cliente/id")
    public List<Pedido> getByClienteId(@RequestParam Long id) {

        return service.getPedidosByCliente(id);
    }

}
