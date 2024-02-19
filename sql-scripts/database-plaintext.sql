USE employee_directory;

DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

#
#	Table structure for users
#

CREATE TABLE users
(
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(50) NOT NULL,
    enabled TINYINT NOT NULL
);

#
# Insert users data
#

INSERT INTO users VALUES
('john', '{noop}test123', 1),
('mary', '{noop}test234', 1),
('susan', '{noop}test345', 1);

#
#	Table structure for authorities (roles)
#

CREATE TABLE authorities
(
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    UNIQUE KEY authority_id (username, authority),
    CONSTRAINT authority_fk FOREIGN KEY (username) REFERENCES users(username)
);

#
#	Insert authorities data
#

INSERT INTO authorities VALUES
('john', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_MANAGER'),
('susan', 'ROLE_EMPLOYEE'),
('susan', 'ROLE_MANAGER'),
('susan', 'ROLE_ADMIN');