/*
Inserts new entry to the user table.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `insert_users`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`insert_users` (
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    email VARCHAR(60),
    pass  VARCHAR(60),
    address VARCHAR(100),
    city VARCHAR(35),
    state VARCHAR(35),
    zip VARCHAR(9),
    country VARCHAR(70),
    role SMALLINT(5)
)
BEGIN
    INSERT INTO `FastrSale`.`users` VALUES(
        null,
        first_name,
        last_name,
        email,
        SHA(pass),
        address,
        city,
        state,
        zip,
        country,
        NOW(),
        role
    );
END$$

DELIMITER ;
