alter table biomedicos
ADD constraint FK_biomedicos_instituicoesId
foreign key (instituicao) references instituicoes(id);