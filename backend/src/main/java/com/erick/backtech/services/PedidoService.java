package com.erick.backtech.services;

import com.erick.backtech.dto.ClienteDTO;
import com.erick.backtech.dto.PedidoDTO;
import com.erick.backtech.entities.Cliente;
import com.erick.backtech.entities.Pedido;
import com.erick.backtech.repository.ClienteRepository;
import com.erick.backtech.repository.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
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


    @Transactional(readOnly = true)
    public List<PedidoDTO> findAll() {
        List<Pedido> list = pedidoRepository.findAll();
        return list.stream().map(x -> new PedidoDTO(x)).collect(Collectors.toList());
    }
    @Transactional
    public List<PedidoDTO> findByCliente(Long id) {

        List<Pedido> list = pedidoRepository.findByClienteId(id);
        return list.stream().map(x -> new PedidoDTO(x)).collect(Collectors.toList());

    }
    @Transactional
    public PedidoDTO insert(PedidoDTO dto) {

        Cliente cliente = clienteRepository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente not found"));



        // Pedido pedido = new Pedido(null, dto.getDataPedido(), dto.getDescricao(), dto.getValor(), dto.getStatus(), dto.getCliente());

        Pedido pedido = new Pedido(null, dto.getDataPedido(), dto.getDescricao(), dto.getValor(), dto.getStatus());


        pedido = pedidoRepository.save(pedido);
        return new PedidoDTO(pedido);


    }

    //public PedidoDTO setStatus(PedidoDTO dto) {
//
    //    Pedido pe
//
    //}


}
