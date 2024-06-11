alter table assinaturas
ADD constraint FK_assinaturas_usuariosId
foreign key (usuario) references usuarios(id);