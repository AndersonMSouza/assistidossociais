CREATE TABLE IF NOT EXISTS situacao_economica(
	id BIGINT AUTO_INCREMENT NOT NULL,
    situacao_economica VARCHAR(255) NOT NULL,
    casa VARCHAR(25) NOT NULL,
    renda_familiar DECIMAL(10,2) NOT NULL,
    explicacao_renda VARCHAR(225),
    escolaridade VARCHAR(50) NOT NULL,
    pessoa_id BIGINT NOT NULL,
    FOREIGN KEY(pessoa_id) REFERENCES pessoa(id),
    PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;