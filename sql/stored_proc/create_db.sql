/*
Creates database FastrSale
Kills all of the stored procedures?
*/
USE `FastrSale`;
DROP procedure IF EXISTS `create_db`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `create_db` ()
BEGIN
	DROP DATABASE IF EXISTS `FastrSale`;
    CREATE DATABASE `FastrSale`;
END$$

DELIMITER ;
