ALTER TABLE instituicoes
ADD CONSTRAINT FK_instituicoes_normalidadesId
FOREIGN KEY (normalidade) REFERENCES normalidades(id),
ADD CONSTRAINT FK_instituicoes_enderecosId
FOREIGN KEY (endereco) REFERENCES enderecos(id),
ADD CONSTRAINT FK_instituicoes_responsaveisId
FOREIGN KEY (responsavel) REFERENCES responsaveis(id);
