INSERT INTO autor (nome, biografia) VALUES
('Suzanne Collins', 'Autora da trilogia Jogos Vorazes.'),
('Agatha Christie', 'Conhecida como a Rainha do Crime.'),
('George Orwell', 'Autor de 1984 e A Revolução dos Bichos.');
INSERT INTO cliente (cpf, nome) VALUES
('111.111.111-11', 'Ana Clara'),
('222.222.222-22', 'Bruno Silva'),
('333.333.333-33', 'Carlos Oliveira');
INSERT INTO livro (nome, id_autor, resumo, disponivel) VALUES
('Jogos Vorazes', 1, 'Distopia em que jovens lutam até a morte.', TRUE),
('Em Chamas', 1, 'Segundo livro da série Jogos Vorazes.', TRUE),
('E Não Sobrou Nenhum', 2, 'Dez pessoas isoladas são assassinadas uma a uma.', TRUE),
('1984', 3, 'Uma distopia sobre um regime totalitário.', TRUE),
('A Revolução dos Bichos', 3, 'Uma fábula política sobre animais e poder.', TRUE);
-- Ana Clara fez um empréstimo
INSERT INTO emprestimo (id_cliente, data_emprestimo, devolvido)
VALUES (1, '2025-05-01', FALSE);  -- devolução será 2025-05-15

-- Bruno Silva fez um empréstimo
INSERT INTO emprestimo (id_cliente, data_emprestimo, devolvido)
VALUES (2, '2025-05-03', FALSE);  -- devolução será 2025-05-17
-- Ana Clara pegou "Jogos Vorazes" e "1984"
INSERT INTO livros_emprestados (id_emprestimo, id_livro) VALUES
(1, 1),  -- Jogos Vorazes
(1, 4);  -- 1984

-- Bruno Silva pegou "E Não Sobrou Nenhum"
INSERT INTO livros_emprestados (id_emprestimo, id_livro) VALUES
(2, 3);
