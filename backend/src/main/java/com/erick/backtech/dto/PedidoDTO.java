package com.erick.backtech.dto;

import com.erick.backtech.entities.Cliente;
import com.erick.backtech.entities.Pedido;
import com.erick.backtech.entities.StatusPedido;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PedidoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Date dataPedido;
    private String descricao;
    private Double valor;
    private StatusPedido status;

    private Long cliente_id;

    // @JsonBackReference(value="cliente_id")
    // private Cliente cliente;

    public PedidoDTO(Long id, Date dataPedido, String descricao, Double valor, StatusPedido status) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.descricao = descricao;
        this.valor = valor;
        this.status = status;
    }

    public PedidoDTO(Pedido entity){
        id = entity.getId();
        dataPedido = entity.getDataPedido();
        descricao = entity.getDescricao();
        valor = entity.getValor();
        status = entity.getStatus();
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

   // public Cliente getCliente() {
   //     return cliente;
   // }
   // public void setCliente(Cliente cliente) {
   //     this.cliente = cliente;
   // }


    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    // Method to parse a string into a Date object
    public static Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Or handle the parse error according to your application's logic
        }
    }

    // Method to format a Date object into a string
    public static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

}