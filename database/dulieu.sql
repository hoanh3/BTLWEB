use btl;

INSERT INTO `btl`.`role`
(`name`)
VALUES
('ADMIN'),
('USER');

INSERT INTO `btl`.`category`
(`title`)
VALUES
('T-SHIRT'),
('SHIRTS');

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

 MATERIAL: PREMIUM COTTON.', '2023-04-12 18:00:00', '2023-04-12 18:00:00', 1);