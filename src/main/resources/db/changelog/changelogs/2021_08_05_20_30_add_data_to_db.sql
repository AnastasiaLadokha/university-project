INSERT INTO lector (id, lector_full_name, degree, salary)
VALUES (1, 'Kovalenko', 'ASSISTANT', 5000);
INSERT INTO lector (id, lector_full_name, degree, salary)
VALUES (2, 'Bilous', 'PROFESSOR', 20000);
INSERT INTO lector (id, lector_full_name, degree, salary)
VALUES (3, 'Trunova', 'ASSISTANT', 2000);
INSERT INTO lector (id, lector_full_name, degree, salary)
VALUES (4, 'Nehai', 'ASSOCIATE_PROFESSOR', 10000);
INSERT INTO lector (id, lector_full_name, degree, salary)
VALUES (5, 'Petrov', 'ASSOCIATE_PROFESSOR', 10000);
INSERT INTO lector (id, lector_full_name, degree, salary)
VALUES (6, 'Kruk', 'PROFESSOR', 15000);

INSERT INTO department (id, department_name, head_of_department)
VALUES (1, 'NNIMHTT', 'Derkach');
INSERT INTO department (id, department_name, head_of_department)
VALUES (2, 'NNIEIT', 'Ivanets');

INSERT INTO department_lector_ref (department_id, lector_id)
VALUES (1, 1);
INSERT INTO department_lector_ref (department_id, lector_id)
VALUES (1, 2);
INSERT INTO department_lector_ref (department_id, lector_id)
VALUES (1, 5);
INSERT INTO department_lector_ref (department_id, lector_id)
VALUES (2, 3);
INSERT INTO department_lector_ref (department_id, lector_id)
VALUES (2, 4);
INSERT INTO department_lector_ref (department_id, lector_id)
VALUES (2, 6);
