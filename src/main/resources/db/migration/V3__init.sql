CREATE TABLE usuario
(
    id       BIGINT NOT NULL,
    username VARCHAR(255),
    email    VARCHAR(255),
    password VARCHAR(255),
    CONSTRAINT pk_usuario PRIMARY KEY (id)
);

ALTER TABLE usuario
    ADD CONSTRAINT uc_67936a06fdfeb7cb9cc69068a UNIQUE (username);

ALTER TABLE usuario
    ADD CONSTRAINT uc_e1cc63ea3391cb0f8c624d971 UNIQUE (email);





CREATE TABLE perfis_acesso
(
    id   BIGINT NOT NULL,
    name VARCHAR(20),
    CONSTRAINT pk_perfis_acesso PRIMARY KEY (id)
);



CREATE TABLE candidato
(
    id                         BIGINT       NOT NULL,
    nome                       VARCHAR(255) NOT NULL,
    data_nascimento            date         NOT NULL,
    telefone_celular           VARCHAR(255) NOT NULL,
    email                      VARCHAR(255) NOT NULL,
    carga_horaria              VARCHAR(255) NOT NULL,
    turno                      VARCHAR(255) NOT NULL,
    modalidade_trabalho        VARCHAR(255) NOT NULL,
    cidade_residencia          VARCHAR(255),
    disponibilidade_realocacao BOOLEAN,
    area_interesse             VARCHAR(255) NOT NULL,
    pontos_fortes              VARCHAR(255),
    pontos_fracos              VARCHAR(255),
    informacao_relevante       VARCHAR(255),
    CONSTRAINT pk_candidato PRIMARY KEY (id)
);


INSERT INTO public.perfis_acesso (id, name) VALUES (1, 'ADMIN');
INSERT INTO public.perfis_acesso (id, name) VALUES (2, 'USER');