package com.zzzyedu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zzzyedu.bean.User;
import com.zzzyedu.utils.JDBCUtil;

public class UserDAO {
	public List<User> getUserByPage(int pageIndex,int pageSize){
		//String sql = "insert into t_user values(t_user_seq.nextval,'"+username+"','"+userpwd+"','"+email+"')";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		String sql = "select * from (SELECT t.*, ROWNUM rn  FROM (SELECT * FROM t_user order by id) t  " +
				"WHERE ROWNUM <= "+(pageIndex)*pageSize+") where rn > "+(pageIndex-1)*pageSize;
		System.out.println(sql);
		
		try{
			conn = JDBCUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt(1));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setUserpwd(rs.getString("userpwd"));
				users.add(user);
			}
			return users;
			
		}catch(Exception e){
			
		}finally{
			JDBCUtil.closeResultSet(rs);
			JDBCUtil.closeStatement(st);
			JDBCUtil.closeConnection(conn);
		}
		return null;
	
	}
	
	public int getCount(){
		//String sql = "insert into t_user values(t_user_seq.nextval,'"+username+"','"+userpwd+"','"+email+"')";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		String sql = "select count(id) from t_user";
		System.out.println(sql);
		int count = 0;
		try{
			conn = JDBCUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()){
				count = rs.getInt(1);
			}
			
		}catch(Exception e){
			
		}finally{
			JDBCUtil.closeResultSet(rs);
			JDBCUtil.closeStatement(st);
			JDBCUtil.closeConnection(conn);
		}
		return count;
	
	}
	
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		List<User> users= userDAO.getUserByPage(2, 2);
		for (User user : users) {
			System.out.println(user.getId()+","+user.getUsername());
		}
	}
}
