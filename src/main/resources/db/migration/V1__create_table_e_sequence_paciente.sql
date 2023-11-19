CREATE SEQUENCE paciente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE paciente (
    paciente_id BIGINT DEFAULT nextval('paciente_id_seq') PRIMARY KEY,
    nome VARCHAR(255) NOT NULL UNIQUE,
    sobrenome VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    cpf VARCHAR(20)
);
