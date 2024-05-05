package com.erick.backtech.common;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoRequest<T> {

    private T cliente;

    public T getCliente() {
        return cliente;
    }

    public void setCliente(T cliente) {
        this.cliente = cliente;
    }
}
