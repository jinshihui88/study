package paging;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class PagingDAO {
	/*
	 * 查询一个表的若干条记录：
	 * @param int 开始行数
	 * @param int 结束行数
	 * @return List 查询结果集
	 */
	public List<EMPModel> query(int start, int end){
		Connection conn = DBUtil.getLocalConn();
		Statement stat = null;
		ResultSet rs = null;
		List<EMPModel> empList = null;
		
		if(conn != null){
			try {
				stat = conn.createStatement();
				rs = stat.executeQuery("select * from (select e.*, rownum rn from emp e) where rn >=" + start + "and rn<=" + end);
				
				if(rs!=null){
					empList = new ArrayList<EMPModel>();
					while(rs.next()){
//						System.out.println("empno: " + rs.getInt("empno"));
//						System.out.println("empname: " + rs.getString("ename"));
//						System.out.println("job: " + rs.getString("job"));
//						System.out.println("hiredate: " + rs.getTimestamp("hiredate"));
//						System.out.println("salary: " + rs.getDouble("sal"));
//						System.out.println("comm: " + rs.getDouble("comm"));
//						
//						System.out.println("==========================================");
						
						EMPModel em = new EMPModel();
						em.setEmpno1(rs.getInt("empno"));
						em.setEmpname1(rs.getString("ename"));
						em.setJob(rs.getString("job"));
						em.setHiredate1(rs.getTimestamp("hiredate"));
						em.setSalary(rs.getDouble("sal"));
						em.setBound(rs.getDouble("comm"));
						
						empList.add(em);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					rs.close();
					stat.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return empList;
	}
	
	/*
	 * 查询emp表全部数据
	 */
	public void queryAll(){
		//Connection conn = DBUtil.getConn();
		Connection conn = DBUtil.getLocalConn();
		Statement stat = null;
		ResultSet rs = null;
		
		if(conn != null){
			try {
				stat = conn.createStatement();
				rs = stat.executeQuery("select * from emp");
				
				while(rs.next()){
					System.out.println("empno: " + rs.getInt("empno"));
					System.out.println("empname: " + rs.getString("ename"));
					System.out.println("job: " + rs.getString("job"));
					System.out.println("hiredate: " + rs.getTimestamp("hiredate"));
					System.out.println("salary: " + rs.getDouble("sal"));
					System.out.println("comm: " + rs.getDouble("comm"));
					System.out.println("==========================================");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					rs.close();
					stat.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args){
		//new PagingClass().queryAll();
		new PagingDAO().query(5, 10);
	}
}
