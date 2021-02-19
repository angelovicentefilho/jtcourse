--- Insert users
INSERT INTO users (name, email, password) VALUES ('Angelo Vicente', 'angelo@gmail.com', '$2a$10$T7WegFimehlGoLvXFwDDaO.ErCL/x5gE/fOsJqVEsTLzM4.nGQiWG');
INSERT INTO users (name, email, password) VALUES ('Gustavo Ames', 'gustavo@gmail.com', '$2a$10$T7WegFimehlGoLvXFwDDaO.ErCL/x5gE/fOsJqVEsTLzM4.nGQiWG');
INSERT INTO users (name, email, password) VALUES ('Elias', 'elias@gmail.com', '$2a$10$T7WegFimehlGoLvXFwDDaO.ErCL/x5gE/fOsJqVEsTLzM4.nGQiWG');
INSERT INTO users (name, email, password) VALUES ('Adriano', 'adrianogmail.com', '$2a$10$T7WegFimehlGoLvXFwDDaO.ErCL/x5gE/fOsJqVEsTLzM4.nGQiWG');

--- Insert roles
INSERT INTO roles (name) VALUES ('ROLE_GOD');
INSERT INTO roles (name) VALUES ('ROLE_OPERATOR');
INSERT INTO roles (name) VALUES ('ROLE_MANAGER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

--- Join users with roles
INSERT INTO users_has_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_has_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO users_has_roles (user_id, role_id) VALUES (1, 3);
INSERT INTO users_has_roles (user_id, role_id) VALUES (1, 4);
INSERT INTO users_has_roles (user_id, role_id) VALUES (4, 2);
INSERT INTO users_has_roles (user_id, role_id) VALUES (4, 3);
INSERT INTO users_has_roles (user_id, role_id) VALUES (4, 4);
INSERT INTO users_has_roles (user_id, role_id) VALUES (3, 3);
INSERT INTO users_has_roles (user_id, role_id) VALUES (3, 2);
INSERT INTO users_has_roles (user_id, role_id) VALUES (2, 2);