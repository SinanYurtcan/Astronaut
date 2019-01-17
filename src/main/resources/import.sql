INSERT INTO users (id, email, first_name, last_name, password, user_name) VALUES (1, 'devadmin@astronaut.com', 'devadmin', 'devadmin', '$2a$10$.Fo5TYHbd3Hv0gwKyab.rODO1..yGikFDU5JI.aMasy6ETJgSxRly', 'devadmin');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_USER');
INSERT INTO roles (id, name) VALUES (3, 'ROLE_ADMIN');
INSERT INTO user_roles (user_id, role_id) VALUES (1, 3);