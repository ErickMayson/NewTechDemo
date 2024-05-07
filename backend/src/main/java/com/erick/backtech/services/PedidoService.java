package com.erick.backtech.services;

import com.erick.backtech.common.PedidoRequest;
import com.erick.backtech.dto.ClienteDTO;
import com.erick.backtech.dto.PedidoDTO;
import com.erick.backtech.entities.Cliente;
import com.erick.backtech.entities.Pedido;
import com.erick.backtech.entities.StatusPedido;
import com.erick.backtech.repository.ClienteRepository;
import com.erick.backtech.repository.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Builder;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Pedido createPedido (PedidoDTO dto) {



        Pedido pedido = Pedido.builder()
                .dataPedido(dto.getDataPedido())
                .valor(dto.getValor())
                .descricao(dto.getDescricao())
                .status(dto.getStatus())
                .cliente(dto.getCliente())
                .build();

        return pedidoRepository.save(pedido);

    }

    public List<Pedido> getPedidos() { return pedidoRepository.findAll(); }

    public List<Pedido> getPedidosByCliente(Long id) {

        return pedidoRepository.findByCliente(id);
    }
    @Transactional
    public Pedido updatePedido(Long id, PedidoDTO updatedPedido) {
        Pedido existingPedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pedido com ID " + id + " nao encontrado"));
        existingPedido.setDataPedido(updatedPedido.getDataPedido());
        existingPedido.setDescricao(updatedPedido.getDescricao());
        existingPedido.setValor((updatedPedido.getValor()));
        existingPedido.setStatus((updatedPedido.getStatus()));
        return pedidoRepository.save(existingPedido);
    }

    @Transactional
    public Pedido setAceito(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pedido com ID " + id + " nao encontrado"));

        pedido.setStatus(StatusPedido.ACEITO);

        // Save the updated Pedido object

        return pedidoRepository.save(pedido);
    }

    @Transactional
    public Pedido setRecusado(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pedido com ID " + id + " não encontrado"));

        pedido.setStatus(StatusPedido.RECUSADO);

        // Save the updated Pedido object

        return pedidoRepository.save(pedido);
    }

}
