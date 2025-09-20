package com.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {

	private static Connection conn;

	/**
	 * 取得数据库的连接
	 * 
	 * @return Connection
	 */
	public static Connection getInstance() {
		if (null == conn) {
			try {
				Class.forName(Util.DRIVER);
				conn = DriverManager.getConnection(Util.URL, Util.USER,
						Util.PASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	/**
	 * 通过连接池来取得数据库的连接
	 * 
	 * @return Connection
	 */
	public static Connection getInstances() {
		Connection con = null;
//		try {
//			Context initContext = new InitialContext();
//			// 查找java中的环境
//			Context context = (Context) initContext.lookup("java:/comp/env");
//			// 查找配置文件中的环境
//			DataSource ds = (DataSource) context.lookup("jdbc/test");
//			// 取得一个连接
//			con = ds.getConnection();
//		} catch (NamingException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		// 如果连接池中已经没有可用的连接时，我们要自己手动取得一个连接
		if (null == con) {
			con = getInstance();
		}
		return con;
	}

	/**
	 * 取得Statement
	 * 
	 * @return Statement
	 */
	public static Statement getStat() {
		Statement stat = null;
		try {
			stat = getInstances().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stat;
	}

	/**
	 * 关闭ResultSet
	 * 
	 * @param rs
	 *            ResultSet
	 */
	public static void closeRs(ResultSet rs) {
		// 不为NULL的情况
		if (null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭Statement
	 * 
	 * @param stat
	 *            Statement
	 */
	public static void closeStat(Statement stat) {
		// 不为NULL的情况
		if (null != stat) {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭Connection
	 * 
	 * @param con
	 *            Connection
	 */
	public static void closeConn(Connection con) {
		// 不为NULL的情况
		if (null != con) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
