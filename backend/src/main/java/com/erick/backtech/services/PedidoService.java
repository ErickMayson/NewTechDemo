package com.erick.backtech.services;

import com.erick.backtech.common.PedidoRequest;
import com.erick.backtech.dto.ClienteDTO;
import com.erick.backtech.dto.PedidoDTO;
import com.erick.backtech.entities.Cliente;
import com.erick.backtech.entities.Pedido;
import com.erick.backtech.repository.ClienteRepository;
import com.erick.backtech.repository.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Builder;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public Pedido createPedido (PedidoDTO dto) {


        Pedido pedido = Pedido.builder()
                .dataPedido(dto.getDataPedido())
                .valor(dto.getValor())
                .descricao(dto.getDescricao())
                .status(dto.getStatus())
                .cliente_id(clienteRepository.findById(dto.getCliente_id()).orElse(null))
                .build();

        return pedidoRepository.save(pedido);

    }

    public List<Pedido> getPedidos() { return pedidoRepository.findAll(); }

}
