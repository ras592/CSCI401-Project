/* Creates categories table */
/*
	Delimiter is set to $$ so that a semicolon can be
    used inside the body of the procedure.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `create_categories`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`create_categories` ()
BEGIN
	DROP TABLE IF EXISTS `FastrSale`.`categories`;
    CREATE TABLE `FastrSale`.`categories`(
		id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
        category_name VARCHAR(70) NOT NULL,
        category_image TEXT,
        INDEX `categories`(category_name)
	);
END$$

/* Change back to semicolon */
DELIMITER ;
