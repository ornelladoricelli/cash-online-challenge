create schema if not exists cash_online;

USE cash_online;

SET FOREIGN_KEY_CHECKS = 0;

create table if not exists users
(
    id int AUTO_INCREMENT primary key,
    email varchar(255) NOT NULL,
    first_name varchar(255) not null,
    last_name varchar(255) not null
    );

create table if not exists loan
(
    id int AUTO_INCREMENT primary key,
    total decimal (10,4) not null,
    user_id int not null,
    constraint loan_fk_user_id foreign key (user_id) references cash_online.users(id)
    );

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