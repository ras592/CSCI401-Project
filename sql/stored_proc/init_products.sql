/*
Initializes the product table with fake data.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `init_products`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`init_products` ()
BEGIN
    INSERT INTO `FastrSale`.`products` (
        product_name,
        description,
        price,
        quantity,
        image_urls,
        store_id,
        category_id) VALUES (
            'RCA Universal Remote',
            'Rca Rcr503Br 3-Device Palm-Sized Universal Remote',
            6.56,
            2,
            'rca_remote.jpg|rca_remote2.jpg',
            (SELECT id FROM `FastrSale`.`stores` WHERE store_name='First Seller Store Name'),
            (SELECT id FROM `FastrSale`.`categories` WHERE category_name='Electronics')
    );
    INSERT INTO `FastrSale`.`products` (
        product_name,
        description,
        price,
        quantity,
        image_urls,
        store_id,
        category_id) VALUES (
            'ECHOGEAR Tilting Low Profile TV Wall Mount',
            'ECHOGEAR Tilting Low Profile TV Wall Mount Bracket for 32-70 inch TVs - Up to 15 Degrees of Tilt for LED, LCD, OLED and Plasma Flat Screen TVs with VESA patterns up to 600 x 400 - EGLT1-BK',
            34.99,
            0,
            'wall_mount.jpg|wall_mount2.jpg',
            (SELECT id FROM `FastrSale`.`stores` WHERE store_name='First Seller Store Name'),
            (SELECT id FROM `FastrSale`.`categories` WHERE category_name='Electronics')
    );
END$$

DELIMITER ;
