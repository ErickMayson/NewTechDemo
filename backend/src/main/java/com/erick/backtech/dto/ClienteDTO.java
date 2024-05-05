package com.erick.backtech.dto;

import com.erick.backtech.entities.Cliente;
import com.erick.backtech.entities.Pedido;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTO implements Serializable{

        private static final long serialVersionUID = 1L;
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String email;
        private String telefone;
        private String endereco;
        // @JsonIgnore
        private List<PedidoDTO> pedidos = new ArrayList<>();

        public ClienteDTO (){

        }

        public ClienteDTO(Long id, String nome, String email, String telefone, String endereco){
            super();
            this.id = id;
            this.nome = nome;
            this.email = email;
            this.telefone = telefone;
            this.endereco = endereco;
        }

        public ClienteDTO(Cliente entity) {
            id = entity.getId();
            nome = entity.getNome();
            email = entity.getEmail();
            telefone = entity.getTelefone();
            endereco = entity.getEndereco();
            // pedidos = entity.getPedidos().stream().
            //         map(x -> new PedidoDTO(x).collect(Collectors.toList())); Acho que não vou usar isso, mas não sei
        }

        public Long getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public String getEmail() {
            return email;
        }

        public String getTelefone() {
            return telefone;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public List<PedidoDTO> getPedidos() {return pedidos;}


}
