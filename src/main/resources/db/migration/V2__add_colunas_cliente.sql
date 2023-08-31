ALTER TABLE cliente ADD COLUMN cpf VARCHAR(11) NOT NULL;
ALTER TABLE cliente ADD COLUMN logradouro VARCHAR(50);
ALTER TABLE cliente ADD COLUMN numero VARCHAR(10);
ALTER TABLE cliente ADD COLUMN complemento VARCHAR(50);
ALTER TABLE cliente ADD COLUMN bairro VARCHAR(30);
ALTER TABLE cliente ADD COLUMN cidade VARCHAR(30);
ALTER TABLE cliente ADD COLUMN estado VARCHAR(2);
ALTER TABLE cliente ADD COLUMN cep VARCHAR(10);

INSERT INTO cliente
(cpf, email, bairro, cep, cidade, complemento, estado, logradouro, numero, nome, telefone)
VALUES
    ('12345678901', 'john@example.com', 'Centro', '1234567', 'Rio de Janeiro', 'Apt 205', 'RJ', 'Avenida Rio Branco', '100', 'John Doe', '1234-5678');

INSERT INTO cliente
(cpf, email, bairro, cep, cidade, complemento, estado, logradouro, numero, nome, telefone)
VALUES
    ('23456789012', 'alice@example.com', 'Botafogo', '7654321', 'Rio de Janeiro', '2nd Floor', 'RJ', 'Rua Sao Clemente', '50', 'Alice Smith', '5678-1234');

INSERT INTO cliente
(cpf, email, bairro, cep, cidade, complemento, estado, logradouro, numero, nome, telefone)
VALUES
    ('34567890123', 'bob@example.com', 'Copacabana', '2345678', 'Rio de Janeiro', 'Penthouse', 'RJ', 'Avenida Atlantica', '3000', 'Bob Johnson', '8765-4321');
