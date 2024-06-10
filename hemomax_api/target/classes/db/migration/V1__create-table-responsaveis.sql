create table responsaveis(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    cnpj varchar(14) not null unique,
    telefone varchar(20) not null,
    email varchar(100) not null unique,
    senha varchar(255) not null,

    constraint PK_responsaveis primary key(id)

);