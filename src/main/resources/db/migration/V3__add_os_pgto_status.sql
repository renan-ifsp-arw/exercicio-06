CREATE TABLE IF NOT EXISTS forma_pagamento (
    codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255)
);

INSERT INTO forma_pagamento (nome) VALUES ('CRÉDITO'),('DÉBITO'),('PIX'),('DINHEIRO');

CREATE TABLE IF NOT EXISTS ordem_servico (
     codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
     descricao VARCHAR(255),  -- adjust size based on requirement
     data_emissao DATE,
     data_finalizacao DATE,
     valor DECIMAL(6,2),
     observacao VARCHAR(255),  -- adjust size based on requirement
     cliente_id BIGINT,
     forma_pagamento_codigo BIGINT,
     status VARCHAR(50),      -- for storing the Status enum as string
     FOREIGN KEY (cliente_id)
         REFERENCES cliente(id),
     FOREIGN KEY (forma_pagamento_codigo)
         REFERENCES forma_pagamento(codigo)
);


INSERT INTO ordem_servico (descricao, data_emissao, data_finalizacao, valor, observacao, cliente_id, forma_pagamento_codigo, status) VALUES
     ('Servico for Cliente 1', '2023-08-24', '2023-08-30', 150.00, 'Observation 1', 1, 1, 'EM_APROVACAO'),
     ('Servico for Cliente 2', '2023-08-22', '2023-08-29', 200.50, 'Observation 2', 2, 2, 'APROVADA'),
     ('Servico for Cliente 3', '2023-08-20', '2023-08-28', 300.75, 'Observation 3', 3, 3, 'EM_ANDAMENTO'),
     ('Servico for Cliente 1', '2023-08-19', '2023-08-27', 100.25, 'Observation 4', 1, 1, 'FINALIZADA'),
     ('Servico for Cliente 2', '2023-08-18', '2023-08-26', 50.00, 'Observation 5', 2, 2, 'EM_APROVACAO');


