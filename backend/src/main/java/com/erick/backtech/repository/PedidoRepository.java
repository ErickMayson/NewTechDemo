package com.erick.backtech.repository;

import com.erick.backtech.entities.Cliente;
import com.erick.backtech.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("from Pedido p where p.cliente_id = :id")
    List<Pedido> findByClienteId(Long id);
}
