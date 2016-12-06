/* Creates stores table */
/*
	Delimiter is set to $$ so that a semicolon can be
    used inside the body of the procedure.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `create_stores`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`create_stores` ()
BEGIN
	DROP TABLE IF EXISTS `FastrSale`.`stores`;
    CREATE TABLE `FastrSale`.`stores`(
		id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
        store_name VARCHAR(70) NOT NULL,
		user_id INT UNSIGNED NOT NULL,
        FOREIGN KEY (user_id) REFERENCES `FastrSale`.`users`(id),
        INDEX `sellers`(store_name)
	);
END$$

/* Change back to semicolon */
DELIMITER ;
