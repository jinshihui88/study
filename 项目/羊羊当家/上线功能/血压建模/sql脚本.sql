CREATE TABLE `yy_blood_model` (
	`id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`member_id` INT(11) NOT NULL COMMENT '用户id',
	`imei` VARCHAR(50) NOT NULL COMMENT '串号' COLLATE 'utf8mb4_unicode_ci',
	`create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	`created` VARCHAR(32) NULL DEFAULT NULL COMMENT '创建者' COLLATE 'utf8mb4_unicode_ci',
	`update_time` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	`updated` VARCHAR(32) NULL DEFAULT NULL COMMENT '更新者' COLLATE 'utf8mb4_unicode_ci',
	`dbp` INT(11) NOT NULL COMMENT '低压',
	`sdp` INT(11) NOT NULL COMMENT '高压',
	`start_time` VARCHAR(50) NOT NULL COMMENT '血压建模开始时间' COLLATE 'utf8mb4_unicode_ci',
	`end_time` VARCHAR(50) NOT NULL COMMENT '血压建模结束时间' COLLATE 'utf8mb4_unicode_ci',
	`is_execute` CHAR(1) NOT NULL DEFAULT '0' COMMENT '定时任务的状态（0：未执行 1：已执行）' COLLATE 'utf8mb4_unicode_ci',
	`cron` VARCHAR(50) NOT NULL COMMENT 'cron表达式' COLLATE 'utf8mb4_unicode_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COMMENT='血压建模表'
COLLATE='utf8mb4_unicode_ci'
ENGINE=InnoDB
;
