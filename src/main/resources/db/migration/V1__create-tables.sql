CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensagem VARCHAR(200) NOT NULL,
    data DATETIME NOT NULL,
    nome_curso VARCHAR(100) NOT NULL,
    categoria VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);