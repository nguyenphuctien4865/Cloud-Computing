DROP DATABASE IF EXISTS cloudcomputingdb;
CREATE database `cloudcomputingdb` ;

USE `cloudcomputingdb`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sinhvien
-- ----------------------------
DROP TABLE IF EXISTS `sinhvien`;
CREATE TABLE `sinhvien`(
`maSV` varchar(8) COLLATE utf8_general_ci  NOT NULL PRIMARY KEY ,
`hoTen` varchar(40) COLLATE utf8_general_ci  NOT NULL,
`ngaySinh` date NUll,
`maKhoa` INT(10) UNSIGNED NOT NULL,
`accountID` int UNSIGNED NOT NULL,
FOREIGN KEY (`maKhoa`) references `khoa`(`khoaID`),
FOREIGN KEY (`accountID`) references `account`(`accountID`),
UNIQUE KEY `accountID` (`accountID`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


-- ----------------------------
-- Table structure for khoa
-- ----------------------------
DROP TABLE IF EXISTS `khoa`;
CREATE TABLE `khoa`(
`khoaID` INT(10) UNSIGNED auto_increment PRIMARY KEY ,
`tenKhoa` varchar(40)  COLLATE utf8_general_ci NOT NULL
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


-- ----------------------------
-- Table structure for giangvien
-- ----------------------------
DROP TABLE IF EXISTS `giangvien`;
CREATE TABLE `giangvien`(
`maGV` varchar(8) COLLATE utf8_general_ci NOT NULL PRIMARY KEY ,
`hoTen` varchar(40) COLLATE utf8_general_ci NOT NULL,
`ngaySinh` date NUll,
`maKhoa` INT(10) UNSIGNED NOT NULL,
`loaiGV` varchar(40) COLLATE utf8_general_ci NULL,
FOREIGN KEY (`maKhoa`) references `khoa`(`khoaID`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`(
`accountID` INT UNSIGNED auto_increment PRIMARY KEY ,
`username` varchar(99) COLLATE utf8_general_ci NOT NULL,
`password` varchar(99) COLLATE utf8_general_ci NOT NULL,
`type` varchar(10)COLLATE utf8_general_ci NOT NULL,
unique KEY `ex_username`(`username`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


-- ----------------------------
-- Table structure for monhoc
-- ----------------------------
DROP TABLE IF EXISTS `monhoc`;
CREATE TABLE `monhoc`(
`maMH` varchar(10) COLLATE utf8_general_ci PRIMARY KEY ,
`tenMH` varchar(99) COLLATE utf8_general_ci NOT NULL,
`loai` varchar(20) COLLATE utf8_general_ci NOT NULL,
`soTC` int(10) unsigned NOT NULL,
`khoaID` INT(10) UNSIGNED NOT NULL,
FOREIGN KEY (`khoaID`) references `khoa`(`khoaID`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


-- ----------------------------
-- Table structure for lophocphan
-- ----------------------------
DROP TABLE IF EXISTS `lophocphan`;
CREATE TABLE `lophocphan`(
`id` int(10) unsigned auto_increment	 PRIMARY KEY ,
`maLop` varchar(99) COLLATE utf8_general_ci NOT NULL,
`loai` varchar(20) COLLATE utf8_general_ci NOT NULL,
`maMH` varchar(10) COLLATE utf8_general_ci NOT NULL,
`maGV` varchar(8) COLLATE utf8_general_ci NOT NULL,
`phong` varchar(10) COLLATE utf8_general_ci NOT NULL,
`soSV` int(10) unsigned NOT NULL default 0,
`ngayBD` date NOT NULL,
`namHoc` INT(10) NOT NULL,
`thu` int(10) NOT NULL default 0,
`tiet` varchar(10)  COLLATE utf8_general_ci NOT NULL,
FOREIGN KEY (`maMH`) references `monhoc`(`maMH`),
FOREIGN KEY (`maGV`) references `giangvien`(`maGV`),
UNIQUE KEY `ex_maLop`(`maLop`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


-- ----------------------------
-- Table structure for daymon
-- ----------------------------
DROP TABLE IF EXISTS `daymon`;
CREATE TABLE `daymon`(
`maMH` varchar(10) COLLATE utf8_general_ci NOT NULL,
`maGV` varchar(8) COLLATE utf8_general_ci NOT NULL,
CONSTRAINT `PK_daymon` PRIMARY KEY (`maMH`,`maGV`),
FOREIGN KEY (`maMH`) references `monhoc`(`maMH`),
FOREIGN KEY (`maGV`) references `giangvien`(`maGV`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


-- ----------------------------
-- Table structure for lopthamgia
-- ----------------------------
DROP TABLE IF EXISTS `lopthamgia`;
CREATE TABLE `lopthamgia`(
`maSV` varchar(8) COLLATE utf8_general_ci NOT NULL  ,
`lopID` int(10) unsigned NOT NULL ,
`diem` decimal(2,1) not null default 0,
CONSTRAINT `PK_lopthamgia` PRIMARY KEY (`maSV`,`lopID`),
FOREIGN KEY (`maSV`) references `sinhvien`(`maSV`),
FOREIGN KEY (`lopID`) references `lophocphan`(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;





