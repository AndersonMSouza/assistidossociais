CREATE TABLE IF NOT EXISTS dependente(
	id BIGINT AUTO_INCREMENT NOT NULL,
    nome_completo VARCHAR(255),
    data_nascimento VARCHAR(15),
    relacao VARCHAR(50),
    ocupacao VARCHAR(50),
    pessoa_id BIGINT NOT NULL,
    FOREIGN KEY(pessoa_id) REFERENCES pessoa(id),
    PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;