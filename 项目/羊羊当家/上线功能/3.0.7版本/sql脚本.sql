CREATE TABLE `yy_blood_model_backup` (
	`id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`member_id` INT(10) NOT NULL COMMENT '用户id',
	`imei` VARCHAR(50) NOT NULL COMMENT '串号' COLLATE 'utf8mb4_unicode_ci',
	`dbp` INT(10) NOT NULL COMMENT '低压',
	`sdp` INT(10) NOT NULL COMMENT '高压',
	`start_time` VARCHAR(50) NOT NULL COMMENT '血压建模开始时间' COLLATE 'utf8mb4_unicode_ci',
	`end_time` VARCHAR(50) NOT NULL COMMENT '血压建模结束时间' COLLATE 'utf8mb4_unicode_ci',
	`create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	`created` VARCHAR(32) NULL DEFAULT NULL COMMENT '创建者' COLLATE 'utf8mb4_unicode_ci',
	`update_time` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	`updated` VARCHAR(32) NULL DEFAULT NULL COMMENT '更新者' COLLATE 'utf8mb4_unicode_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COMMENT='血压建模备份表'
COLLATE='utf8mb4_unicode_ci'
ENGINE=InnoDB;
