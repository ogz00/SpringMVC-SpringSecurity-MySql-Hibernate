-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema springtest
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `springtest` ;

-- -----------------------------------------------------
-- Schema springtest
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `springtest` DEFAULT CHARACTER SET utf8 ;
USE `springtest` ;

-- -----------------------------------------------------
-- Table `springtest`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springtest`.`users` ;

CREATE TABLE IF NOT EXISTS `springtest`.`users` (
  `username` VARCHAR(60) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `enabled` TINYINT(1) NULL DEFAULT 1,
  `email` VARCHAR(60) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `authority` VARCHAR(45) NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `springtest`.`offers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springtest`.`offers` ;

CREATE TABLE IF NOT EXISTS `springtest`.`offers` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `text` TEXT NOT NULL,
  `username` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`, `username`),
  INDEX `fk_offers_users_idx` (`username` ASC),
  CONSTRAINT `fk_offers_users`
    FOREIGN KEY (`username`)
    REFERENCES `springtest`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `springtest`.`messages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springtest`.`messages` ;

CREATE TABLE IF NOT EXISTS `springtest`.`messages` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `subject` VARCHAR(150) NOT NULL,
  `content` VARCHAR(1000) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `username` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_messages_users1_idx` (`username` ASC),
  CONSTRAINT `fk_messages_users1`
    FOREIGN KEY (`username`)
    REFERENCES `springtest`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
