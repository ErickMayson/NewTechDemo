package com.erick.backtech.dto;

import com.erick.backtech.entities.Pedido;
import com.erick.backtech.entities.StatusPedido;
import jakarta.persistence.*;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PedidoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataPedido;
    private String descricao;
    private Double valor;
    private StatusPedido status;

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