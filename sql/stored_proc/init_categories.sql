/*
Initializes the categories table with fake data.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `init_categories`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`init_categories` ()
BEGIN
    INSERT INTO `FastrSale`.`categories` VALUES (
        null, 'Electronics', null
    );
    INSERT INTO `FastrSale`.`categories` VALUES (
        null, 'Kitchen', null
    );
    INSERT INTO `FastrSale`.`categories` VALUES (
        null, 'Furniture', null
    );
    INSERT INTO `FastrSale`.`categories` VALUES (
        null, 'Toys', null
    );
END$$

DELIMITER ;
