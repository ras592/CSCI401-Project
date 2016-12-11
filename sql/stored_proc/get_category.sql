/*
Gets category from the categories table with the equivalent category name.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `get_category`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`get_category` (
    input_category_name VARCHAR(60)
)
BEGIN
    SELECT id,
        category_name,
        category_image
        FROM `FastrSale`.`categories` WHERE category_name=input_category_name;
END$$

DELIMITER ;
