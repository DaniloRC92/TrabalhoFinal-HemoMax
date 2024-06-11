create table usuarios(

    id bigint not null auto_increment,
    login varchar(100) not null unique,
    senha varchar(100) not null,
    role TEXT not null,
    doc varchar(20) not null unique,
    telefone varchar(20) not null,
    normalidade bigint,
    endereco bigint,

    constraint PK_usuarios primary key(id)

);