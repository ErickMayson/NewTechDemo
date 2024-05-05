
CREATE TABLE tb_cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(70) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL

);

CREATE TYPE status AS ENUM('ACEITO', 'RECUSADO');

CREATE TABLE tb_pedido (
    id SERIAL PRIMARY KEY,
    cliente_id BIGINT NOT NULL,
    dataPedido DATE NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    StatusPedido status,
    CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES tb_cliente(id)
);



INSERT INTO tb_cliente (nome, email, telefone, endereco) VALUES ('Marcio Alcantara', 'MarcioAlcantara@gmail.com', '(19) 99314-2333', 'Rua Cornelio Procopio, 37');
INSERT INTO tb_cliente (nome, email, telefone, endereco) VALUES ('Ademar da Guia', 'AdemarGuia@gmail.com', '(15) 99324-2443', 'Av. Silva Conceição, 1435');
INSERT INTO tb_cliente (nome, email, telefone, endereco) VALUES ('Kevin Andante', 'KevinAndante@gmail.com', '(11) 91155-5313', 'Av. Assis Ribeiro, 3351');

INSERT INTO tb_pedido (cliente_id, dataPedido, descricao, valor, StatusPedido) VALUES (1, '2024-03-13', 'Descrição do pedido 1', 459.39, 'ACEITO');
INSERT INTO tb_pedido (cliente_id, dataPedido, descricao, valor, StatusPedido) VALUES (2, '2024-01-27', 'Descrição do pedido 2', 739.39, 'ACEITO');
INSERT INTO tb_pedido (cliente_id, dataPedido, descricao, valor, StatusPedido) VALUES (3, '2024-02-25', 'Itens fora de estoque', 1045.20, 'RECUSADO');
INSERT INTO tb_pedido (cliente_id, dataPedido, descricao, valor, StatusPedido) VALUES (2, '2024-02-13', 'Descrição do pedido 4', 3215.39, 'ACEITO');
INSERT INTO tb_pedido (cliente_id, dataPedido, descricao, valor, StatusPedido) VALUES (3, '2024-01-11', 'Descrição do pedido 5', 331.39, 'ACEITO');
INSERT INTO tb_pedido (cliente_id, dataPedido, descricao, valor, StatusPedido) VALUES (1, '2024-03-15', 'Frete insuficiente.', 80.20, 'RECUSADO');
INSERT INTO tb_pedido (cliente_id, dataPedido, descricao, valor, StatusPedido) VALUES (3, '2024-03-18', 'Descrição do pedido 7', 251.39, 'ACEITO');
INSERT INTO tb_pedido (cliente_id, dataPedido, descricao, valor, StatusPedido) VALUES (1, '2024-03-30', 'Descrição do pedido 8', 143.39, 'ACEITO');
INSERT INTO tb_pedido (cliente_id, dataPedido, descricao, valor, StatusPedido) VALUES (2, '2024-03-22', 'Recusado por pedido do cliente.', 983.20, 'RECUSADO');
