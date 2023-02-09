CREATE DATABASE IF NOT EXISTS assistidossociais;

CREATE TABLE pessoa (
	id BIGINT NOT NULL AUTO_INCREMENT,
    nome_completo VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    complemento VARCHAR(50) NOT NULL,    
    bairro VARCHAR(50) NOT NULL,
	telefone VARCHAR(50) NOT NULL,
	ponto_referencia VARCHAR(50) NOT NULL,
	cpf VARCHAR(15) NOT NULL,
	rg VARCHAR(15) NOT NULL,
	estado_civil VARCHAR(20) NOT NULL,
	data_nascimento VARCHAR(15) NOT NULL,
	profissao VARCHAR(50) NOT NULL,
	nome_conjuge VARCHAR(255) NOT NULL,
	data_nascimento_conjuge VARCHAR(15) NOT NULL,
	profissao_conjuge VARCHAR(50) NOT NULL,
	telefone_conjuge VARCHAR(20) NOT NULL,
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
