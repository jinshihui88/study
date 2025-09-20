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
	 * ȡ�����ݿ������
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
	 * ͨ�����ӳ���ȡ�����ݿ������
	 * 
	 * @return Connection
	 */
	public static Connection getInstances() {
		Connection con = null;
//		try {
//			Context initContext = new InitialContext();
//			// ����java�еĻ���
//			Context context = (Context) initContext.lookup("java:/comp/env");
//			// ���������ļ��еĻ���
//			DataSource ds = (DataSource) context.lookup("jdbc/test");
//			// ȡ��һ������
//			con = ds.getConnection();
//		} catch (NamingException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		// ������ӳ����Ѿ�û�п��õ�����ʱ������Ҫ�Լ��ֶ�ȡ��һ������
		if (null == con) {
			con = getInstance();
		}
		return con;
	}

	/**
	 * ȡ��Statement
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
	 * �ر�ResultSet
	 * 
	 * @param rs
	 *            ResultSet
	 */
	public static void closeRs(ResultSet rs) {
		// ��ΪNULL�����
		if (null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * �ر�Statement
	 * 
	 * @param stat
	 *            Statement
	 */
	public static void closeStat(Statement stat) {
		// ��ΪNULL�����
		if (null != stat) {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * �ر�Connection
	 * 
	 * @param con
	 *            Connection
	 */
	public static void closeConn(Connection con) {
		// ��ΪNULL�����
		if (null != con) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
