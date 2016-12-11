/*
Inserts new entry to the products table.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `insert_product`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`insert_product` (
    product_name VARCHAR(100),
    description TEXT,
    price FLOAT,
    quantity INT,
    image_urls TIMESTAMP,
    store_id INT(10),
    user_id INT(10)

)
BEGIN
    INSERT INTO `FastrSale`.`products` VALUES(
        null,
        product_name,
        description,
        price,
        quantity,
        NOW(),
        image_urls,
        store_id,
        user_id
    );
END$$

DELIMITER ;
