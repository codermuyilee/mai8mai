/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50160
Source Host           : localhost:3306
Source Database       : mai8mai

Target Server Type    : MYSQL
Target Server Version : 50160
File Encoding         : 65001

Date: 2016-01-12 12:05:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `detail` varchar(1000) DEFAULT NULL,
  `detail_url` varchar(255) DEFAULT NULL,
  `goto_buy_url` varchar(1000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `source_num` int(11) DEFAULT NULL,
  `sync_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8;