package com.erick.backtech.services;

import com.erick.backtech.dto.PedidoDTO;
import com.erick.backtech.entities.Pedido;
import com.erick.backtech.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional(readOnly = true)
    public List<PedidoDTO> FindAllByClientId() {
        List<Pedido> list = pedidoRepository.findById();
        return list.stream().map(x -> new PedidoDTO(x)).collect(Collectors.toList());
    }




}
