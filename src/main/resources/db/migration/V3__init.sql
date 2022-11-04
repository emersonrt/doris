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
INSERT INTO public.usuario (id, username, email, password) VALUES (1, 'admin', 'admin@gmail.com', '$2a$10$.hzi0eqomONYpA2bpo/C9eWkXUZqH1AhSAfQj4gOwA.UwuRbO3uhi');
INSERT INTO public.candidato (id, nome, data_nascimento, telefone_celular, email, carga_horaria, turno, modalidade_trabalho, cidade_residencia, disponibilidade_realocacao, area_interesse, pontos_fortes, pontos_fracos, informacao_relevante) VALUES (1, 'Émerson', '1999-03-09', '51998567167', 'emersonrosateixeira@hotmail.com', 'Turno integral', 'Manhã e noite', 'Remoto', null, null, 'Desenvolvimento de Software', null, 'l', null);
INSERT INTO public.candidato (id, nome, data_nascimento, telefone_celular, email, carga_horaria, turno, modalidade_trabalho, cidade_residencia, disponibilidade_realocacao, area_interesse, pontos_fortes, pontos_fracos, informacao_relevante) VALUES (6, 'Douglas T. Teste', '1988-05-17', '51998564456', 'doug@hotmail.com', 'Turno integral', 'Manhã e noite', 'Remoto', null, null, 'Desenvolvimento de Software', null, null, null);
INSERT INTO public.candidato (id, nome, data_nascimento, telefone_celular, email, carga_horaria, turno, modalidade_trabalho, cidade_residencia, disponibilidade_realocacao, area_interesse, pontos_fortes, pontos_fracos, informacao_relevante) VALUES (11, 'Ana Paula Klein', '1999-05-17', '51998564456', 'anap@hotmail.com', 'Turno integral', 'Manhã e noite', 'Remoto', null, null, 'Desenvolvimento de Software', null, null, null);
INSERT INTO public.candidato (id, nome, data_nascimento, telefone_celular, email, carga_horaria, turno, modalidade_trabalho, cidade_residencia, disponibilidade_realocacao, area_interesse, pontos_fortes, pontos_fracos, informacao_relevante) VALUES (15, 'Douglas T. Teste', '1988-05-17', '51998564456', 'doug@hotmail.com', 'Turno integral', 'Manhã e noite', 'Remoto', null, null, 'Desenvolvimento de Software', null, null, null);
INSERT INTO public.candidato (id, nome, data_nascimento, telefone_celular, email, carga_horaria, turno, modalidade_trabalho, cidade_residencia, disponibilidade_realocacao, area_interesse, pontos_fortes, pontos_fracos, informacao_relevante) VALUES (19, 'Jon Snow', '1977-05-17', '51998566598', 'snowland@hotmail.com', 'Turno integral', 'Manhã e noite', 'Remoto', null, null, 'Desenvolvimento de Software', null, null, null);
INSERT INTO public.candidato (id, nome, data_nascimento, telefone_celular, email, carga_horaria, turno, modalidade_trabalho, cidade_residencia, disponibilidade_realocacao, area_interesse, pontos_fortes, pontos_fracos, informacao_relevante) VALUES (21, 'Émerson', '1999-03-09', '51998567167', 'emersonrosateixeira@hotmail.com', 'Turno integral', 'Manhã e noite', 'Remoto', null, null, 'Desenvolvimento de Software', null, 'l', null);
INSERT INTO public.candidato (id, nome, data_nascimento, telefone_celular, email, carga_horaria, turno, modalidade_trabalho, cidade_residencia, disponibilidade_realocacao, area_interesse, pontos_fortes, pontos_fracos, informacao_relevante) VALUES (27, 'Jon Snow', '1977-05-17', '51998566598', 'snowland@hotmail.com', 'Turno integral', 'Manhã e noite', 'Remoto', null, null, 'Desenvolvimento de Software', null, null, null);
INSERT INTO public.candidato (id, nome, data_nascimento, telefone_celular, email, carga_horaria, turno, modalidade_trabalho, cidade_residencia, disponibilidade_realocacao, area_interesse, pontos_fortes, pontos_fracos, informacao_relevante) VALUES (2, 'Douglas T. Teste', '1988-05-17', '51998564456', 'doug@hotmail.com', 'Turno integral', 'Manhã e noite', 'Remoto', null, null, 'Desenvolvimento de Software', null, null, null);
INSERT INTO public.candidato (id, nome, data_nascimento, telefone_celular, email, carga_horaria, turno, modalidade_trabalho, cidade_residencia, disponibilidade_realocacao, area_interesse, pontos_fortes, pontos_fracos, informacao_relevante) VALUES (4, 'Ana Paula Klein', '1999-05-17', '51998564456', 'anap@hotmail.com', 'Turno integral', 'Manhã e noite', 'Remoto', null, null, 'Desenvolvimento de Software', null, null, null);
INSERT INTO public.candidato (id, nome, data_nascimento, telefone_celular, email, carga_horaria, turno, modalidade_trabalho, cidade_residencia, disponibilidade_realocacao, area_interesse, pontos_fortes, pontos_fracos, informacao_relevante) VALUES (7, 'Ana Paula Klein', '1999-05-17', '51998564456', 'anap@hotmail.com', 'Turno integral', 'Manhã e noite', 'Remoto', null, null, 'Desenvolvimento de Software', null, null, null);