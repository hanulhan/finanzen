
CREATE TABLE `bank` (
   `ID` bigint(20) NOT NULL AUTO_INCREMENT,
   `Name` varchar(50) DEFAULT NULL,
   `BIC`  varchar(50) DEFAULT NULL,
   
PRIMARY KEY (`ID`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `bank` (`Name`,`BIC`) values ('Postbank','PBNKDEFF');
insert  into `bank` (Name,BIC) values ('PSD Köln','GENODEF1P13');
insert  into `bank` (`Name`,`BIC`) values ('ING-DiBa','INGDDEFFXXX');


CREATE TABLE `account` (
   `ID` bigint(20) NOT NULL AUTO_INCREMENT,
   `Name`  varchar(128) DEFAULT NULL,
   `Type`  varchar(128) DEFAULT NULL,
   `IBAN`  varchar(50) DEFAULT NULL,
   `idParent` bigint(20) DEFAULT NULL,
   `description` varchar(1024) DEFAULT NULL,
   `Placeholder` tinyint(4) DEFAULT '0',
   `idBank` bigint(20) DEFAULT NULL,
   PRIMARY KEY (`ID`),
   UNIQUE KEY `FK_NamePerParent` (`Name`,`idParent`),
   CONSTRAINT `FK_bank` FOREIGN KEY (`idBank`) REFERENCES `bank` (`ID`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `account` (`Name`, `Type`, `description`) values ('Root Account', 'ROOT', 'Root Account');
insert into `account` (`Name`, `Type`, `idParent`, `description`) values ('Aktiva', 'ASSET', '1', 'Aktiva');
insert into `account` (`Name`, `Type`, `idParent`, `description`) values ('Aufwendungen', 'EXPENSE', '1', 'Aufwendungen');
insert into `account` (`Name`, `Type`, `idParent`, `description`) values ('Erträge', 'INCOME', '1', 'Einkommen');
insert into `account` (`Name`, `Type`, `idParent`, `description`) values ('Passiva', 'ROOT', 'Root Account');
