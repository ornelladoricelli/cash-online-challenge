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
    constraint foreign key loan_fk_user_id(user_id)
    references cash_online.users(id)
    );



