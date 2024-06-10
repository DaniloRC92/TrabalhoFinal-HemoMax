CREATE TABLE laudo_biomedico (

    biomedicos_id BIGINT,
    laudos_id BIGINT,

    PRIMARY KEY (biomedicos_id, laudos_id),

    CONSTRAINT FK_laudo_biomedico_biomedicosId
    FOREIGN KEY (biomedicos_id) REFERENCES biomedicos(id),

    CONSTRAINT FK_laudo_biomedico_laudosId
    FOREIGN KEY (laudos_id) REFERENCES laudos(id)
);