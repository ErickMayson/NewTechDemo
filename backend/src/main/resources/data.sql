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
    cliente_id INT NOT NULL,
    dataPedido DATE NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    StatusPedido status,
    CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES tb_cliente(id)
);



INSERT INTO tb_cliente (nome, email, telefone, endereco) VALUES ('Marcio Alcantara', 'MarcioAlcantara@gmail.com', '(19) 99314-2333', 'Rua Cornelio Procopio, 37');
INSERT INTO tb_cliente (nome, email, telefone, endereco) VALUES ('Ademar da Guia', 'AdemarGuia@gmail.com', '(15) 99324-2443', 'Av. Silva Conceição, 1435');
INSERT INTO tb_cliente (nome, email, telefone, endereco) VALUES ('Kevin Andante', 'KevinAndante@gmail.com', '(11) 91155-5313', 'Av. Assis Ribeiro, 3351');

INSERT INTO tb_pedido (cliente_id, dataPedido, descricao, valor, StatusPedido) VALUES (1, '13/03/2024', '', 459.39, 'ACEITO');
INSERT INTO tb_pedido (cliente_id, dataPedido, descricao, valor, StatusPedido) VALUES (2, '27/01/2024', '', 739.39, 'ACEITO');
INSERT INTO tb_pedido (cliente_id, dataPedido, descricao, valor, StatusPedido) VALUES (3, '25/02/2024', 'Itens fora de estoque', 1045.20, 'RECUSADO');
INSERT INTO tb_pedido (cliente_id, dataPedido, descricao, valor, StatusPedido) VALUES (2, '13/02/2024', '', 3215.39, 'ACEITO');
INSERT INTO tb_pedido (cliente_id, dataPedido, descricao, valor, StatusPedido) VALUES (3, '11/01/2024', '', 331.39, 'ACEITO');
INSERT INTO tb_pedido (cliente_id, dataPedido, descricao, valor, StatusPedido) VALUES (1, '15/03/2024', 'Frete insuficiente.', 80.20, 'RECUSADO');
INSERT INTO tb_pedido (cliente_id, dataPedido, descricao, valor, StatusPedido) VALUES (3, '18/03/2024', '', 251.39, 'ACEITO');
INSERT INTO tb_pedido (cliente_id, dataPedido, descricao, valor, StatusPedido) VALUES (1, '30/03/2024', '', 143.39, 'ACEITO');
INSERT INTO tb_pedido (cliente_id, dataPedido, descricao, valor, StatusPedido) VALUES (2, '22/03/2024', 'Recusado por pedido do cliente.', 983.20, 'RECUSADO');
