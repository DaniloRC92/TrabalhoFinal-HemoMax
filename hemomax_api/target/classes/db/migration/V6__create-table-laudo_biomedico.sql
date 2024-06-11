CREATE TABLE laudo_usuario (

    usuarios_id BIGINT,
    laudos_id BIGINT,

    PRIMARY KEY (usuarios_id, laudos_id),

    CONSTRAINT FK_laudo_usuario_usersId
    FOREIGN KEY (usuarios_id) REFERENCES usuarios(id),

    CONSTRAINT FK_laudo_usuario_laudosId
    FOREIGN KEY (laudos_id) REFERENCES laudos(id)
);