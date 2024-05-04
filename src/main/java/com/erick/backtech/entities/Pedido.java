package com.erick.backtech.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="tb_pedido")
public class Pedido {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dataPedido;
    private String descricao;
    private Double valor;
    private StatusPedido status;

    public Pedido(Long id, Date dataPedido, String descricao, Double valor, StatusPedido status) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.descricao = descricao;
        this.valor = valor;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }


}
