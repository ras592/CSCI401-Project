/*
Gets user from the user table with the equivalent email.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `get_user`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`get_user` (
    input_email VARCHAR(60)
)
BEGIN
    SELECT id,
        first_name,
        last_name,
        email,
        address,
        city,
        state,
        zip,
        country,
        role_id FROM `FastrSale`.`users` WHERE email=input_email;
END$$

DELIMITER ;
