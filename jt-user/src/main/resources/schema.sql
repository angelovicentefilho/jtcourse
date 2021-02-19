DROP TABLE IF EXISTS users_has_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

CREATE TABLE users (
	id BIGINT(20) NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	password VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	created_at DATETIME(6) NOT NULL,
	updated_at DATETIME(6) NOT NULL,
	PRIMARY KEY(id),
	INDEX TIMER(created_at ASC, updated_at ASC),
	INDEX EMAIL(email ASC),
	INDEX NAME (name ASC)
) ENGINE = InnoDB;

CREATE TABLE roles (
	id BIGINT(20) NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	created_at DATETIME(6) NOT NULL,
	updated_at DATETIME(6) NOT NULL,
	PRIMARY KEY (id),
	INDEX TIMER(created_at ASC, updated_at ASC),
	INDEX NAME(name ASC)
) ENGINE = InnoDB;

CREATE TABLE users_has_roles (
	user_id BIGINT(20) NOT NULL,
	role_id BIGINT(20) NOT NULL,
	PRIMARY KEY (user_id, role_id),
	INDEX FK_ROLES_ROLES_IDX (id ASC),
	INDEX FK_USERS_USERS_IDX (id ASC),
	CONSTRAINT FK_USERS_USERS
		FOREIGN KEY (user_id)
		REFERENCES users (id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	CONSTRAINT FK_ROLES_ROLES
		FOREIGN KEY (role_id)
		REFERENCES roles (id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
) ENGINE = InnoDB;