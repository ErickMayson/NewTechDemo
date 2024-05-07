package com.erick.backtech.dto;

import com.erick.backtech.entities.Cliente;
import com.erick.backtech.entities.Pedido;
import com.erick.backtech.entities.StatusPedido;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Date dataPedido;
    private String descricao;
    private Double valor;
    private StatusPedido status;

    private Long cliente;


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