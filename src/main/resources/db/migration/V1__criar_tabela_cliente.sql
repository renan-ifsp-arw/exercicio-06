CREATE TABLE cliente (
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
     nome VARCHAR(50) NOT NULL CHECK(LENGTH(nome) BETWEEN 3 AND 50),
     email VARCHAR(255),  -- Assuming standard length for email
     telefone VARCHAR(255) NOT NULL  -- Assuming a standard VARCHAR length for phone number
);

INSERT INTO cliente (nome, email, telefone) VALUES
    ('João Silva', 'joao.silva@email.com', '+1234567890'),
    ('Maria Oliveira', 'maria.oliveira@email.com', '+0987654321'),
    ('Carlos Pereira', 'carlos.pereira@email.com', '+1122334455');

