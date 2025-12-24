CREATE TABLE autor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    biografia TEXT
);

-- 2. Cliente
CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    telefone VARCHAR(13)

);
-- Tabela LIVRO: id_autor é chave estrangeira para AUTOR(id)
CREATE TABLE livro (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    id_autor INT REFERENCES autor(id) ON DELETE SET NULL,
    resumo TEXT,
    disponivel BOOLEAN DEFAULT TRUE
);

-- Tabela EMPRESTIMO: id_cliente é chave estrangeira para CLIENTE(id)
CREATE TABLE emprestimo (
    id SERIAL PRIMARY KEY,
    id_cliente INT REFERENCES cliente(id) ON DELETE CASCADE,
    data_emprestimo DATE,
    data_devolucao DATE,
    devolvido BOOLEAN DEFAULT FALSE
);

-- Tabela LIVROS_EMPRESTADOS: chaves estrangeiras para EMPRESTIMO e LIVRO
CREATE TABLE livros_emprestados (
    id_emprestimo INT REFERENCES emprestimo(id) ON DELETE CASCADE,
    id_livro INT REFERENCES livro(id) ON DELETE CASCADE,
    PRIMARY KEY (id_emprestimo, id_livro)
);

CREATE OR REPLACE FUNCTION check_livros_emprestados()
RETURNS TRIGGER AS $$
DECLARE
    total INT;
BEGIN
    SELECT COUNT(*) INTO total
    FROM emprestimo e
    JOIN livros_emprestados le ON e.id = le.id_emprestimo
    WHERE e.id_cliente = (SELECT id_cliente FROM emprestimo WHERE id = NEW.id_emprestimo)
      AND e.devolvido = FALSE;

    IF total >= 3 THEN
        RAISE EXCEPTION 'Cliente já possui 3 livros emprestados e não devolvidos.';
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_check_livros_emprestados
BEFORE INSERT ON livros_emprestados
FOR EACH ROW
EXECUTE FUNCTION check_livros_emprestados();
