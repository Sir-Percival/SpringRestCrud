USE employee_directory;

DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

#
#	Table structure for users
#

CREATE TABLE users
(
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password CHAR(68) NOT NULL,
    enabled TINYINT NOT NULL
);

#
# Insert users data
#

INSERT INTO users VALUES
('john', '{bcrypt}$2a$10$NNDdBdaiqBfEQRm18XlZouO6E.hns0zSHeBKnD0p.ZL2wWLfzX1/S', 1),
('mary', '{bcrypt}$2a$10$tgF3lSPVfkVDhYVRHOdexuqFmn7xBVJZnialW3P.lF6gfEbcIBc8i', 1),
('susan', '{bcrypt}$2a$10$McAswK3HXK3/uQ2IkSfX7./Py7vYMIihP8kbryMCSLOBb1cH7mipW', 1);

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