CREATE DATABASE `db_blog` DEFAULT CHARACTER SET utf8;

USE `db_blog`;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(64) DEFAULT NULL COMMENT '登录名',
  `nickname` varchar(64) DEFAULT NULL COMMENT '昵称',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `enabled` tinyint(1) DEFAULT '1' COMMENT '是否启用',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `userface` varchar(255) DEFAULT NULL COMMENT '头像',
  `regTime` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for roles_user
-- ----------------------------
DROP TABLE IF EXISTS `roles_user`;
CREATE TABLE `roles_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rid` int(11) DEFAULT '2' COMMENT '角色ID',
  `uid` int(11) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章ID',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `mdContent` text COMMENT 'md文件源码',
  `htmlContent` text COMMENT 'html源码',
  `summary` text COMMENT '摘要',
  `cid` int(11) DEFAULT NULL COMMENT '分类ID',
  `uid` int(11) DEFAULT NULL COMMENT '用户ID',
  `publishDate` datetime DEFAULT NULL COMMENT '发布时间',
  `editTime` datetime DEFAULT NULL COMMENT '编辑时间',
  `state` int(11) DEFAULT NULL COMMENT '状态：0-草稿箱 1-已发表 2-已删除',
  `pageView` int(11) DEFAULT '0' COMMENT '浏览量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `cateName` varchar(64) DEFAULT NULL COMMENT '分类名称',
  `date` date DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签ID',
  `tagName` varchar(32) DEFAULT NULL COMMENT '标签名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tagName` (`tagName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for article_tags
-- ----------------------------
DROP TABLE IF EXISTS `article_tags`;
CREATE TABLE `article_tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `aid` int(11) DEFAULT NULL COMMENT '文章ID',
  `tid` int(11) DEFAULT NULL COMMENT '标签ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pv
-- ----------------------------
DROP TABLE IF EXISTS `pv`;
CREATE TABLE `pv` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `countDate` date DEFAULT NULL COMMENT '统计日期',
  `pv` int(11) DEFAULT NULL COMMENT 'pv值',
  `uid` int(11) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_date_uid` (`countDate`,`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- View structure for pvview
-- ----------------------------
DROP VIEW IF EXISTS `pvview`;
CREATE VIEW `pvview` AS
SELECT SUM(pv) AS pv, uid FROM pv GROUP BY uid;

-- ----------------------------
-- View structure for totalpvview
-- ----------------------------
DROP VIEW IF EXISTS `totalpvview`;
CREATE VIEW `totalpvview` AS
SELECT SUM(pageView) AS totalPv, uid FROM article a GROUP BY uid;
