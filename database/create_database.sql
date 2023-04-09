create database demo;
use demo;

CREATE TABLE `role` (
  `id` int PRIMARY KEY,
  `name` varchar(10)
);

CREATE TABLE `user` (
  `id` int PRIMARY KEY,
  `first_name` nvarchar(50),
  `last_name` nvarchar(50),
  `email` nvarchar(150),
  `password` nvarchar(72),
  `phonenumber` varchar(20),
  `city` nvarchar(150),
  `district` nvarchar(150),
  `street_address` nvarchar(150),
  `role_id` int
);

CREATE TABLE `category` (
  `id` int PRIMARY KEY,
  `title` nvarchar(100)
);

CREATE TABLE `product` (
  `id` int PRIMARY KEY,
  `title` nvarchar(100),
  `rate` float,
  `size` int,
  `price` int,
  `discount` int,
  `thumbnail` nvarchar(500),
  `description` longtext,
  `create_at` datetime,
  `update_at` datetime,
  `category_id` int
);

CREATE TABLE `galery` (
  `id` int PRIMARY KEY,
  `product_id` int,
  `thumbnail` nvarchar(500)
);

CREATE TABLE `review` (
  `id` int PRIMARY KEY,
  `rate` float,
  `content` nvarchar(500),
  `user_id` int,
  `product_id` int
);

CREATE TABLE `feedback` (
  `id` int PRIMARY KEY,
  `first_name` nvarchar(50),
  `last_name` nvarchar(50),
  `email` nvarchar(150),
  `phonenumber` varchar(20),
  `subject` nvarchar(100),
  `note` nvarchar(500)
);

CREATE TABLE `orders` (
  `id` int PRIMARY KEY,
  `first_name` nvarchar(50),
  `last_name` nvarchar(50),
  `email` nvarchar(150),
  `phonenumber` varchar(20),
  `city` nvarchar(150),
  `district` nvarchar(150),
  `street_address` nvarchar(150),
  `note` nvarchar(200),
  `order_date` datetime,
  `status` int,
  `total_money` int,
  `user_id` int
);

CREATE TABLE `order_details` (
  `id` int PRIMARY KEY,
  `order_id` int,
  `product_id` int,
  `price` int,
  `num` int
);

ALTER TABLE `user` ADD FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

ALTER TABLE `review` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `review` ADD FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

ALTER TABLE `product` ADD FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

ALTER TABLE `galery` ADD FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

ALTER TABLE `order_details` ADD FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

ALTER TABLE `order_details` ADD FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);
