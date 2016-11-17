/* Creates users table */
/*
	Delimiter is set to $$ so that a semicolon can be
    used inside the body of the procedure.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `create_roles`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `create_roles` ()
BEGIN
	DROP TABLE IF EXISTS `FastrSale`.`roles`;
    CREATE TABLE `FastrSale`.`roles`(
		id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
        name ENUM('User', 'Seller', 'Admin') NOT NULL UNIQUE,
        INDEX `roles`(name)
	);
END$$

/* Change back to semicolon */
DELIMITER ;
