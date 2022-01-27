USE cash_online;

INSERT INTO users (email, first_name, last_name)
VALUES ('juan@mail.com', 'Juan', 'Perez');

SET @last_user_id = LAST_INSERT_ID();

INSERT INTO loan (total, user_id)
VALUES
(10000, @last_user_id),
(15000, @last_user_id),
(1987.99, @last_user_id);

INSERT INTO users (email, first_name, last_name)
VALUES ('maria@mail.com', 'Maria', 'Gomez');

SET @last_user_id = LAST_INSERT_ID();

INSERT INTO loan (total, user_id)
VALUES
(30000, @last_user_id),
(5098, @last_user_id),
(7900.65, @last_user_id);