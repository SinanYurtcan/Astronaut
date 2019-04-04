INSERT INTO users (id, email, first_name, last_name, password, user_name, status) VALUES (1, 'devadmin@astronaut.com', 'devadmin', 'devadmin', '$2a$10$.9OJva5sUh0f0eSkzakxweYgHZi7slrRrNa2BHD.N8dDNWziBWs2O', 'devadmin', 'A');
INSERT INTO roles (id, name, status) VALUES (2, 'ROLE_USER', 'A');
INSERT INTO roles (id, name, status) VALUES (3, 'ROLE_ADMIN', 'A');
INSERT INTO user_roles (user_id, role_id) VALUES (1, 3);
INSERT INTO household(id, name, status) VALUES (4, 'Sinion', 'A');