INSERT INTO users (id, email, first_name, last_name, password, user_name) VALUES (1, 'devadmin@astronaut.com', 'devadmin', 'devadmin', '$2a$10$.9OJva5sUh0f0eSkzakxweYgHZi7slrRrNa2BHD.N8dDNWziBWs2O', 'devadmin');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_USER');
INSERT INTO roles (id, name) VALUES (3, 'ROLE_ADMIN');
INSERT INTO user_roles (user_id, role_id) VALUES (1, 3);