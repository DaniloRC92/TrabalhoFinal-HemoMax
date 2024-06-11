create table users(

    id bigint not null auto_increment,
    login varchar(100) not null unique,
    senha varchar(100) not null,
    role varchar(20) not null,
    doc varchar(11) not null unique,
    telefone varchar(20) not null,
    normalidade bigint,
    endereco bigint,
    responsavel bigint,

    constraint PK_usuarios primary key(id)

);