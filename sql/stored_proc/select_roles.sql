/*
Selects everything from roles table.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `select_roles`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`select_roles` ()
BEGIN
    SELECT * FROM `FastrSale`.`roles`;
END$$

DELIMITER ;
