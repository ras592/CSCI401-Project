/*
Checks if email and password are valid.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `validate_user`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`validate_user` (
    input_email VARCHAR(60),
    pass VARCHAR(60)
)
BEGIN
    SELECT COUNT(*) FROM `FastrSale`.`users` WHERE email=input_email AND password=SHA(pass);
END$$

DELIMITER ;
