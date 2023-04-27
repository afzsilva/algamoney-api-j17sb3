CREATE TABLE lancamento (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(50) NOT NULL,
  data_vencimento DATE NOT NULL,
  data_pagamento DATE,
  valor DECIMAL(10,2) NOT NULL,
  tipo_lancamento VARCHAR(20) NOT NULL,
  observacao VARCHAR(50),
  codigo_categoria BIGINT(20) NOT NULL,
  codigo_pessoa BIGINT(20) NOT NULL,
  FOREIGN KEY(codigo_categoria) REFERENCES categoria(codigo),
  FOREIGN KEY(codigo_pessoa) REFERENCES pessoa(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, tipo_lancamento, observacao, codigo_categoria, codigo_pessoa)
VALUES ('Alguma descrição','2023-05-01', '2023-05-02', 1000.50, 'DESPESA', 'Pagamento de fornecedores', 1, 2);

 INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor,tipo_lancamento,  observacao, codigo_categoria, codigo_pessoa)
 values ('Salário mensal', '2017-06-10', null, 6500.00, 'RECEITA', 'Distribuição de lucros',1, 1);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, tipo_lancamento, observacao, codigo_categoria, codigo_pessoa)
values ('Bahamas', '2017-02-10', '2017-02-10', 100.32,'DESPESA',  null, 2, 2);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, tipo_lancamento, observacao, codigo_categoria, codigo_pessoa)
values ('Top Club', '2017-06-10', null, 120, 'RECEITA', null, 3, 3);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, tipo_lancamento, observacao, codigo_categoria, codigo_pessoa)
values ('CEMIG', '2017-02-10', '2017-02-10', 110.44, 'RECEITA', 'Geração', 3, 4);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, tipo_lancamento, observacao, codigo_categoria, codigo_pessoa)
values ('DMAE', '2017-06-10', null, 200.30, 'DESPESA',null,  3, 5);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, tipo_lancamento, observacao, codigo_categoria, codigo_pessoa)
values ('Extra', '2017-03-10', '2017-03-10', 1010.32, 'RECEITA', null,  4, 6);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, tipo_lancamento, observacao, codigo_categoria, codigo_pessoa)
values ('Bahamas', '2017-06-10', null, 500, 'RECEITA', null,  1, 7);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, tipo_lancamento, observacao, codigo_categoria, codigo_pessoa)
values ('Top Club', '2017-03-10', '2017-03-10', 400.32, 'DESPESA', null, 4, 8);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, tipo_lancamento, observacao, codigo_categoria, codigo_pessoa)
values ('Despachante', '2017-06-10', null, 123.64, 'DESPESA', 'Multas', 3, 9);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, tipo_lancamento, observacao, codigo_categoria, codigo_pessoa)
values ('Pneus', '2017-04-10', '2017-04-10', 665.33, 'RECEITA',  null, 5, 10);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, tipo_lancamento, observacao, codigo_categoria, codigo_pessoa)
values ('Café', '2017-06-10', null, 8.32, 'DESPESA', null, 1, 5);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, tipo_lancamento, observacao, codigo_categoria, codigo_pessoa)
values ('Eletrônicos', '2017-04-10', '2017-04-10', 2100.32, 'DESPESA', null, 5, 4);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, tipo_lancamento, observacao, codigo_categoria, codigo_pessoa)
values ('Instrumentos', '2017-06-10', null, 1040.32, 'DESPESA', null, 4, 3);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, tipo_lancamento, observacao, codigo_categoria, codigo_pessoa)
values ('Café', '2017-04-10', '2017-04-10', 4.32, 'DESPESA', null, 4, 2);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, tipo_lancamento, observacao, codigo_categoria, codigo_pessoa)
values ('Lanche', '2017-06-10', null, 10.20, 'DESPESA', null, 4, 1);




