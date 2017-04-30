/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : ccy

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-04-30 20:58:49
*/
use ccy;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for collecteddata1
-- ----------------------------
DROP TABLE IF EXISTS `collecteddata1`;
CREATE TABLE `collecteddata1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `p1_1` double DEFAULT NULL,
  `p1_2` double DEFAULT NULL,
  `p1_3` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collecteddata1
-- ----------------------------
INSERT INTO `collecteddata1` VALUES ('1', '2017-04-23 16:39:48', '1', '21', '31');
INSERT INTO `collecteddata1` VALUES ('2', '2017-04-23 16:39:49', '2', '22', '32');
INSERT INTO `collecteddata1` VALUES ('3', '2017-04-23 16:39:50', '3', '23', '33');
INSERT INTO `collecteddata1` VALUES ('4', '2017-04-23 16:39:50', '4', '24', '34');
INSERT INTO `collecteddata1` VALUES ('5', '2017-04-23 16:39:51', '5', '25', '35');
INSERT INTO `collecteddata1` VALUES ('6', '2017-04-23 16:39:52', '6', '26', '36');
INSERT INTO `collecteddata1` VALUES ('7', '2017-04-23 16:39:53', '7', '27', '37');
INSERT INTO `collecteddata1` VALUES ('8', '2017-04-23 16:39:53', '8', '28', '38');
INSERT INTO `collecteddata1` VALUES ('9', '2017-04-23 16:39:55', '9', '29', '39');

-- ----------------------------
-- Table structure for collector
-- ----------------------------
DROP TABLE IF EXISTS `collector`;
CREATE TABLE `collector` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deviceId` int(11) NOT NULL,
  `collectorNo` varchar(10) NOT NULL,
  `collectorState` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collector
-- ----------------------------
INSERT INTO `collector` VALUES ('1', '1', '1', '正常');
INSERT INTO `collector` VALUES ('2', '1', '2', '正常');
INSERT INTO `collector` VALUES ('4', '1', '111111', '正常');
INSERT INTO `collector` VALUES ('5', '1', '111111', '姝ｅ父');

-- ----------------------------
-- Table structure for collector_parameter
-- ----------------------------
DROP TABLE IF EXISTS `collector_parameter`;
CREATE TABLE `collector_parameter` (
  `deviceId` int(11) NOT NULL,
  `subsystemId` int(11) NOT NULL,
  `parameterId` int(11) NOT NULL,
  `collectorId` int(11) NOT NULL,
  `parameterIndex` int(11) NOT NULL,
  PRIMARY KEY (`subsystemId`,`parameterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collector_parameter
-- ----------------------------
INSERT INTO `collector_parameter` VALUES ('1', '1', '1', '1', '5');
INSERT INTO `collector_parameter` VALUES ('1', '1', '2', '1', '1');
INSERT INTO `collector_parameter` VALUES ('1', '1', '3', '1', '2');
INSERT INTO `collector_parameter` VALUES ('1', '2', '1', '1', '3');
INSERT INTO `collector_parameter` VALUES ('1', '2', '3', '1', '4');

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `companyName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `companyAddress` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `contactPersonName` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contactPhoneNumber` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contacteEMail` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '深研所', '成都市', null, null, null);

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) NOT NULL,
  `deviceNo` varchar(20) NOT NULL,
  `deviceName` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('1', '1', '1', '纯净水制备系统');
INSERT INTO `device` VALUES ('2', '1', '2', '纯净水制备系统');
INSERT INTO `device` VALUES ('3', '1', '3', '纯净水制备系统');
INSERT INTO `device` VALUES ('4', '1', '4', '纯净水制备系统');
INSERT INTO `device` VALUES ('5', '1', '5', '纯净水制备系统');
INSERT INTO `device` VALUES ('6', '1', '6', '纯净水制备系统');

-- ----------------------------
-- Table structure for parameter
-- ----------------------------
DROP TABLE IF EXISTS `parameter`;
CREATE TABLE `parameter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) NOT NULL,
  `sensorNo` varchar(20) DEFAULT NULL,
  `sensorName` varchar(20) DEFAULT NULL,
  `parameterNo` varchar(20) NOT NULL,
  `parameterName` varchar(20) NOT NULL,
  `upper` double DEFAULT NULL,
  `lower` double DEFAULT NULL,
  `suffix` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parameter
-- ----------------------------
INSERT INTO `parameter` VALUES ('1', '1', null, '1', '1', 'RO膜PH值', '7', '5', null);
INSERT INTO `parameter` VALUES ('2', '1', null, '2', '2', 'RO膜出水电导', '25', null, null);
INSERT INTO `parameter` VALUES ('3', '1', null, '3', '3', 'EDI出水电导', '4.3', null, null);
INSERT INTO `parameter` VALUES ('4', '1', null, '4', '4', '回水流量', null, '1', 't/h');
INSERT INTO `parameter` VALUES ('5', '1', null, '5', '5', '储水罐温度', null, null, '℃');
INSERT INTO `parameter` VALUES ('6', '1', null, '6', '6', '回水温度', null, null, '℃');
INSERT INTO `parameter` VALUES ('8', '1', '777', '温度传感器', '99999', '回水温度', '100', '30', '℃');

-- ----------------------------
-- Table structure for subsystem
-- ----------------------------
DROP TABLE IF EXISTS `subsystem`;
CREATE TABLE `subsystem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deviceId` int(11) NOT NULL,
  `subsystemNo` varchar(20) NOT NULL,
  `subsystemName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subsystem
-- ----------------------------
INSERT INTO `subsystem` VALUES ('1', '1', '纯化水制备系统', '纯化水制备系统');
INSERT INTO `subsystem` VALUES ('2', '1', '疫苗间纯化水（PW）分配系统', '疫苗间纯化水（PW）分配系统');
INSERT INTO `subsystem` VALUES ('3', '1', '疫苗间注射用水（WFI）分配系统', '疫苗间注射用水（WFI）分配系统');
INSERT INTO `subsystem` VALUES ('4', '1', '诊断间纯化水（PW）分配系统', '诊断间纯化水（PW）分配系统');
INSERT INTO `subsystem` VALUES ('5', '1', '诊断间注射用水（WFI）分配系统', '诊断间注射用水（WFI）分配系统');
INSERT INTO `subsystem` VALUES ('10', '1', '111111111', '111111111');
INSERT INTO `subsystem` VALUES ('11', '1', '111111111', '111111111');

-- ----------------------------
-- Table structure for subsystem_parameter
-- ----------------------------
DROP TABLE IF EXISTS `subsystem_parameter`;
CREATE TABLE `subsystem_parameter` (
  `subsystemId` int(11) NOT NULL,
  `parameterId` int(11) NOT NULL,
  PRIMARY KEY (`subsystemId`,`parameterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subsystem_parameter
-- ----------------------------
INSERT INTO `subsystem_parameter` VALUES ('1', '1');
INSERT INTO `subsystem_parameter` VALUES ('1', '2');
INSERT INTO `subsystem_parameter` VALUES ('1', '3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(10) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', 'f29d816ab8f74447aa483e4e67fcbd4b');
