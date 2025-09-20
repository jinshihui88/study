--根据组件名称查询菜单权限信息
SELECT
  id,
  parent_id,
  name,
  perms,
  perms_type,
  icon,
  component,
  component_name,
  url,
  redirect,
  sort_no,
  menu_type,
  is_leaf AS leaf,
  is_route AS route,
  keep_alive,
  description,
  create_by,
  del_flag,
  rule_flag,
  hidden,
  create_time,
  update_by,
  update_time,
  status,
  always_show,
  internal_or_external
FROM
  sys_permission
WHERE
  (
    del_flag = 0
    AND component = 'system/UserList'
  );
--涉及的表：sys_permission

--根据菜单ID和用户名查找数据权限配置信息
SELECT
  data_rule_ids
FROM
  sys_role_permission a
  JOIN sys_permission b ON a.permission_id = b.id
  JOIN sys_role c ON a.role_id = c.id
  JOIN sys_user_role d ON d.role_id = c.id
  JOIN sys_user e ON d.user_id = e.id
WHERE
  e.username = 'admin'
  AND b.id = '3f915b2769fc80648e92d04e84ca059d'
UNION
SELECT
  data_rule_ids
FROM
  sys_depart_role_permission a
  JOIN sys_permission b ON a.permission_id = b.id
  JOIN sys_depart_role c ON a.role_id = c.id
  JOIN sys_depart_role_user d ON d.drole_id = c.id
  JOIN sys_user e ON d.user_id = e.id
WHERE
  e.username = 'admin'
  AND b.id = '3f915b2769fc80648e92d04e84ca059d';
--涉及的表：
sys_user
sys_role
sys_user_role
sys_permission
sys_role_permission

sys_depart_role_permission
sys_depart_role
sys_depart_role_user


--根据用户名查询用户信息
SELECT id, username, realname, password, salt, avatar, birthday, sex, email, phone, org_code, status, del_flag, work_no, post, telephone, create_by, create_time, update_by, update_time, activiti_sync, user_identity, depart_ids, rel_tenant_ids, client_id
 FROM sys_user
 WHERE del_flag = 0
 AND ((username = 'admin')
 AND username <> '_reserve_user_external') ORDER BY create_time DESC
 --涉及的表：sys_user

 --根据用户id查询部门名称
 SELECT
  d.depart_name,
  ud.user_id
FROM
  sys_user_depart ud,
  sys_depart d
WHERE
  d.id = ud.dep_id
  AND ud.user_id IN ('e9ca23d68d884d4ebb19d07889727dae');
--根据部门ID进行关联
--涉及的表：sys_depart、sys_user_depart