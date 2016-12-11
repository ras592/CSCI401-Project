/*
Gets product from the products table with the equivalent product id.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `get_product_by_id`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`get_product_by_id` (
    input_product_id INT(10)
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
        category_id FROM `FastrSale`.`products` WHERE id=input_product_id;
END$$

DELIMITER ;
