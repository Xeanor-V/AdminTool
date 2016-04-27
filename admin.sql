create database adminproyecto;

CREATE TABLE `adminproyecto`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `contra` VARCHAR(45) NOT NULL,
  `nocuenta` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idusuario`));

CREATE TABLE `adminproyecto`.`registro` (
  `idregistro` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `idusuario` INT NOT NULL,
  PRIMARY KEY (`idregistro`),
  INDEX `idusuario_idx` (`idusuario` ASC),
  CONSTRAINT `idusuario`
    FOREIGN KEY (`idusuario`)
    REFERENCES `adminproyecto`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `adminproyecto`.`cuenta` (
  `idcuenta` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `tipo` INT NOT NULL,
  `idregistro` INT NOT NULL,
  PRIMARY KEY (`idcuenta`),
  INDEX `idregistro_idx` (`idregistro` ASC),
  CONSTRAINT `idregistro`
    FOREIGN KEY (`idregistro`)
    REFERENCES `adminproyecto`.`registro` (`idregistro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `adminproyecto`.`operacion` (
  `idoperacion` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `cantidad` INT NOT NULL,
  `tipo` INT NOT NULL,
  `idcuenta` INT NOT NULL,
  PRIMARY KEY (`idoperacion`),
  INDEX `idcuenta_idx` (`idcuenta` ASC),
  CONSTRAINT `idcuenta`
    FOREIGN KEY (`idcuenta`)
    REFERENCES `adminproyecto`.`cuenta` (`idcuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
