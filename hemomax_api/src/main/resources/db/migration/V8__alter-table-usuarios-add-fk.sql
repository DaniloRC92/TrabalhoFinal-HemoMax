ALTER TABLE usuarios
ADD CONSTRAINT FK_usuarios_normalidadesId
FOREIGN KEY (normalidade) REFERENCES normalidades(id),
ADD CONSTRAINT FK_usuarios_enderecosId
FOREIGN KEY (endereco) REFERENCES enderecos(id),
ADD CONSTRAINT FK_usuarios_responsaveisId
FOREIGN KEY (responsavel) REFERENCES responsaveis(id);
