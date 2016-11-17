/*
Selects everything from roles table.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `select_users`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`select_users` ()
BEGIN
    SELECT * FROM `FastrSale`.`users`;
END$$

DELIMITER ;
