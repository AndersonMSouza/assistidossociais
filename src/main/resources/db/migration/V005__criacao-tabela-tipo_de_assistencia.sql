CREATE TABLE IF NOT EXISTS tipo_de_assitencia(
	id BIGINT NOT NULL AUTO_INCREMENT,
    fornecer_alimentos VARCHAR(3) NOT NULL,
    necessita_consulta_medica VARCHAR(3) NOT NULL,
    aviamento_receitas_medicamentos VARCHAR(3) NOT NULL,
    verificar_emprego VARCHAR(3) NOT NULL,
    necessita_roupas VARCHAR(3) NOT NULL,
    necessita_assistencia_juridica VARCHAR(3) NOT NULL,
    encaminhamento_aposentadoria VARCHAR(3) NOT NULL,
    encaminhamento_sebem VARCHAR(3) NOT NULL,
    outros VARCHAR(3),
    quais VARCHAR(255),
    sindicancia DATE NOT NULL,
    admissao DATE NOT NULL,
    promocao DATE,
    recusa DATE,
    sindicancia_realizada_por VARCHAR(255),
    PRIMARY KEY(ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;