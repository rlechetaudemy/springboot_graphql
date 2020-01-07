create table cliente (
    id    bigint auto_increment primary key,
    email varchar(255) null,
    nome  varchar(255) null
);

create table produto(
    id    bigint auto_increment primary key,
    nome  varchar(255) null,
    valor double       not null
);

create table compra
(
    id         bigint auto_increment primary key,
    data       datetime     null,
    quantidade int          null,
    status     varchar(255) null,
    cliente_id bigint       null,
    produto_id bigint       null,
    constraint FK_COMPRA_PRODUTO foreign key (produto_id) references produto (id),
    constraint FK_COMPRA_CLIENTE foreign key (cliente_id) references cliente (id)
);

