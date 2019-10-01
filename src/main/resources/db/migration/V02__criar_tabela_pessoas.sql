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