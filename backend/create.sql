create table tb_cliente (id bigserial not null, email varchar(255), endereco varchar(255), nome varchar(255), telefone varchar(255), primary key (id));
create table tb_pedido (status smallint check (status between 0 and 1), valor float(53), cliente bigint, data_pedido timestamp(6), id bigserial not null, descricao varchar(255), primary key (id));
create table tb_cliente (id bigserial not null, email varchar(255), endereco varchar(255), nome varchar(255), telefone varchar(255), primary key (id));
create table tb_pedido (status smallint check (status between 0 and 1), valor float(53), cliente bigint, datapedido timestamp(6), id bigserial not null, descricao varchar(255), primary key (id));
create table tb_cliente (id bigserial not null, email varchar(255), endereco varchar(255), nome varchar(255), telefone varchar(255), primary key (id));
create table tb_pedido (statuspedido smallint check (statuspedido between 0 and 1), valor float(53), cliente bigint, datapedido timestamp(6), id bigserial not null, descricao varchar(255), primary key (id));
create table tb_cliente (id bigserial not null, email varchar(255), endereco varchar(255), nome varchar(255), telefone varchar(255), primary key (id));
create table tb_pedido (valor float(53), cliente bigint, datapedido timestamp(6), id bigserial not null, descricao varchar(255), statuspedido varchar(255) check (statuspedido in ('ACEITO','RECUSADO')), primary key (id));
