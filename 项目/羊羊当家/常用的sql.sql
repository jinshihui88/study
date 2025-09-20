#查看网关配置的
SELECT * FROM config_info WHERE data_id = 'yydj-gateway-dev.yml';
#设备表
SELECT * FROM yy_devices WHERE im = '';
#用户表
select * from yy_member;
#通知通告表
SELECT * FROM yy_notice LIMIT 100;

#根据用户id查询手表串号
select im
        from yy_member_devices ymd
                 left join yy_devices yd on ymd.yy_devices_id =  yd.id
        where ymd.yy_member_id = #{memberId}
          and yd.ptype = 0
          and ymd.is_flag = 0;


#re_data_health_report表插入数据
INSERT INTO `re_data_health_report` (`imei`, `heart_rate`, `dbp`, `sdp`, `oxygen`, `blood_sugar`, `temperature`, `create_time`, `created`, `health_value`, `cho`, `tri`, `uri`, `heart_rate_warning`, `dbp_warning`, `sdp_warning`, `oxygen_warning`, `blood_sugar_warning`, `temperature_warning`, `cho_warning`, `tri_warning`, `uri_warning`, `yy_member_id`, `blood_sugar_pre`, `blood_sugar_pre_warning`, `blood_sugar2`, `blood_sugar2_warning`) VALUES ('356223502921220', 70, 71, 119, 99, '0', '36.3', '2023-04-25 15:46:31', '', 90.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 2030, '0', 0.00, 0.00, 0.00);


#查询周（月，年）健康（包含亚健康、欠佳、未知）记录数
SELECT COUNT(*)
        FROM re_data_health_report a
        WHERE a.yy_member_id = 2030
          AND create_time
            BETWEEN '2023-04-23 00:00:00' AND '2023-04-30 23:59:59'
          AND health_value BETWEEN 90 AND 100
        order by create_time DESC


#查询每天的健康（包含亚健康、欠佳、未知）记录数
SELECT COUNT(*)
        FROM re_data_health_report a
        WHERE a.yy_member_id = 2030
          AND create_time
            BETWEEN '2023-04-23 00:00:00' AND '2023-04-23 23:59:59'
          AND health_value BETWEEN 90 AND 100


#查询周（月，年）记录数
SELECT COUNT(*)
        FROM re_data_health_report a
        WHERE a.yy_member_id = #{memberId}
          AND create_time
            BETWEEN #{startDateTime} AND #{endDateTime}
        order by create_time DESC