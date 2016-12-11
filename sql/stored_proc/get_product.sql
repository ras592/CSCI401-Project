/*
Gets product from the products table with the equivalent product name and store id.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `get_product`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`get_product` (
    input_product_name VARCHAR(60),
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
        category_id FROM `FastrSale`.`products` WHERE product_name=input_product_name AND store_id=input_store_id;
END$$

DELIMITER ;
