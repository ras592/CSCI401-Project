/* Creates carts table */
/*
	Delimiter is set to $$ so that a semicolon can be
    used inside the body of the procedure.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `create_carts`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`create_carts` ()
BEGIN
	DROP TABLE IF EXISTS `FastrSale`.`carts`;
    CREATE TABLE `FastrSale`.`carts`(
        id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
        user_id INT UNSIGNED NOT NULL,
        product_id INT UNSIGNED NOT NULL,
        FOREIGN KEY (user_id) REFERENCES `FastrSale`.`users`(id),
        FOREIGN KEY (product_id) REFERENCES `FastrSale`.`products`(id)
	);
END$$

/* Change back to semicolon */
DELIMITER ;
