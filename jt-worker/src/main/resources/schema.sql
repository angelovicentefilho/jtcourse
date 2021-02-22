DROP TABLE IF EXISTS workers;

CREATE TABLE workers (
	id BIGINT(20) NOT NULL AUTO_INCREMENT,
	daily_income DECIMAL(10,2) NOT NULL,
	name VARCHAR(50) NOT NULL,
	created_at TIMESTAMP NOT NULL default current_timestamp,
	updated_at TIMESTAMP NOT NULL default current_timestamp,
	PRIMARY KEY (id),
	INDEX TIMER(created_at ASC, updated_at ASC),
	INDEX NAME(name ASC)
) ENGINE = InnoDB;