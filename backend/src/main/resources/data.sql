
CREATE TABLE tb_cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(70) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL

);

CREATE TABLE tb_pedido (
    id SERIAL PRIMARY KEY,
    cliente BIGINT NOT NULL,
    dataPedido DATE NOT NULL,
    descricao VARCHAR(255) NULL,
    valor DECIMAL(10,2) NOT NULL,
    StatusPedido VARCHAR(15) NOT NULL DEFAULT 'ACEITO',
    CONSTRAINT fk_cliente FOREIGN KEY (cliente) REFERENCES tb_cliente(id)
);



INSERT INTO tb_cliente (nome, email, telefone, endereco) VALUES ('Marcio Alcantara', 'MarcioAlcantara@gmail.com', '(19) 99314-2333', 'Rua Cornelio Procopio, 37');
INSERT INTO tb_cliente (nome, email, telefone, endereco) VALUES ('Ademar da Guia', 'AdemarGuia@gmail.com', '(15) 99324-2443', 'Av. Silva Conceição, 1435');
INSERT INTO tb_cliente (nome, email, telefone, endereco) VALUES ('Kevin Andante', 'KevinAndante@gmail.com', '(11) 91155-5313', 'Av. Assis Ribeiro, 3351');
INSERT INTO tb_cliente (nome, email, telefone, endereco) VALUES ('Pablo Marcal de Oliveira', 'PabloMarcal@Ironman.com', '(11) 92234-3666', 'Av. Paulista, 3331');

INSERT INTO tb_pedido (cliente, dataPedido, descricao, valor, StatusPedido) VALUES (1, '2024-03-13', null, 459.39, 'ACEITO');
INSERT INTO tb_pedido (cliente, dataPedido, descricao, valor, StatusPedido) VALUES (2, '2024-01-27', null, 739.39, 'ACEITO');
INSERT INTO tb_pedido (cliente, dataPedido, descricao, valor, StatusPedido) VALUES (3, '2024-02-25', 'Itens fora de estoque', 1045.20, 'RECUSADO');
INSERT INTO tb_pedido (cliente, dataPedido, descricao, valor, StatusPedido) VALUES (2, '2024-02-13', null, 3215.39, 'ACEITO');
INSERT INTO tb_pedido (cliente, dataPedido, descricao, valor, StatusPedido) VALUES (3, '2024-01-11', null, 331.39, 'ACEITO');
INSERT INTO tb_pedido (cliente, dataPedido, descricao, valor, StatusPedido) VALUES (1, '2024-03-15', 'Frete insuficiente.', 80.20, 'RECUSADO');
INSERT INTO tb_pedido (cliente, dataPedido, descricao, valor, StatusPedido) VALUES (3, '2024-03-18', null, 251.39, 'ACEITO');
INSERT INTO tb_pedido (cliente, dataPedido, descricao, valor, StatusPedido) VALUES (1, '2024-03-30', null, 143.39, 'ACEITO');
INSERT INTO tb_pedido (cliente, dataPedido, descricao, valor, StatusPedido) VALUES (2, '2024-03-22', 'Recusado por pedido do cliente.', 983.20, 'RECUSADO');
