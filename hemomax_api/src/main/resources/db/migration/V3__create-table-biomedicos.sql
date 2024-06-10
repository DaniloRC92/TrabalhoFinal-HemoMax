create table biomedicos(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    cpf varchar(14) not null unique,
    email varchar(100) not null unique,
    senha varchar(255) not null,
    instituicao bigint,

    constraint PK_biomedicos primary key(id)

);