create table instituicoes(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    normalidade bigint,
    endereco bigint,
    responsavel bigint,

    constraint PK_instituicoes primary key(id)

);