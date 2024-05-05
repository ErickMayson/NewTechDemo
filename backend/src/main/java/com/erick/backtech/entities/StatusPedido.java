package com.erick.backtech.entities;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusPedido {



    ACEITO,
    RECUSADO;

    @JsonValue
    public String toString() {
        return name().toUpperCase();
    }

}
