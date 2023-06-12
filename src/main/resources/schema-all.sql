DROP TABLE equipamento IF EXISTS;
DROP TABLE endereco IF EXISTS;
DROP TABLE cliente IF EXISTS;
DROP TABLE ordemservico IF EXISTS;
DROP TABLE acompanhamento IF EXISTS;

CREATE TABLE equipamento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(255),
    marca VARCHAR(255),
    problema VARCHAR(255)
);

CREATE TABLE endereco (
    id INT PRIMARY KEY AUTO_INCREMENT,
    cidade VARCHAR(255),
    logradouro VARCHAR(255),
    numero VARCHAR(255),
    complemento VARCHAR(255),
    bairro VARCHAR(255),
    cep VARCHAR(255)
);

CREATE TABLE cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    EMAIL VARCHAR(255),
    telefone VARCHAR(255),
    idendereco INT
);

CREATE TABLE ordemservico (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(255),
    responsavel VARCHAR(255),
    dataCadastro DATE,
    dataInicio DATE,
    dataTermino DATE,
    idequipamento INT,
    idcliente INT
);

CREATE TABLE acompanhamento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(255),
    data DATE,
    idordemservico INT,
    termino BOOLEAN
);