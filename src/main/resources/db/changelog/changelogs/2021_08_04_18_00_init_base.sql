CREATE TABLE department
(
    id                 BIGSERIAL PRIMARY KEY,
    department_name    VARCHAR(100),
    head_of_department VARCHAR(100)
);

CREATE TYPE degree AS ENUM ('ASSISTANT', 'ASSOCIATE_PROFESSOR', 'PROFESSOR');

CREATE TABLE lector
(
    id               BIGSERIAL PRIMARY KEY,
    lector_full_name VARCHAR(100),
    degree           VARCHAR CHECK (degree='ASSISTANT' OR degree='ASSOCIATE_PROFESSOR' OR degree='PROFESSOR' ),
    salary           INT
);

CREATE TABLE department_lector_ref
(
    department_id BIGSERIAL,
    lector_id     BIGSERIAL
);