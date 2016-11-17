/* Creates users table */
/*
	Delimiter is set to $$ so that a semicolon can be
    used inside the body of the procedure.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `create_users`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`create_users` ()
BEGIN
	DROP TABLE IF EXISTS `FastrSale`.`users`;
    CREATE TABLE `FastrSale`.`users`(
		id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
        first_name VARCHAR(30) NOT NULL,
        last_name VARCHAR(30) NOT NULL,
        email VARCHAR(60) NOT NULL UNIQUE,
        password CHAR(40) NOT NULL,
        address VARCHAR(100) NOT NULL,
        city VARCHAR(35) NOT NULL,
        state VARCHAR(35) NOT NULL,
        zip VARCHAR(9) NOT NULL,
        country VARCHAR(70) NOT NULL,
        date_entered TIMESTAMP,
        role_id SMALLINT UNSIGNED NOT NULL, /*  DEFAULT 'User' won't work */
        FOREIGN KEY (role_id) REFERENCES `FastrSale`.`roles`(id),
        INDEX `users`(email)
	);
END$$

/* Change back to semicolon */
DELIMITER ;
