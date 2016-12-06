/*
Checks if store name already exists.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `validate_store_name`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`validate_store_name` (
    input_store_name VARCHAR(60)
)
BEGIN
    SELECT COUNT(*) FROM `FastrSale`.`stores` WHERE store_name=input_store_name;
END$$

DELIMITER ;
