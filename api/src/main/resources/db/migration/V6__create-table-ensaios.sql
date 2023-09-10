CREATE TABLE ensaios(
    id BIGINT NOT NULL AUTO_INCREMENT,
    membro_id BIGINT NOT NULL,
    cliente_id BIGINT NOT NULL,
    data DATETIME NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT fk_ensaios_membro_id FOREIGN KEY (membro_id) REFERENCES membros(id),
    CONSTRAINT fk_ensaios_cliente_id FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);