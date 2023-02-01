drop database if exists shopee;
create database shopee;
use shopee;
drop table  if exists`Account`;
CREATE TABLE Account (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           username VARCHAR(50) NOT NULL,
                           role ENUM('CUSTOMER', 'SELLER', 'ADMIN') NOT NULL,
                           password VARCHAR(50) NOT NULL,
                           date_of_birth DATE,
                           address VARCHAR(255),
                           full_name VARCHAR(50),
                           phone_number VARCHAR(12) NOT NULL,
                           email VARCHAR(50) NOT NULL,
                           facebook VARCHAR(50),
                           information VARCHAR(255)
);

drop table if exists Product;
CREATE TABLE Product (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) UNIQUE NOT NULL UNIQUE,
                         image VARCHAR(255) NOT NULL,
                         price INT,
                         status ENUM('NEW', 'OLD') NOT NULL,
                         shipping_unit ENUM('EXPRESS', 'FAST', 'SAVE') NOT NULL,
                         type ENUM('PHONE', 'COMPUTER', 'CLOTHES', 'FOOTWEAR') NOT NULL,
                         create_date DATE
);

drop table if exists `Order`;
CREATE TABLE `Order` (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         order_date DATE,
                         order_by INT,
                         product_id INT,
                         quantity INT,
                         status ENUM('PENDING', 'DONE', 'CANCEL') NOT NULL,
                         FOREIGN KEY (order_by)
                             REFERENCES Account (id),
                         FOREIGN KEY (product_id)
                             REFERENCES Product (id)
);