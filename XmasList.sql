-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema xmasListDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `xmasListDB` ;

-- -----------------------------------------------------
-- Schema xmasListDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `xmasListDB` DEFAULT CHARACTER SET utf8 ;
USE `xmasListDB` ;

-- -----------------------------------------------------
-- Table `xmasListObject`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `xmasListObject` ;

CREATE TABLE IF NOT EXISTS `xmasListObject` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `recipient` VARCHAR(45) NOT NULL,
  `giftItem` VARCHAR(45) NULL,
  `reason` VARCHAR(45) NULL,
  `cost` DECIMAL(4,2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO giver@localhost;
 DROP USER giver@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'giver'@'localhost' IDENTIFIED BY 'giver';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'giver'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `xmasListObject`
-- -----------------------------------------------------
START TRANSACTION;
USE `xmasListDB`;
INSERT INTO `xmasListObject` (`id`, `recipient`, `giftItem`, `reason`, `cost`) VALUES (1, 'James', 'Witten Jersey', 'Fan of America\'s Team cause he\'s an American...duh', 78.00);
INSERT INTO `xmasListObject` (`id`, `recipient`, `giftItem`, `reason`, `cost`) VALUES (2, 'Madeline', 'Cookbook', 'As a hint. And she DOES claim to like cooking--I\'d like proof.', 20.00);
INSERT INTO `xmasListObject` (`id`, `recipient`, `giftItem`, `reason`, `cost`) VALUES (3, 'Samantha', 'Pillow', 'To use as a booster seat so she can see over the steering wheel', 18.00);
INSERT INTO `xmasListObject` (`id`, `recipient`, `giftItem`, `reason`, `cost`) VALUES (4, 'Jonathan', 'Gaming computer', 'Just kidding! But maybe a game for his Switch...cause I don\'t want him to be too spoiled', 65.00);
INSERT INTO `xmasListObject` (`id`, `recipient`, `giftItem`, `reason`, `cost`) VALUES (5, 'Grandpa', 'Omaha Steaks', 'Cause he\'s got those new teeth, yo', 67.00);
INSERT INTO `xmasListObject` (`id`, `recipient`, `giftItem`, `reason`, `cost`) VALUES (6, 'Mom', 'Reading glasses', 'Cause she\'s gettin\' nerdy. And she\'s old AF.', 14.00);

COMMIT;
