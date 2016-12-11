/*
Inserts new entry to the categories table.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `insert_category`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`insert_category` (
    category_name VARCHAR(60),
    category_image TEXT
)
BEGIN
    INSERT INTO `FastrSale`.`categories` VALUES(
        null,
        category_name,
        category_image
    );
END$$

DELIMITER ;
