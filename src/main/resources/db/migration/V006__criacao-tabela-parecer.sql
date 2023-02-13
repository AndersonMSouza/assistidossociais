CREATE TABLE IF NOT EXISTS parecer(
	id BIGINT NOT NULL AUTO_INCREMENT,
    descrever VARCHAR(255) NOT NULL,
    primeira_visita DATE NOT NULL,
    relato_primeira_visita VARCHAR(255) NOT NULL,
    ultima_visita DATE NOT NULL,
    relato_ultima_visita VARCHAR(255) NOT NULL,
    pessoa_id BIGINT NOT NULL,
    FOREIGN KEY(pessoa_id) REFERENCES pessoa(id),
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;