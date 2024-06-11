alter table assinaturas
ADD constraint FK_assinaturas_instituicoesId
foreign key (instituicao) references instituicoes(id);