/* Creates products table */
/*
	Delimiter is set to $$ so that a semicolon can be
    used inside the body of the procedure.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `create_products`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`create_products` ()
BEGIN
	DROP TABLE IF EXISTS `FastrSale`.`products`;
    CREATE TABLE `FastrSale`.`products`(
		id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
        product_name VARCHAR(70) NOT NULL,
        product_price FLOAT() NOT NULL,
        product_quantity INT() NOT NULL,
        date_entered TIMESTAMP,
        seller_id SMALLINT UNSIGNED NOT NULL,
        category_id SMALLINT UNSIGNED NOT NULL,
        FOREIGN KEY (seller_id) REFERENCES `FastrSale`.`sellers`(id),
        FOREIGN KEY (category_id) REFERENCES `FastrSale`.`categories`(id),
        INDEX `products`(product_name)
	);
END$$

/* Change back to semicolon */
DELIMITER ;
