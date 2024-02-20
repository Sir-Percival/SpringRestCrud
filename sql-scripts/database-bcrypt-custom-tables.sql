USE employee_directory;

DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS members;

#
#	Table structure for users
#

CREATE TABLE members
(
    user_id VARCHAR(50) NOT NULL PRIMARY KEY,
    passwd CHAR(68) NOT NULL,
    active TINYINT NOT NULL
);

#
# Insert users data
#

INSERT INTO members VALUES
('john', '{bcrypt}$2a$10$NNDdBdaiqBfEQRm18XlZouO6E.hns0zSHeBKnD0p.ZL2wWLfzX1/S', 1),
('mary', '{bcrypt}$2a$10$tgF3lSPVfkVDhYVRHOdexuqFmn7xBVJZnialW3P.lF6gfEbcIBc8i', 1),
('susan', '{bcrypt}$2a$10$McAswK3HXK3/uQ2IkSfX7./Py7vYMIihP8kbryMCSLOBb1cH7mipW', 1);

#
#	Table structure for authorities (roles)
#

CREATE TABLE roles
(
    user_id VARCHAR(50) NOT NULL,
    role VARCHAR(50) NOT NULL,
    UNIQUE KEY authority_id (user_id, role),
    CONSTRAINT authority_fk FOREIGN KEY (user_id) REFERENCES members(user_id)
);

#
#	Insert authorities data
#

INSERT INTO roles VALUES
('john', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_MANAGER'),
('susan', 'ROLE_EMPLOYEE'),
('susan', 'ROLE_MANAGER'),
('susan', 'ROLE_ADMIN');