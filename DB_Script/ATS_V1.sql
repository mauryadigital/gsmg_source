-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ats
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ats
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ats` DEFAULT CHARACTER SET utf8 ;
USE `ats` ;

-- -----------------------------------------------------
-- Table `ats`.`authorities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ats`.`authorities` (
  `authority` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ats`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ats`.`department` (
  `departmentName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`departmentName`),
  UNIQUE INDEX `departmentName_UNIQUE` (`departmentName` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ats`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ats`.`roles` (
  `roleTypes` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`roleTypes`),
  UNIQUE INDEX `roleTypes_UNIQUE` (`roleTypes` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ats`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ats`.`user` (
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `emailId` VARCHAR(45) NOT NULL,
  `contact` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`emailId`),
  UNIQUE INDEX `contact_UNIQUE` (`contact` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ats`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ats`.`user_role` (
  `roleTypes` VARCHAR(45) NOT NULL,
  `emailId` VARCHAR(45) NOT NULL,
  `departmentName` VARCHAR(45) NOT NULL,
  INDEX `fk_userRole_department1_idx` (`departmentName` ASC),
  INDEX `fk_userRole_roles1` (`roleTypes` ASC),
  INDEX `fk_userRole_user1` (`emailId` ASC),
  CONSTRAINT `fk_userRole_department1`
    FOREIGN KEY (`departmentName`)
    REFERENCES `ats`.`department` (`departmentName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_userRole_roles1`
    FOREIGN KEY (`roleTypes`)
    REFERENCES `ats`.`roles` (`roleTypes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_userRole_user1`
    FOREIGN KEY (`emailId`)
    REFERENCES `ats`.`user` (`emailId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ats`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ats`.`users` (
  `username` VARCHAR(60) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `enabled` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`username`),
  UNIQUE INDEX `uEmail_UNIQUE` (`username` ASC),
  CONSTRAINT `fk_login_user`
    FOREIGN KEY (`username`)
    REFERENCES `ats`.`user` (`emailId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
