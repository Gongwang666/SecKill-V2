/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17-log : Database - sec_kill
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sec_kill` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sec_kill`;

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `GOODS_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `GOODS_SN` varchar(20) NOT NULL COMMENT '商品编号',
  `GOODS_NAME` varchar(50) NOT NULL COMMENT '商品名称',
  `GOODS_IMG` varchar(150) NOT NULL COMMENT '商品图片',
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
  `SALE_TIME` datetime NOT NULL COMMENT '上架时间',
  `DATA_FLAG` tinyint(4) NOT NULL DEFAULT '1' COMMENT '删除标志    -1:删除 1:有效',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`GOODS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

/*Table structure for table `goods_cats` */

DROP TABLE IF EXISTS `goods_cats`;

CREATE TABLE `goods_cats` (
  `CAT_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `PARENT_ID` int(11) NOT NULL COMMENT '父ID   -1:一级菜单',
  `CAT_NAME` varchar(20) NOT NULL COMMENT '分类名称',
  `IS_SHOW` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否显示  0:隐藏 1:显示',
  `CAT_SORT` int(11) NOT NULL DEFAULT '0' COMMENT '排序号',
  `DATA_FLAG` tinyint(4) NOT NULL DEFAULT '1' COMMENT '删除标志   1:有效 -1：删除',
  `CREATE_TIME` datetime NOT NULL COMMENT '建立时间',
  PRIMARY KEY (`CAT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_cats` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
