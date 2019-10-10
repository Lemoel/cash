CREATE TABLE pessoa (
    CODIGO BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(50) NOT NULL,
    ATIVO TINYINT(1) NOT NULL,
    LOGRADOURO VARCHAR(50),
    NUMERO VARCHAR(50),
    COMPLEMENTO VARCHAR(50),
    BAIRRO VARCHAR(50),
    CEP VARCHAR(50),
    CIDADE VARCHAR(50),
    ESTADO VARCHAR(50)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO  pessoa
(CODIGO, NOME, ATIVO, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO)
VALUES(1, 'Lemoel Marques Vieira', 1, 'Max Hering 132', '177', NULL, 'Vila Esperança', '78700100', 'Rondonópolis', 'Mato Grosso');
INSERT INTO  pessoa
(CODIGO, NOME, ATIVO, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO)
VALUES(2, 'Daniel Mariano Marques', 1, 'Rua Pedro Ferrer', '177', NULL, 'Vila Aurora', '78700100', 'Rondonópolis', 'Mato Grosso');
INSERT INTO  pessoa
(CODIGO, NOME, ATIVO, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO)
VALUES(3, 'Rebeca Mariano Marques', 1, 'Rua Pedro Ferrer', '177', NULL, 'Vila Aurora', '78700100', 'Rondonópolis', 'Mato Grosso');
INSERT INTO  pessoa
(CODIGO, NOME, ATIVO, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO)
VALUES(4, 'Josiane Mariano Marques', 1, 'Rua Pedro Ferrer', '177', 'Chácara', 'Vila Aurora', '78700100', 'Rondonópolis', 'Mato Grosso');
INSERT INTO  pessoa
(CODIGO, NOME, ATIVO, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO)
VALUES(5, 'Otoniel Taranto', 1, 'Avenida Santana', '341', 'Dentro do Shopping', 'Centro', '78700100', 'Campo Grande', 'Mato Grosso');
INSERT INTO  pessoa
(CODIGO, NOME, ATIVO, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO)
VALUES(6, 'Otoniel Taranto', 1, 'Avenida Santana', '341', 'Dentro do Shopping', 'Centro', '78700100', 'Campo Grande', 'Mato Grosso');
INSERT INTO  pessoa
(CODIGO, NOME, ATIVO, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO)
VALUES(7, 'Gesiel Marques Veiira', 1, 'Avenida Afonso Pena', '177', 'Centro Comercial', 'Centro', '78700100', 'Campo Grande', 'Mato Grosso');
INSERT INTO  pessoa
(CODIGO, NOME, ATIVO, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO)
VALUES(8, 'Otoniel Marques Veira', 1, 'Avenida Afonso Pena', '177', 'Dentro do Shopping', 'Centro', '78700100', 'Campo Grande', 'Mato Grosso');
INSERT INTO  pessoa
(CODIGO, NOME, ATIVO, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO)
VALUES(9, 'Otoniel Marques Veira', 1, 'Avenida Afonso Pena', '177', NULL, 'Centro', '78700100', 'Campo Grande', 'Mato Grosso');
