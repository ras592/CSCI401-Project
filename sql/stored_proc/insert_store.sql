/*
Inserts new entry to the store table.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `insert_store`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`insert_store` (
    store_name VARCHAR(60),
    user_id INT(10)

)
BEGIN
    INSERT INTO `FastrSale`.`stores` VALUES(
        null,
        store_name,
        user_id
    );
END$$

DELIMITER ;
