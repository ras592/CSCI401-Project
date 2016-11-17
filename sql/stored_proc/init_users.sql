/*
Initializes the user table with fake data.
*/
USE `FastrSale`;
DROP procedure IF EXISTS `init_users`;

DELIMITER $$
USE `FastrSale`$$
CREATE PROCEDURE `FastrSale`.`init_users` ()
BEGIN
    INSERT INTO `FastrSale`.`users` VALUES(
        null,
        'first1',
        'last1',
        'example1@email.com',
        SHA('pass1'),
        '1 Main Street',
        'Anytown',
        'Any State',
        '11111',
        'USA',
        NOW(),
        1
    );
    INSERT INTO `FastrSale`.`users` VALUES(
        null,
        'first2',
        'last2',
        'example2@email.com',
        SHA('pass2'),
        '1 Main Street',
        'Anytown',
        'Any State',
        '11111',
        'USA',
        NOW(),
        1
    );
    INSERT INTO `FastrSale`.`users` VALUES(
        null,
        'first3',
        'last3',
        'example3@email.com',
        SHA('pass3'),
        '1 Main Street',
        'Anytown',
        'Any State',
        '11111',
        'USA',
        NOW(),
        1
    );
    INSERT INTO `FastrSale`.`users` VALUES(
        null,
        'firstSeller',
        'lastSeller',
        'exampleSeller@email.com',
        SHA('passSeller'),
        '1 Main Street',
        'Anytown',
        'Any State',
        '11111',
        'USA',
        NOW(),
        2
    );
    INSERT INTO `FastrSale`.`users` VALUES(
        null,
        'firstAdmin',
        'lastAdmin',
        'exampleAdmin@email.com',
        SHA('passAdmin'),
        '1 Main Street',
        'Anytown',
        'Any State',
        '11111',
        'USA',
        NOW(),
        3
    );
END$$

DELIMITER ;
