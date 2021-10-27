-- ==============================================================
-- ST4Example DB creation script for MySQL
-- ==============================================================
SET NAMES utf8;

DROP DATABASE IF EXISTS `st4db`;
CREATE DATABASE st4db CHARACTER SET utf8 COLLATE utf8_bin;

USE st4db;
-- --------------------------------------------------------------
-- ROLES
-- users roles
-- --------------------------------------------------------------

CREATE TABLE roles(

-- id has the INTEGER type (other name is INT), it is the primary key
                      id INTEGER NOT NULL  PRIMARY KEY,

-- name has the VARCHAR type - a string with a variable length
-- names values should not be repeated (UNIQUE)
                      name VARCHAR(10) NOT NULL UNIQUE
);

-- this two commands insert data into roles table
-- --------------------------------------------------------------

INSERT INTO roles VALUES(1, 'ROLE_ADMIN');
INSERT INTO roles VALUES(2, 'ROLE_USER');
-- --------------------------------------------------------------
-- USERS
-- --------------------------------------------------------------
CREATE TABLE users(

                      id INTEGER NOT NULL auto_increment PRIMARY KEY,

-- 'UNIQUE' means logins values should not be repeated in login column of table
                      login VARCHAR(20) NOT NULL UNIQUE,

-- not null string columns
                      password VARCHAR(255) NOT NULL,
                      first_name VARCHAR(20) NOT NULL,
                      last_name VARCHAR(20) NOT NULL,

-- this declaration contains the foreign key constraint
-- role_id in users table is associated with id in roles table
-- role_id of user = id of role
                      role_id INTEGER NOT NULL REFERENCES roles(id)

-- removing a row with some ID from roles table implies removing
-- all rows from users table for which ROLES_ID=ID
-- default value is ON DELETE RESTRICT, it means you cannot remove
-- row with some ID from the roles table if there are rows in
-- users table with ROLES_ID=ID
                          ON DELETE CASCADE

-- the same as previous but updating is used insted deleting
                          ON UPDATE RESTRICT
);

-- id = 1
INSERT INTO users VALUES(DEFAULT, 'admin', '$2a$10$y3mvWzqGZ6knuvsRkgH9nOyBigfnmcR6adbjmUIe6tNixLcBgIDRS', 'Ivan', 'Ivanov', 1);
-- id = 2
INSERT INTO users VALUES(DEFAULT, 'user', '$2a$10$k8PaITNkwNMSV2VVHQyZ6O/5uAuz/atRgbyenaaRgwrEWpiq7i6km', 'Petr', 'Petrov', 2);

-- --------------------------------------------------------------
-- ORDERS
-- --------------------------------------------------------------
CREATE TABLE orders(
                       id INTEGER NOT NULL auto_increment PRIMARY KEY,
                       bill INTEGER NOT NULL DEFAULT 0,
                       user_id INTEGER NOT NULL REFERENCES users(id)

);


INSERT INTO orders VALUES(DEFAULT, 1, 1);
-- bill = 1; user_id=1
INSERT INTO orders VALUES(DEFAULT, 2, 1);

-- --------------------------------------------------------------
-- MENU
-- --------------------------------------------------------------
CREATE TABLE cars
(
    id INTEGER NOT NULL auto_increment PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    price INTEGER NOT NULL,
    category VARCHAR(50) NOT NULL
);

INSERT INTO cars VALUES(DEFAULT, 'Mazda6', 200, 'D');
INSERT INTO cars VALUES(DEFAULT, 'Wolksvagen Polo', 75, 'B');
INSERT INTO cars VALUES(DEFAULT, 'Daewoo Matiz', 25, 'A');
INSERT INTO cars VALUES(DEFAULT, 'Toyota Corolla', 100, 'C');

-- --------------------------------------------------------------
-- ORDERS_CARS
-- relation between order and car
-- each row of this table represents one cars item
-- --------------------------------------------------------------
CREATE TABLE orders_cars(
                            id BIGINT NOT NULL auto_increment PRIMARY KEY,
                            order_id INTEGER NOT NULL REFERENCES orders(id),
                            car_id INTEGER NOT NULL REFERENCES cars (id)
);

INSERT INTO orders_cars VALUES(1, 1, 1);
INSERT INTO orders_cars VALUES(2, 2, 2);
INSERT INTO orders_cars VALUES(3, 3, 3);
INSERT INTO orders_cars VALUES(4, 4, 4);
-- --------------------------------------------------------------
-- test database:
-- --------------------------------------------------------------
SELECT * FROM orders_cars;
SELECT * FROM cars;
SELECT * FROM orders;
SELECT * FROM users;
SELECT * FROM roles;

