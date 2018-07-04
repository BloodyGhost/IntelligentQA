/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : sqsx

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-07-04 10:04:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sqsx_answer
-- ----------------------------
DROP TABLE IF EXISTS `sqsx_answer`;
CREATE TABLE `sqsx_answer` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `question_id` int(11) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `isdel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sqsx_answer
-- ----------------------------

-- ----------------------------
-- Table structure for sqsx_ask
-- ----------------------------
DROP TABLE IF EXISTS `sqsx_ask`;
CREATE TABLE `sqsx_ask` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `beat_answer_id` int(11) DEFAULT NULL,
  `close` varchar(255) DEFAULT NULL,
  `isdel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sqsx_ask
-- ----------------------------

-- ----------------------------
-- Table structure for sqsx_download
-- ----------------------------
DROP TABLE IF EXISTS `sqsx_download`;
CREATE TABLE `sqsx_download` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `file_id` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sqsx_download
-- ----------------------------

-- ----------------------------
-- Table structure for sqsx_file
-- ----------------------------
DROP TABLE IF EXISTS `sqsx_file`;
CREATE TABLE `sqsx_file` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `md5` varchar(255) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sqsx_file
-- ----------------------------

-- ----------------------------
-- Table structure for sqsx_file_label
-- ----------------------------
DROP TABLE IF EXISTS `sqsx_file_label`;
CREATE TABLE `sqsx_file_label` (
  `id` int(11) NOT NULL,
  `file_id` int(11) DEFAULT NULL,
  `label_id` int(11) DEFAULT NULL,
  `isdel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sqsx_file_label
-- ----------------------------

-- ----------------------------
-- Table structure for sqsx_like
-- ----------------------------
DROP TABLE IF EXISTS `sqsx_like`;
CREATE TABLE `sqsx_like` (
  `id` int(11) NOT NULL,
  `answer_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `isdel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sqsx_like
-- ----------------------------

-- ----------------------------
-- Table structure for sqsx_question
-- ----------------------------
DROP TABLE IF EXISTS `sqsx_question`;
CREATE TABLE `sqsx_question` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `describe` varchar(255) DEFAULT NULL,
  `isdel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sqsx_question
-- ----------------------------

-- ----------------------------
-- Table structure for sqsx_question_label
-- ----------------------------
DROP TABLE IF EXISTS `sqsx_question_label`;
CREATE TABLE `sqsx_question_label` (
  `id` int(11) NOT NULL,
  `question_id` int(11) DEFAULT NULL,
  `label_id` int(11) DEFAULT NULL,
  `isdel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sqsx_question_label
-- ----------------------------

-- ----------------------------
-- Table structure for sqsx_type
-- ----------------------------
DROP TABLE IF EXISTS `sqsx_type`;
CREATE TABLE `sqsx_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `isdel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sqsx_type
-- ----------------------------

-- ----------------------------
-- Table structure for sqsx_upload
-- ----------------------------
DROP TABLE IF EXISTS `sqsx_upload`;
CREATE TABLE `sqsx_upload` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `file_id` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `down_num` int(11) DEFAULT NULL,
  `isdel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sqsx_upload
-- ----------------------------

-- ----------------------------
-- Table structure for sqsx_user
-- ----------------------------
DROP TABLE IF EXISTS `sqsx_user`;
CREATE TABLE `sqsx_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `pasword` varchar(255) DEFAULT NULL,
  `isdel` int(10) unsigned zerofill NOT NULL DEFAULT '0000000000' COMMENT '0是正常1是禁用',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sqsx_user
-- ----------------------------
