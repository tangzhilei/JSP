/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50155
Source Host           : localhost:3306
Source Database       : db_tzl

Target Server Type    : MYSQL
Target Server Version : 50155
File Encoding         : 65001

Date: 2020-07-11 13:56:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin', '8888@qq.com');
INSERT INTO `admin` VALUES ('2', 'tzl', '123', '888@qq.com');
INSERT INTO `admin` VALUES ('3', '13', '1', '8999@163.com');
INSERT INTO `admin` VALUES ('4', 'ttt', '3', '8999@163.com');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `aid` int(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `aid` (`aid`),
  CONSTRAINT `aid` FOREIGN KEY (`aid`) REFERENCES `admin` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('1', '1', '《岛上书屋》', '38.20', '1');
INSERT INTO `cart` VALUES ('2', '1', '三国杀', '57.60', '1');
INSERT INTO `cart` VALUES ('4', '4', '《岛上书屋》', '38.20', '1');
INSERT INTO `cart` VALUES ('5', '4', '三只松鼠减肥套装', '6.77', '1');
INSERT INTO `cart` VALUES ('6', '4', '三只松鼠减肥套装', '6.77', '1');
INSERT INTO `cart` VALUES ('7', '4', '三只松鼠减肥套装', '6.77', '1');
INSERT INTO `cart` VALUES ('8', '4', '三只松鼠减肥套装', '6.77', '1');
INSERT INTO `cart` VALUES ('9', '4', '三国杀', '57.60', '1');
INSERT INTO `cart` VALUES ('10', '4', '《第七天》', '26.70', '1');
INSERT INTO `cart` VALUES ('11', '4', '《黑天鹅》', '77.98', '1');
INSERT INTO `cart` VALUES ('12', '4', 'iPhone 11 pro max', '12345.99', '1');
INSERT INTO `cart` VALUES ('13', '4', '口罩', '5.60', '1');
INSERT INTO `cart` VALUES ('14', '4', '三只松鼠减肥套装', '6.77', '1');
INSERT INTO `cart` VALUES ('15', '4', '三只松鼠减肥套装', '6.77', '1');
INSERT INTO `cart` VALUES ('16', '4', '口罩', '5.60', '1');
INSERT INTO `cart` VALUES ('17', '4', '口罩', '5.60', '1');
INSERT INTO `cart` VALUES ('18', '4', '口罩', '5.60', '1');
INSERT INTO `cart` VALUES ('19', '4', '口罩', '5.60', '1');
INSERT INTO `cart` VALUES ('20', '4', '口罩', '5.60', '1');
INSERT INTO `cart` VALUES ('21', '4', '口罩', '5.60', '1');
INSERT INTO `cart` VALUES ('22', '4', '口罩', '5.60', '1');
INSERT INTO `cart` VALUES ('23', '4', '口罩', '5.60', '1');
INSERT INTO `cart` VALUES ('24', '3', '三只松鼠减肥套装', '6.77', '1');
INSERT INTO `cart` VALUES ('25', '3', '《岛上书屋》', '38.20', '1');
INSERT INTO `cart` VALUES ('27', '3', '《第七天》', '26.70', '1');
INSERT INTO `cart` VALUES ('32', '2', 'iPhone 11 pro max', '12345.99', '1');
INSERT INTO `cart` VALUES ('33', '2', 'iPhone 11 pro max', '12345.99', '1');
INSERT INTO `cart` VALUES ('34', '2', 'iPhone 11 pro max', '12345.99', '1');
INSERT INTO `cart` VALUES ('35', '2', 'iPhone 11 pro max', '12345.99', '1');
INSERT INTO `cart` VALUES ('36', '2', 'iPhone 11 pro max', '12345.99', '1');
INSERT INTO `cart` VALUES ('37', '2', 'iPhone 11 pro max', '12345.99', '1');
INSERT INTO `cart` VALUES ('38', '1', 'iPhone 11 pro max', '12345.99', '1');
INSERT INTO `cart` VALUES ('39', '1', '《黑天鹅》', '77.98', '1');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '三只松鼠减肥套装', '90', '6.77');
INSERT INTO `product` VALUES ('2', '《岛上书屋》', '995', '38.20');
INSERT INTO `product` VALUES ('3', '三国杀', '64', '57.60');
INSERT INTO `product` VALUES ('4', '《第七天》', '17786', '26.70');
INSERT INTO `product` VALUES ('5', '《黑天鹅》', '664', '77.98');
INSERT INTO `product` VALUES ('6', 'iPhone 11 pro max', '89', '12345.99');
INSERT INTO `product` VALUES ('7', '口罩', '999989', '5.60');
