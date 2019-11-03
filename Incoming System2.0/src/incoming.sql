-- phpMyAdmin SQL Dump
-- version 2.10.2
-- http://www.phpmyadmin.net
-- 
-- 主機: localhost
-- 建立日期: Jan 08, 2019, 02:16 AM
-- 伺服器版本: 5.0.45
-- PHP 版本: 4.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- 資料庫: `incoming`
-- 

-- --------------------------------------------------------

-- 
-- 資料表格式： `employee`
-- 

CREATE TABLE `employee` (
  `eid` int(20) NOT NULL,
  `staff_name` varchar(20) character set utf8 collate utf8_unicode_ci NOT NULL,
  `status` varchar(20) character set utf8 collate utf8_unicode_ci NOT NULL,
  `office_hour` int(20) NOT NULL,
  `date` varchar(20) character set utf8 collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`eid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 列出以下資料庫的數據： `employee`
-- 

INSERT INTO `employee` VALUES (1, 'Tonantems', 'Mgr', 8, NULL);
INSERT INTO `employee` VALUES (2, 'Ryen', 'Staff', 8, NULL);
INSERT INTO `employee` VALUES (3, 'Wayne', 'Staff', 8, NULL);

-- --------------------------------------------------------

-- 
-- 資料表格式： `login`
-- 

CREATE TABLE `login` (
  `id` int(20) NOT NULL,
  `user_name` varchar(20) character set utf8 collate utf8_unicode_ci NOT NULL,
  `password` varchar(20) character set utf8 collate utf8_unicode_ci NOT NULL,
  `state` int(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 列出以下資料庫的數據： `login`
-- 

INSERT INTO `login` VALUES (1, '456', '456', 1);
INSERT INTO `login` VALUES (2, '123', '123', 2);

-- --------------------------------------------------------

-- 
-- 資料表格式： `product`
-- 

CREATE TABLE `product` (
  `productID` varchar(20) character set utf8 collate utf8_unicode_ci NOT NULL,
  `item` varchar(20) character set utf8 collate utf8_unicode_ci NOT NULL,
  `productCount` varchar(20) character set utf8 collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`productID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 列出以下資料庫的數據： `product`
-- 


-- --------------------------------------------------------

-- 
-- 資料表格式： `stock`
-- 

CREATE TABLE `stock` (
  `sid` int(20) NOT NULL,
  `Item` varchar(20) character set utf8 collate utf8_unicode_ci NOT NULL,
  `Qty` int(20) NOT NULL,
  `date` varchar(20) character set utf8 collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`sid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 列出以下資料庫的數據： `stock`
-- 

INSERT INTO `stock` VALUES (1, '蘋果', 100, NULL);
INSERT INTO `stock` VALUES (2, '香蕉', 100, NULL);
INSERT INTO `stock` VALUES (3, '芭樂', 100, NULL);
INSERT INTO `stock` VALUES (4, '哈密瓜', 150, NULL);

-- --------------------------------------------------------

-- 
-- 資料表格式： `supplier`
-- 

CREATE TABLE `supplier` (
  `order_number` int(20) NOT NULL,
  `sup_number` int(20) NOT NULL,
  `sup_name` varchar(20) character set utf8 collate utf8_unicode_ci NOT NULL,
  `production` varchar(20) character set utf8 collate utf8_unicode_ci NOT NULL,
  `number` int(20) NOT NULL,
  `one_price` int(20) NOT NULL,
  `in_date` varchar(20) character set utf8 collate utf8_unicode_ci default NULL,
  `phone_number` varchar(30) NOT NULL,
  `phone_number2` int(30) default NULL,
  `address` varchar(128) character set utf8 collate utf8_unicode_ci NOT NULL,
  `remark` varchar(40) character set utf8 collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`order_number`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 列出以下資料庫的數據： `supplier`
-- 

INSERT INTO `supplier` VALUES (1, 1, '123公司', '芒果', 1000, 100, NULL, '07-12345678', NULL, '高雄市左營區民族一路333號', NULL);
INSERT INTO `supplier` VALUES (2, 2, '123公司', '香蕉', 150, 120, NULL, '07-12345678', NULL, '高雄市左營區民族一路333號', NULL);

-- --------------------------------------------------------

-- 
-- 資料表格式： `trade`
-- 

CREATE TABLE `trade` (
  `cid` int(20) NOT NULL,
  `product` varchar(20) character set utf8 collate utf8_unicode_ci NOT NULL,
  `Qity` int(20) NOT NULL,
  `money` int(20) NOT NULL,
  `date` varchar(20) character set utf8 collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`cid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 列出以下資料庫的數據： `trade`
-- 

INSERT INTO `trade` VALUES (1, '蘋果', 50, 500, NULL);
INSERT INTO `trade` VALUES (2, '香蕉', 20, 400, NULL);
INSERT INTO `trade` VALUES (3, '芒果', 50, 1000, NULL);
