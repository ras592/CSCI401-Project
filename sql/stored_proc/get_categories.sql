/*
Gets all categories from the categories table with the equivalent category name.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `get_categories`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`get_categories` ()
BEGIN
    SELECT id,
        category_name,
        category_image
        FROM `FastrSale`.`categories`;
END$$

DELIMITER ;
