create table assinaturas(

    id bigint not null auto_increment,
    plano varchar(20) not null,
    dataTransacao varchar(10) not null,
    instituicao bigint,

    constraint PK_assinaturas primary key(id)

);