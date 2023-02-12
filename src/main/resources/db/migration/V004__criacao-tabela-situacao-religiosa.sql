CREATE TABLE IF NOT EXISTS situacao_religiosa(
	id BIGINT AUTO_INCREMENT NOT NULL,
    status_matrimonial VARCHAR(50),
    status_civil VARCHAR(50),
    filhos_batizados VARCHAR(3),
    religiao VARCHAR(50),
    PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;