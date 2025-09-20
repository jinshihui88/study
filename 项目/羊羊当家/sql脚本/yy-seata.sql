-- --------------------------------------------------------
-- 主机:                           192.168.9.200
-- 服务器版本:                        5.7.26 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 yy-seata 的数据库结构
CREATE DATABASE IF NOT EXISTS `yy-seata` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `yy-seata`;

-- 导出  表 yy-seata.branch_table 结构
CREATE TABLE IF NOT EXISTS `branch_table` (
  `branch_id` bigint(20) DEFAULT NULL,
  `xid` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `transaction_id` bigint(20) DEFAULT NULL,
  `resource_group_id` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `resource_id` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `branch_type` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `client_id` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `application_data` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- 正在导出表  yy-seata.branch_table 的数据：~0 rows (大约)

-- 导出  表 yy-seata.global_table 结构
CREATE TABLE IF NOT EXISTS `global_table` (
  `xid` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `transaction_id` bigint(20) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `application_id` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `transaction_service_group` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `transaction_name` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `timeout` int(11) DEFAULT NULL,
  `begin_time` bigint(20) DEFAULT NULL,
  `application_data` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- 正在导出表  yy-seata.global_table 的数据：~0 rows (大约)

-- 导出  表 yy-seata.lock_table 结构
CREATE TABLE IF NOT EXISTS `lock_table` (
  `row_key` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `xid` varchar(96) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `transaction_id` bigint(20) DEFAULT NULL,
  `branch_id` bigint(20) DEFAULT NULL,
  `resource_id` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `table_name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pk` varchar(36) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- 正在导出表  yy-seata.lock_table 的数据：~0 rows (大约)

-- 导出  表 yy-seata.undo_log 结构
CREATE TABLE IF NOT EXISTS `undo_log` (
  `branch_id` bigint(20) DEFAULT NULL,
  `xid` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `context` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `rollback_info` longblob,
  `log_status` int(11) DEFAULT NULL,
  `log_created` datetime DEFAULT NULL,
  `log_modified` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- 正在导出表  yy-seata.undo_log 的数据：~0 rows (大约)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
