use btl;

INSERT INTO `btl`.`role`
(`name`)
VALUES
('ADMIN'),
('USER');

INSERT INTO `btl`.`size`
(`size_name`)
VALUES
('M'),
('L'),
('XL');

INSERT INTO `btl`.`category`
(`title`)
VALUES
('T-SHIRTS'),
('SHIRTS'),
('SWEATERS'),
('HOODIES'),
('SHORTS'),
('BAGS'),
('PERFUME'),
('JACKET'),
('ACCESSORIES'),
('POLO');

INSERT INTO `btl`.`product`
(`title`,
`rate`,
`price`,
`discount`,
`thumbnail`,
`description`,
`create_at`,
`update_at`,
`category_id`)
VALUES
('WORLD MAP T-SHIRT/RED', 5.0, 420000, 59000, 'worldmap.jpg', '• Thông tin sản phẩm:

 WORLD MAP T-SHIRT

 HOẠ TIẾT: IN LỤA U.S.A INK

 COLOR: BLACK / WHITE / DARK GREEN / DARK BROW / DARK GREY / RED

 SIZE: M / L / XL

 MATERIAL: PREMIUM COTTON.', '2023-04-12 18:00:00', '2023-04-12 18:00:00', 1),
 ('SWEATER SWEATER/YELLOW', 5.0, 560000, 159000, 'sweater1.jpg', '• Thông tin sản phẩm:

 SWEATER SWEATER/YELLOW

 HOẠ TIẾT: IN LỤA U.S.A INK

 COLOR: BLACK / WHITE / DARK GREEN / DARK BROW / DARK GREY / RED

 SIZE: M / L / XL

 MATERIAL: PREMIUM COTTON.', '2023-04-15 18:00:00', '2023-04-15 18:00:00', 3),
 ('IDENTIFY T-SHIRT/RED', 5.0, 420000, 59000, 'identity.jpg', '• Thông tin sản phẩm:

 IDENTIFY T-SHIRT

 HOẠ TIẾT: IN LỤA U.S.A INK

 COLOR: BLACK / WHITE / DARK GREEN / DARK BROW / DARK GREY / RED

 SIZE: M / L / XL

 MATERIAL: PREMIUM COTTON.', '2023-04-15 18:00:00', '2023-04-15 18:00:00', 1),
 ('FLOAT ICONS T-SHIRT/DARK BROW', 5.0, 420000, 59000, 'float.jpg', '• Thông tin sản phẩm:

 FLOAT ICONS T-SHIRT

 HOẠ TIẾT: IN LỤA U.S.A INK

 COLOR: BLACK / WHITE / DARK GREEN / DARK BROW / DARK GREY / DARK RED

 SIZE: M / L / XL

 MATERIAL: PREMIUM COTTON.', '2023-04-15 18:00:00', '2023-04-15 18:00:00', 1),
 ('SWEATER SWEATER BEAR/GREY', 5.0, 560000, 189000, 'sweater2.jpg', '• Thông tin sản phẩm:

 SWEATER SWEATER BEAR/GREY

 HOẠ TIẾT: IN LỤA U.S.A INK

 COLOR: BLACK / WHITE / DARK GREEN / DARK BROW / DARK GREY / RED

 SIZE: M / L / XL

 MATERIAL: PREMIUM COTTON.', '2023-04-15 18:00:00', '2023-04-15 18:00:00', 3),
 ('POLO POLO BASIC/GREY', 5.0, 360000, 129000, 'polo1.jpg', '• Thông tin sản phẩm:

 POLO POLO BASIC/GREY

 HOẠ TIẾT: IN LỤA U.S.A INK

 COLOR: BLACK / WHITE / DARK GREEN / DARK BROW / DARK GREY / RED

 SIZE: M / L / XL

 MATERIAL: PREMIUM COTTON.', '2023-04-15 18:00:00', '2023-04-15 18:00:00', 4),
 ('POLO POLO BLACKWHITE/BLACK', 5.0, 360000, 149000, 'polo2.jpg', '• Thông tin sản phẩm:

 POLO POLO BLACKWHITE/BLACK

 HOẠ TIẾT: IN LỤA U.S.A INK

 COLOR: BLACK / WHITE / DARK GREEN / DARK BROW / DARK GREY / RED

 SIZE: M / L / XL

 MATERIAL: PREMIUM COTTON.', '2023-04-15 18:00:00', '2023-04-15 18:00:00', 4),
 ('SHIRT SHIRT BASIC/BLUE', 5.0, 360000, 249000, 'shirt1.jpg', '• Thông tin sản phẩm:

 SHIRT SHIRT BASIC/BLUE

 HOẠ TIẾT: IN LỤA U.S.A INK

 COLOR: BLACK / WHITE / DARK GREEN / DARK BROW / DARK GREY / RED

 SIZE: M / L / XL

 MATERIAL: PREMIUM COTTON.', '2023-04-15 18:00:00', '2023-04-15 18:00:00', 2),
 ('SHIRT SHIRT CARO/DIOR', 5.0, 380000, 249000, 'shirt2.jpg', '• Thông tin sản phẩm:

 SHIRT SHIRT CARO/DIOR

 HOẠ TIẾT: IN LỤA U.S.A INK

 COLOR: BLACK / WHITE / DARK GREEN / DARK BROW / DARK GREY / RED

 SIZE: M / L / XL

 MATERIAL: PREMIUM COTTON.', '2023-04-15 18:00:00', '2023-04-15 18:00:00', 2);
 
 
INSERT INTO `btl`.`galery`
(`product_id`,
`thumbnail`)
VALUES
(
1,
'galery1.jpg'),
(
1,
'galery2.jpg'),
(
1,
'galery3.jpg'),
(
1,
'galery4.jpg'),
(
1,
'galery5.jpg'),
(
2,
'galery6.jpg'),
(
2,
'galery7.jpg'),
(
2,
'galery8.jpg'),
(
2,
'galery9.jpg'),
(
2,
'galery10.jpg'),
(
3,
'galery11.jpg'),
(
3,
'galery12.jpg'),
(
3,
'galery13.jpg'),
(
3,
'galery14.jpg'),
(
3,
'galery15.jpg'),
(
4,
'galery16.jpg'),
(
4,
'galery17.jpg'),
(
4,
'galery18.jpg'),
(
4,
'galery19.jpg'),
(
4,
'galery20.jpg'),
(
5,
'galery21.jpg'),
(
5,
'galery22.jpg'),
(
5,
'galery23.jpg'),
(
5,
'galery24.jpg'),
(
5,
'galery25.jpg'),
(
6,
'galery26.jpg'),
(
6,
'galery27.jpg'),
(
6,
'galery28.jpg'),
(
6,
'galery29.jpg'),
(
6,
'galery30.jpg'),
(
7,
'galery31.jpg'),
(
7,
'galery32.jpg'),
(
7,
'galery33.jpg'),
(
7,
'galery34.jpg'),
(
7,
'galery35.jpg'),
(
8,
'galery36.jpg'),
(
8,
'galery37.jpg'),
(
8,
'galery38.jpg'),
(
8,
'galery39.jpg'),
(
8,
'galery40.jpg'),
(
9,
'galery41.jpg'),
(
9,
'galery42.jpg'),
(
9,
'galery43.jpg'),
(
9,
'galery44.jpg'),
(
9,
'galery45.jpg');

INSERT INTO `btl`.`product_size`
(
`size_id`,
`size_availability`,
`product_id`)
VALUES
(1,
10,
1),
(2,
10,
1),
(3,
10,
1),
(1,
10,
2),
(2,
10,
2),
(3,
10,
2),
(1,
10,
3),
(2,
10,
3),
(3,
10,
3),
(1,
10,
4),
(2,
10,
4),
(3,
10,
4),
(1,
10,
5),
(2,
10,
5),
(3,
10,
5),
(1,
10,
6),
(2,
10,
6),
(3,
10,
6),
(1,
10,
7),
(2,
10,
7),
(3,
10,
7),
(1,
10,
8),
(2,
10,
8),
(3,
10,
8),
(1,
10,
9),
(2,
10,
9),
(3,
10,
9);
