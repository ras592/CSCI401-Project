/*
Initializes the stores table with fake data.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `init_stores`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`init_stores` ()
BEGIN
    INSERT INTO `FastrSale`.`stores` (store_name, user_id) VALUES(
        'First Seller Store Name',
        (SELECT id FROM `FastrSale`.`users` WHERE email='exampleSeller@email.com')
    );
END$$

DELIMITER ;
