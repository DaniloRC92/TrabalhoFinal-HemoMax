alter table assinaturas
ADD constraint FK_assinaturas_usuariosId
foreign key (usuarios) references usuarios(id);