/*
Gets store from the stores table with the equivalent store name.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `get_store`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`get_store` (
    input_store_name VARCHAR(60)
)
BEGIN
    SELECT id,
        store_name,
        user_id
        FROM `FastrSale`.`stores` WHERE store_name=input_store_name;
END$$

DELIMITER ;
