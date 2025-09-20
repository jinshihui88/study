--查询当前版本
SELECT
  id,
  version,
  version_content,
  create_time,
  update_time
FROM
  dpyt_version v
ORDER BY
  id desc
LIMIT
  1;


SELECT * from stock_base_info



SELECT * from stock_base_info where type = 3;
SELECT * from stock_base_info where type = 3 and code = '000043'
SELECT * from stock_base_info where type = 3 and parent_code is null 
SELECT code,nick_name from stock_base_info where type = 2;

