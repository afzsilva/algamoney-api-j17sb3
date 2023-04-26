CREATE TABLE lancamento (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(50) NOT NULL,
  data_vencimento DATE NOT NULL,
  data_pagamento DATE,
  valor DECIMAL(10,2) NOT NULL,
  tipo_lancamento VARCHAR(20) NOT NULL,
  observacao VARCHAR(50) NOT NULL,
  codigo_categoria BIGINT(20) NOT NULL,
  codigo_pessoa BIGINT(20) NOT NULL,
  FOREIGN KEY(codigo_categoria) REFERENCES categoria(codigo),
  FOREIGN KEY(codigo_pessoa) REFERENCES pessoa(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, tipo_lancamento, observacao, codigo_categoria, codigo_pessoa)
VALUES ('Alguma descrição','2023-05-01', '2023-05-02', 1000.50, 'DESPESA', 'Pagamento de fornecedores', 1, 2);




