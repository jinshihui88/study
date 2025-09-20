package com.test.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.model.TestModel;
import com.test.util.DBUtil;

public class TestDao {

	/**
	 * 取得test中的所有信息
	 * 
	 * @return List<TestModel>
	 */
	public List<TestModel> getAllInfor() {

		List<TestModel> list = new ArrayList<TestModel>();

		Statement stat = DBUtil.getStat();

		String sql = "select * from test";

		try {
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				TestModel test = new TestModel();
				test.setId(rs.getInt("id"));
				test.setName(rs.getString("name"));
				test.setPwd(rs.getString("pwd"));
				list.add(test);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * 取得符合条件的test表中的信息
	 * 
	 * @param start
	 *            int
	 * @param end
	 *            int
	 * @return List<TestModel>
	 */
	public List<TestModel> getInfor(int start, int end) {

		List<TestModel> list = new ArrayList<TestModel>();
		Connection conn = DBUtil.getInstances();

		String sql = "select *  from (select t.id  ,t.name,t.pwd,rownum num from test t) s where s.num >" + start
				+ " and s.num <= " + end;
		System.out.println(sql);

		try {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				TestModel test = new TestModel();
				test.setId(rs.getInt("id"));
				test.setName(rs.getString("name"));
				test.setPwd(rs.getString("pwd"));
				list.add(test);
			}
//			 rs.close();
//			 stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// DBUtil.closeConn(conn);

		return list;
	}
	
	/**
	 * 取得test中的所有信息条数
	 * 
	 * @return int
	 */
	public int getAllNum() {

		int count = 0;

		Statement stat = DBUtil.getStat();

		String sql = "select count(*) num from test";

		try {
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}
}
