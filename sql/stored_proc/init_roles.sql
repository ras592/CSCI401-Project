/*
Initializes the roles table with data.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `init_roles`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`init_roles` ()
BEGIN
    INSERT INTO `FastrSale`.`roles` VALUES(
        null,
        'User'
    );
    INSERT INTO `FastrSale`.`roles` VALUES(
        null,
        'Seller'
    );
    INSERT INTO `FastrSale`.`roles` VALUES(
        null,
        'Admin'
    );
END$$

DELIMITER ;
