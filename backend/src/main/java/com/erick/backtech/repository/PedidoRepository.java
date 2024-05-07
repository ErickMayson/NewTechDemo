package com.erick.backtech.repository;

import com.erick.backtech.entities.Cliente;
import com.erick.backtech.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

   // @Query("SELECT Pedido FROM Pedido WHERE cliente = :cliente ")
   // List<Pedido> findByCliente(@Param("cliente") Long id);

    List<Pedido> findByCliente(Long id);
}
