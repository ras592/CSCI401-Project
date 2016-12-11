/*
Gets product from the products table with the equivalent store id.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `get_products_by_store`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`get_products_by_store` (
    input_store_id INT(10)
)
BEGIN
    SELECT id,
        product_name,
        description,
        price,
        quantity,
        date_entered,
        image_urls,
        store_id,
        category_id FROM `FastrSale`.`products` WHERE store_id=input_store_id;
END$$

DELIMITER ;
