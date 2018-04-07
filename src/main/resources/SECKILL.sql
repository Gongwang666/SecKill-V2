/*
 Navicat Premium Data Transfer

 Source Server         : gw
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost
 Source Database       : sec_kill

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : utf-8

 Date: 04/07/2018 17:24:37 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `GOODS_SN` varchar(160) NOT NULL COMMENT '商品编号',
  `GOODS_NAME` varchar(50) NOT NULL COMMENT '商品名称',
  `GOODS_IMG` varchar(150) DEFAULT NULL COMMENT '商品图片',
  `MARKET_PRICE` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '市场价',
  `SHOP_PRICE` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '门店价',
  `WARN_STOCK` int(11) NOT NULL DEFAULT '0' COMMENT '预警库存',
  `GOODS_STOCK` int(11) NOT NULL DEFAULT '0' COMMENT '商品总库存',
  `GOODS_TIPS` text COMMENT '促销信息',
  `IS_SALE` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否上架   0:不上架 1:上架',
  `IS_BEST` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否精品   0:否 1:是',
  `IS_HOT` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否热销产品   0:否 1:是',
  `IS_NEW` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否新品   0:否 1:是',
  `GOODS_CAT_ID_PATH` varchar(255) DEFAULT NULL COMMENT '商品分类ID路径   catId1_catId2_catId3',
  `GOODS_CAT_ID` int(11) NOT NULL COMMENT '最后一级商品分类ID',
  `GOODS_DESC` text NOT NULL COMMENT '商品描述',
  `SALE_NUM` int(11) NOT NULL DEFAULT '0' COMMENT '总销售量',
  `SALE_TIME` datetime DEFAULT NULL COMMENT '上架时间',
  `DATA_FLAG` tinyint(4) NOT NULL DEFAULT '1' COMMENT '删除标志    -1:删除 1:有效',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `goods`
-- ----------------------------
BEGIN;
INSERT INTO `goods` VALUES ('6', '51d7ab94-01b9-4416-8529-b7d7cd25cc76', '小米Max2 大屏手机 4GB+64GB 金色 全网通4G手机 双卡双待', 'http://120.79.214.81/group1/M00/00/00/wKgBTlrIjS2AX8TwAAC3K4JB-Oc198.jpg', '1599', '1499', '6', '100', '满19元即赠热销商品，赠完即止', '1', '0', '1', '1', '/1/39/42/49', '49', '6.44\'\'大屏/5300mAh 充电宝级的大电量/大像素相机/轻薄全金属/​4GB 大内存/骁龙八核处理器', '0', '2018-04-07 17:11:11', '1', '2018-04-07 17:11:11'), ('8', '1433fd4d-ffa2-42df-9ac2-326db6fea03c', '荣耀9 全网通 标配版 4GB+64GB 魅海蓝 移动联通电信4G手机 双卡双待', 'http://120.79.214.81/group1/M00/00/00/wKgBTlrIjWiARMoDAAC3K4JB-Oc928.jpg', '2500', '2299', '6', '100', '每满2299元，可减300元现金', '1', '1', '1', '1', '/1/39/42/49', '49', '很好横强大', '0', '2018-04-07 17:15:33', '1', '2018-04-07 17:15:33');
COMMIT;

-- ----------------------------
--  Table structure for `goods_cats`
-- ----------------------------
DROP TABLE IF EXISTS `goods_cats`;
CREATE TABLE `goods_cats` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `PARENT_ID` int(11) NOT NULL COMMENT '父ID   -1:一级菜单',
  `CAT_NAME` varchar(20) NOT NULL COMMENT '分类名称',
  `IS_SHOW` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否显示  0:隐藏 1:显示',
  `CAT_SORT` int(11) NOT NULL DEFAULT '0' COMMENT '排序号',
  `DATA_FLAG` tinyint(4) NOT NULL DEFAULT '1' COMMENT '删除标志   1:有效 -1：删除',
  `CREATE_TIME` datetime NOT NULL COMMENT '建立时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `goods_cats`
-- ----------------------------
BEGIN;
INSERT INTO `goods_cats` VALUES ('1', '-1', 'root', '1', '0', '1', '2018-01-09 21:04:45'), ('39', '1', '手机/运营商/数码', '1', '0', '1', '2018-04-07 16:55:35'), ('40', '1', '电脑/办公', '1', '0', '1', '2018-04-07 16:55:51'), ('41', '1', '食品/生鲜/特产', '1', '0', '1', '2018-04-07 16:56:39'), ('42', '39', '手机通讯', '1', '0', '1', '2018-04-07 16:56:58'), ('44', '39', '智能设备', '1', '0', '1', '2018-04-07 16:58:33'), ('45', '40', '电脑整机', '1', '0', '1', '2018-04-07 16:58:56'), ('46', '40', '电脑配件', '1', '0', '1', '2018-04-07 16:59:05'), ('47', '41', '新鲜水果', '1', '0', '1', '2018-04-07 16:59:23'), ('48', '41', '休闲食品', '1', '0', '1', '2018-04-07 16:59:35'), ('49', '42', '手机', '1', '0', '1', '2018-04-07 17:01:25'), ('50', '42', '游戏手机', '1', '0', '1', '2018-04-07 17:01:34'), ('51', '44', '智能手环', '1', '0', '1', '2018-04-07 17:02:15'), ('52', '44', '智能手表', '1', '0', '1', '2018-04-07 17:02:36'), ('53', '45', '笔记本', '1', '0', '1', '2018-04-07 17:03:12'), ('54', '45', '游戏本', '1', '0', '1', '2018-04-07 17:03:25'), ('55', '46', '显示器', '1', '0', '1', '2018-04-07 17:03:45'), ('56', '46', 'CPU', '1', '0', '1', '2018-04-07 17:03:53'), ('57', '47', '苹果', '1', '0', '1', '2018-04-07 17:04:24'), ('58', '47', '香蕉', '1', '0', '1', '2018-04-07 17:04:33'), ('59', '48', '营养零食', '1', '0', '1', '2018-04-07 17:04:59'), ('60', '48', '休闲零食', '1', '0', '1', '2018-04-07 17:05:09'), ('61', '1', '家用电器', '1', '0', '1', '2018-04-07 17:06:46'), ('62', '1', '家居/家具', '1', '0', '1', '2018-04-07 17:07:11'), ('63', '1', '男鞋/运动/户外', '1', '0', '1', '2018-04-07 17:07:28'), ('64', '1', '图书/音像/电子书', '1', '0', '1', '2018-04-07 17:07:54');
COMMIT;

-- ----------------------------
--  Table structure for `goods_imgs`
-- ----------------------------
DROP TABLE IF EXISTS `goods_imgs`;
CREATE TABLE `goods_imgs` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IMG_DESC` varchar(100) DEFAULT NULL COMMENT '图片描述',
  `IMG_URL` varchar(100) NOT NULL COMMENT '图片地址',
  `UPLOAD_DATE` datetime NOT NULL COMMENT '上传时间',
  `GOODS_ID` int(11) NOT NULL COMMENT '商品id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `goods_imgs`
-- ----------------------------
BEGIN;
INSERT INTO `goods_imgs` VALUES ('10', null, 'http://120.79.214.81/group1/M00/00/00/wKgBTlrIjWiARMoDAAC3K4JB-Oc928.jpg', '2018-04-07 17:20:40', '8');
COMMIT;

-- ----------------------------
--  Table structure for `sys_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资源ID',
  `RES_NAME` varchar(100) DEFAULT NULL COMMENT '资源名称',
  `RES_TYPE` varchar(50) DEFAULT NULL COMMENT '资源类型',
  `RES_URL` varchar(200) DEFAULT NULL,
  `PARENT_ID` bigint(20) DEFAULT NULL,
  `PARENT_IDS` varchar(100) DEFAULT NULL,
  `PERMISSION` varchar(100) DEFAULT NULL,
  `AVAILABLE` tinyint(1) DEFAULT '0' COMMENT '是否可获得，0可获得，1不可获得',
  PRIMARY KEY (`ID`),
  KEY `idx_sys_resource_parent_id` (`PARENT_ID`),
  KEY `idx_sys_resource_parent_ids` (`PARENT_IDS`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `sys_resource`
-- ----------------------------
BEGIN;
INSERT INTO `sys_resource` VALUES ('1', '资源', 'folder', '', '0', '0/', '', '1'), ('21', '用户管理', 'folder', '/sysuser', '1', '0/1/', 'sysuser:*', '1'), ('22', '用户新增', 'item', '/sysuser/create', '21', '0/1/21/', 'sysuser:create', '1'), ('23', '用户修改', 'doAction', '/sysuser/update', '21', '0/1/21/', 'sysuser:update', '1'), ('24', '用户删除', 'doAction', '/sysuser/delete', '21', '0/1/21/', 'sysuser:delete', '1'), ('25', '用户查看', 'item', '/sysuser/view', '21', '0/1/21/', 'sysuser:view', '1'), ('31', '资源管理', 'folder', '/resource', '1', '0/1/', 'resource:*', '1'), ('32', '资源新增', 'item', '/resource/create', '31', '0/1/31/', 'resource:create', '1'), ('33', '资源修改', 'doAction', '/resource/update', '31', '0/1/31/', 'resource:update', '1'), ('34', '资源删除', 'doAction', '/resource/delete', '31', '0/1/31/', 'resource:delete', '1'), ('35', '资源查看', 'item', '/resource/view', '31', '0/1/31/', 'resource:view', '1'), ('41', '角色管理', 'folder', '/role', '1', '0/1/', 'role:*', '1'), ('42', '角色新增', 'item', '/role/create', '41', '0/1/41/', 'role:create', '1'), ('43', '角色修改', 'doAction', '/role/update', '41', '0/1/41/', 'role:update', '1'), ('44', '角色删除', 'doAction', '/role/delete', '41', '0/1/41/', 'role:delete', '1'), ('45', '角色查看', 'item', '/role/view', '41', '0/1/41/', 'role:view', '1'), ('52', '商品管理', 'folder', '/goods', '1', '0/1/', 'goods:*', '1'), ('53', '分类菜单管理', 'folder', '/goods/cats', '52', '0/1/52/', 'cats:*', '1'), ('54', '新增分类', 'item', '/goods/cats/create', '53', '0/1/52/53/', 'cats:create', '1'), ('55', '删除分类', 'doAction', '/goods/cats/delete', '53', '0/1/52/53/', 'cats:delete', '1'), ('56', '查看分类', 'item', '/goods/cats/view', '53', '0/1/52/53/', 'cats:view', '1'), ('66', '菜单', null, '/menu', null, null, null, '1'), ('67', '添加资源Action', 'doAction', '/resource/update.do', '31', '0/1/31', 'resource:update', '1'), ('68', '启用资源', 'doAction', '/resource/enable.do', '31', '0/1/31', 'resource:update', '1'), ('69', '用户新增Action', 'doAction', '/sysuser/create.do', '21', '0/1/21', 'sysuser:create', '1'), ('72', '解锁用户', 'doAction', '/sysuser/deblocking.do', '21', '0/1/21', 'sysuser:update', '1'), ('73', '角色新增Action', 'doAction', '/role/create.do', '41', '0/1/41/', 'role:create', '1'), ('74', '修改分类', 'doAction', '/goods/cats/update', '53', '0/1/52/53/', 'cats:update', '1'), ('75', '修改分类Action', 'doAction', '/goods/cats/update.do', '53', '0/1/52/53/', 'cats:update', '1'), ('76', '新增分类Action', 'doAction', '/goods/cats/create.do', '53', '0/1/52/53/', 'cats:create', '1'), ('77', '商品信息管理', 'folder', '/goods/goodsInfo', '52', '0/1/52/', 'goodsInfo:*', '1'), ('78', '商品新增', 'item', '/goods/goodsInfo/create', '77', '0/1/52/77', 'goodsInfo:create', '1'), ('79', '商品查看', 'item', '/goods/goodsInfo/view', '77', '0/1/52/77', 'goodsInfo:view', '1'), ('80', '商品新增Action', 'doAction', '/goods/goodsInfo/create.do', '77', '0/1/52/77', 'goodsInfo:create', '1'), ('81', '上传文件Action', 'doAction', '/goods/goodsInfo/uploadFile.do', '77', '0/1/52/77', 'goodsInfo:create', '1'), ('82', '商品图片管理', 'item', '/goods/goodsInfo/imgManage', '77', '0/1/52/77', 'goodsInfo:view', '1'), ('83', '商品图片展示', 'doAction', '/goods/goodsInfo/imgPage', '77', '0/1/52/77', 'goodsInfo:view', '1'), ('84', '商品图片添加页面', 'doAction', '/goods/goodsInfo/uploadFile', '77', '0/1/52/77', 'goodsInfo:view', '1'), ('85', '删除商品图片', 'doAction', '/goods/goodsInfo/delFile.do', '77', '0/1/52/77', 'goodsInfo:update', '1'), ('86', '获取商品完全分类路径', 'doAction', '/goods/goodsInfo/getCatIdPath', '77', '0/1/52/77', 'goodsInfo:view', '1'), ('87', '删除商品', 'doAction', '/goods/goodsInfo/delete', '77', '0/1/52/77', 'goodsInfo:delete', '1'), ('88', '启用商品', 'doAction', '/goods/goodsInfo/enable.do', '77', '0/1/52/77', 'goodsInfo:update', '1'), ('89', '上架商品', 'doAction', '/goods/goodsInfo/grounding', '77', '0/1/52/77', 'goodsInfo:update', '1'), ('90', '下架商品', 'doAction', '/goods/goodsInfo/pullOff', '77', '0/1/52/77', 'goodsInfo:update', '1');
COMMIT;

-- ----------------------------
--  Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '规则ID',
  `ROLE` varchar(100) DEFAULT NULL COMMENT '规则',
  `DESCRIPTION` varchar(100) DEFAULT NULL COMMENT '规则描述',
  `RESOURCE_IDS` varchar(100) DEFAULT NULL COMMENT '资源ID',
  `AVAILABLE` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `idx_sys_role_resource_ids` (`RESOURCE_IDS`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `sys_role`
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES ('1', 'admin', '超级管理员', '21,31,41,52,53,66,77', '1'), ('2', 'aa', '打酱油', '11,66', '1'), ('3', 'admin3', '皮皮虾', '21', '1'), ('4', 'admin4', '皮皮', '21,41', '1'), ('5', 'admin5', '皮', '21', '1'), ('6', 'admin6', '皮皮虾走', '21,22', '1');
COMMIT;

-- ----------------------------
--  Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(100) DEFAULT NULL,
  `PASS_WORD` varchar(100) DEFAULT NULL,
  `SALT` varchar(100) DEFAULT NULL COMMENT '盐',
  `ROLE_IDS` varchar(100) DEFAULT NULL COMMENT '规则ID',
  `LOCKED` tinyint(1) DEFAULT '0' COMMENT '是否锁定，0否，1是',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `idx_sys_user_username` (`USER_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `sys_user`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '8d78869f470951332959580424d4bf4f', '1', '0'), ('2', 'admin1', 'e10adc3949ba59abbe56e057f20f883e', '8d78869f470951332959580424d4bf4f', '2', '0'), ('3', 'zhangsan', 'a360c5ee1e41a2134ac399a91ab13ed8', 'a7077010c381878726f349dea7c68823', '1', '0'), ('4', 'gongwang', '2967054c08562f61abbe92bc576a3c6a', '2108078c09d2b7b277654480e96d761f', '2', '0'), ('38', 'lisi', 'c5175e798b4ac282b56e9b07a750f8a4', '36f290ff3f599b9d0105cb28d0ab79ba', '6', '0'), ('39', 'wangmazi', 'de4db98a15fe7129c292882a8130354c', '1d7ca302aeb3467880ef71a190972764', '1', '0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
