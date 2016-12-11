/*
Inserts new entry to the categories table without an image.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `insert_category_no_image`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`insert_category_no_image` (
    category_name VARCHAR(60)
)
BEGIN
    INSERT INTO `FastrSale`.`categories` VALUES(
        null,
        category_name
    );
END$$

DELIMITER ;
