create table enderecos(

    id bigint not null auto_increment,
    estado varchar(100) not null,
    cidade varchar(100) not null,
    bairro varchar(100) not null,
    rua varchar(100) not null,
    numero integer not null,
    complemento varchar(20) not null,
    cep varchar(9) not null,

    constraint PK_enderecos primary key(id)

);