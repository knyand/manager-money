INSERT INTO USERS (ID, EMAIL, NAME, PASSWORD, ENABLED)
VALUES (0, 'admin@test.loc', 'admin', '{bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG', TRUE);

INSERT INTO ROLES
VALUES (1, 'ROLE_USER');
INSERT INTO ROLES
VALUES (2, 'ROLE_ADMIN');

INSERT INTO AUTHORITIES
VALUES (0, 2);

INSERT INTO ACCOUNTS (USER_ID, CUR, SUM)
VALUES (0, 'BYN', 1000.00);
INSERT INTO ACCOUNTS (USER_ID, CUR, SUM)
VALUES (0, 'RUB', 55000.00);

INSERT INTO CATEGORIES (ID, NAME, CAPACITY)
VALUES (0, 'Home', 1000.00)
