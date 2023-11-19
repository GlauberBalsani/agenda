CREATE SEQUENCE descricao_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



CREATE TABLE agenda (
    agenda_id BIGINT DEFAULT nextval('descricao_id_seq') PRIMARY KEY,
    descricao VARCHAR(255) UNIQUE NOT NULL,
    data_hora TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    data_criacao TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    paciente_id BIGINT,
    FOREIGN KEY (paciente_id) REFERENCES paciente (paciente_id)
);
