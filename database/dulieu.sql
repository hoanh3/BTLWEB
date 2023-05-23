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
('WORLD MAP T-SHIRT/RED', 5.0, 420000, 59000, 'https://res.cloudinary.com/dasj31isc/image/upload/v1684598425/product/worldmap_mt3wdt.webp', '• Thông tin sản phẩm:

 WORLD MAP T-SHIRT

 HOẠ TIẾT: IN LỤA U.S.A INK

 COLOR: BLACK / WHITE / DARK GREEN / DARK BROW / DARK GREY / RED

 SIZE: M / L / XL

 MATERIAL: PREMIUM COTTON.', '2023-04-12 18:00:00', '2023-04-12 18:00:00', 1),
 ('SWEATER SWEATER/YELLOW', 5.0, 560000, 159000, 'https://res.cloudinary.com/dasj31isc/image/upload/v1684598454/product/sweater1_zipgz8.webp', '• Thông tin sản phẩm:

 SWEATER SWEATER/YELLOW

 HOẠ TIẾT: IN LỤA U.S.A INK

 COLOR: BLACK / WHITE / DARK GREEN / DARK BROW / DARK GREY / RED

 SIZE: M / L / XL

 MATERIAL: PREMIUM COTTON.', '2023-04-15 18:00:00', '2023-04-15 18:00:00', 3),
 ('IDENTIFY T-SHIRT/RED', 5.0, 420000, 59000, 'https://res.cloudinary.com/dasj31isc/image/upload/v1684598453/product/identity_ghq51n.webp', '• Thông tin sản phẩm:

 IDENTIFY T-SHIRT

 HOẠ TIẾT: IN LỤA U.S.A INK

 COLOR: BLACK / WHITE / DARK GREEN / DARK BROW / DARK GREY / RED

 SIZE: M / L / XL

 MATERIAL: PREMIUM COTTON.', '2023-04-15 18:00:00', '2023-04-15 18:00:00', 1),
 ('FLOAT ICONS T-SHIRT/DARK BROW', 5.0, 420000, 59000, 'https://res.cloudinary.com/dasj31isc/image/upload/v1684598454/product/float_vgpfmm.webp', '• Thông tin sản phẩm:

 FLOAT ICONS T-SHIRT

 HOẠ TIẾT: IN LỤA U.S.A INK

 COLOR: BLACK / WHITE / DARK GREEN / DARK BROW / DARK GREY / DARK RED

 SIZE: M / L / XL

 MATERIAL: PREMIUM COTTON.', '2023-04-15 18:00:00', '2023-04-15 18:00:00', 1),
 ('SWEATER SWEATER BEAR/GREY', 5.0, 560000, 189000, 'https://res.cloudinary.com/dasj31isc/image/upload/v1684598455/product/sweater2_pqcuez.webp', '• Thông tin sản phẩm:

 SWEATER SWEATER BEAR/GREY

 HOẠ TIẾT: IN LỤA U.S.A INK

 COLOR: BLACK / WHITE / DARK GREEN / DARK BROW / DARK GREY / RED

 SIZE: M / L / XL

 MATERIAL: PREMIUM COTTON.', '2023-04-15 18:00:00', '2023-04-15 18:00:00', 3),
 ('POLO POLO BASIC/GREY', 5.0, 360000, 129000, 'https://res.cloudinary.com/dasj31isc/image/upload/v1684598455/product/polo1_ftzogf.webp', '• Thông tin sản phẩm:

 POLO POLO BASIC/GREY

 HOẠ TIẾT: IN LỤA U.S.A INK

 COLOR: BLACK / WHITE / DARK GREEN / DARK BROW / DARK GREY / RED

 SIZE: M / L / XL

 MATERIAL: PREMIUM COTTON.', '2023-04-15 18:00:00', '2023-04-15 18:00:00', 4),
 ('POLO POLO BLACKWHITE/BLACK', 5.0, 360000, 149000, 'https://res.cloudinary.com/dasj31isc/image/upload/v1684598453/product/polo2_fee0ac.jpg', '• Thông tin sản phẩm:

 POLO POLO BLACKWHITE/BLACK

 HOẠ TIẾT: IN LỤA U.S.A INK

 COLOR: BLACK / WHITE / DARK GREEN / DARK BROW / DARK GREY / RED

 SIZE: M / L / XL

 MATERIAL: PREMIUM COTTON.', '2023-04-15 18:00:00', '2023-04-15 18:00:00', 4),
 ('SHIRT SHIRT BASIC/BLUE', 5.0, 360000, 249000, 'https://res.cloudinary.com/dasj31isc/image/upload/v1684598454/product/shirt1_e2h53v.webp', '• Thông tin sản phẩm:

 SHIRT SHIRT BASIC/BLUE

 HOẠ TIẾT: IN LỤA U.S.A INK

 COLOR: BLACK / WHITE / DARK GREEN / DARK BROW / DARK GREY / RED

 SIZE: M / L / XL

 MATERIAL: PREMIUM COTTON.', '2023-04-15 18:00:00', '2023-04-15 18:00:00', 2),
 ('SHIRT SHIRT CARO/DIOR', 5.0, 380000, 249000, 'https://res.cloudinary.com/dasj31isc/image/upload/v1684598455/product/shirt2_u8so06.jpg', '• Thông tin sản phẩm:

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
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598485/product/galery1_yqmd0h.webp'),
(
1,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598485/product/galery2_cg3yjy.webp'),
(
1,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598485/product/galery3_nsd7ur.webp'),
(
1,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598486/product/galery4_lclg96.webp'),
(
1,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598486/product/galery5_lbrbez.webp'),
(
2,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598486/product/galery6_dlojat.webp'),
(
2,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598486/product/galery7_ubstg7.webp'),
(
2,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598486/product/galery8_f79wmo.webp'),
(
2,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598486/product/galery9_mevyrl.webp'),
(
2,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598486/product/galery10_det4mo.webp'),
(
3,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598486/product/galery11_ueq36p.webp'),
(
3,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598481/product/galery12_v65u9k.webp'),
(
3,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598481/product/galery13_h1y19t.webp'),
(
3,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598481/product/galery14_lh30xm.webp'),
(
3,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598481/product/galery15_wpqown.webp'),
(
4,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598482/product/galery16_b8fvrk.webp'),
(
4,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598481/product/galery17_fffemz.jpg'),
(
4,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598482/product/galery18_ug7w9z.jpg'),
(
4,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598482/product/galery19_kmedbg.jpg'),
(
4,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598482/product/galery20_qyeaai.jpg'),
(
5,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598482/product/galery21_pcyz71.jpg'),
(
5,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598482/product/galery22_clk4ba.jpg'),
(
5,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598482/product/galery23_m6wnte.jpg'),
(
5,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598483/product/galery24_mdspsw.jpg'),
(
5,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598482/product/galery25_smq3fg.jpg'),
(
6,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598483/product/galery26_lq2gfo.jpg'),
(
6,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598483/product/galery27_wbh7yo.jpg'),
(
6,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598483/product/galery28_eqx8ub.jpg'),
(
6,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598483/product/galery29_iq0sxr.jpg'),
(
6,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598483/product/galery30_iwrkle.jpg'),
(
7,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598483/product/galery31_ojtkrl.jpg'),
(
7,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598483/product/galery32_onj5gm.jpg'),
(
7,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598484/product/galery33_yrquvr.jpg'),
(
7,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598484/product/galery34_l9xfcy.jpg'),
(
7,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598484/product/galery35_kjbqmo.jpg'),
(
8,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598484/product/galery36_eeqs29.jpg'),
(
8,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598484/product/galery37_g6buby.jpg'),
(
8,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598484/product/galery38_cwtd0c.jpg'),
(
8,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598484/product/galery39_nz5rx6.jpg'),
(
8,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598484/product/galery40_a9l8g3.jpg'),
(
9,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598484/product/galery41_qkz6pi.jpg'),
(
9,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598484/product/galery42_xgrzfh.jpg'),
(
9,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598485/product/galery43_uln116.jpg'),
(
9,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598485/product/galery44_itrpcu.jpg'),
(
9,
'https://res.cloudinary.com/dasj31isc/image/upload/v1684598485/product/galery45_k5x4l4.jpg');

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
