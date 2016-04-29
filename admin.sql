create database adminproyecto12;

CREATE TABLE `adminproyecto12`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `contra` VARCHAR(45) NOT NULL,
  `nocuenta` VARCHAR(20) NOT NULL,
  UNIQUE(`nocuenta`),
  PRIMARY KEY (`idusuario`));

CREATE TABLE `adminproyecto12`.`cuentasDisponibles` (
  `idcuentasDisponibles` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `tipo` INT NOT NULL,
  `subtipo` INT,
  `identificador` VARCHAR(45),
  UNIQUE(`nombre`),
  PRIMARY KEY (`idcuentasDisponibles`));

CREATE TABLE `adminproyecto12`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `contra` VARCHAR(45) NOT NULL,
  `nocuenta` VARCHAR(20) NOT NULL,
  UNIQUE(`nocuenta`),
  PRIMARY KEY (`idusuario`));

CREATE TABLE `adminproyecto12`.`registro` (
  `idregistro` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `idusuario` INT NOT NULL,
  PRIMARY KEY (`idregistro`),
  UNIQUE(`nombre`),
  INDEX `idusuario_idx` (`idusuario` ASC),
  CONSTRAINT `idusuario`
    FOREIGN KEY (`idusuario`)
    REFERENCES `adminproyecto12`.`usuario` (`idusuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `adminproyecto12`.`cuenta` (
  `idcuenta` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `tipo` INT NOT NULL,
  `idregistro` INT NOT NULL,
  `subtipo` INT,
  `identificador` VARCHAR(45),
  PRIMARY KEY (`idcuenta`),
  INDEX `idregistro_idx` (`idregistro` ASC),
  CONSTRAINT `idregistro`
    FOREIGN KEY (`idregistro`)
    REFERENCES `adminproyecto12`.`registro` (`idregistro`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `adminproyecto12`.`operacion` (
  `idoperacion` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NOT NULL,
  `tipo` INT NOT NULL,
  `idcuenta` INT NOT NULL,
  PRIMARY KEY (`idoperacion`),
  INDEX `idcuenta_idx` (`idcuenta` ASC),
  CONSTRAINT `idcuenta`
    FOREIGN KEY (`idcuenta`)
    REFERENCES `adminproyecto12`.`cuenta` (`idcuenta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

insert into usuario(nombre, correo, contra, nocuenta) values('Edgar', 'garo.edgar21@gmail.com', 'edgar21', '2014330415');
insert into registro(nombre, idusuario) value('Cocodrilo', 2);
insert into registro(nombre, idusuario) value('Cocodrilo2', 2);
insert into registro(nombre, idusuario) value('Cocodrilo3', 2);
insert into cuenta(nombre, tipo, idregistro, subtipo, identificador) values('banco', 1, 2, 1, 10);

