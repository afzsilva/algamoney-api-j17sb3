CREATE TABLE pessoa(
 codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
 nome VARCHAR(50) NOT NULL,
 ativo BOOLEAN NOT NULL,
 logradouro VARCHAR(50),
 numero VARCHAR(10),
 complemento VARCHAR(100),
 bairro VARCHAR(50),
 cep VARCHAR(9),
 cidade VARCHAR(50),
 estado VARCHAR(2)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)
VALUES ('João da Silva', true, 'Rua das Flores', 123, 'Apto 101', 'Centro', '12345-678', 'São Paulo', 'SP');
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)
VALUES ('Maria da Silva', true, 'Rua dos Jasmins', 456, 'Casa 2', 'Jardim Paulista', '01234-567', 'São Paulo', 'SP');
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)
VALUES ('Ana Luiza Santos', false, 'Avenida Brasil', 1234, 'Sala 101', 'Jardim América', '04567-890', 'São Paulo', 'SP');
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)
VALUES ('Lucas Ferreira', true, 'Rua dos Girassóis', 789, '', 'Centro', '76543-210', 'Belo Horizonte', 'MG');
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)
VALUES ('André Oliveira', true, 'Rua das Acácias', 1010, '', 'Jardim Europa', '02345-678', 'São Paulo', 'SP');
