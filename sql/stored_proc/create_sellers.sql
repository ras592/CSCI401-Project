/* Creates sellers table */
/*
	Delimiter is set to $$ so that a semicolon can be
    used inside the body of the procedure.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `create_sellers`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`create_sellers` ()
BEGIN
	DROP TABLE IF EXISTS `FastrSale`.`sellers`;
    CREATE TABLE `FastrSale`.`sellers`(
		id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(70) NOT NULL,
        FOREIGN KEY (user_id) REFERENCES `FastrSale`.`users`(id),
        INDEX `sellers`(name)
	);
END$$

/* Change back to semicolon */
DELIMITER ;
