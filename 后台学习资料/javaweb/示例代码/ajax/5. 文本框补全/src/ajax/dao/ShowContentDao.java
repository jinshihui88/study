package ajax.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ajax.model.ContentModel;

public class ShowContentDao {
	//查询全部匹配数据
	public List selAll(String con){
		List cons = new ArrayList();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			
			Statement stat = conn.createStatement();
			
			String sql="select * from con_table where cons like '" + con + "%'";
			
			System.out.println("sql: " + sql);
			
			ResultSet rs = stat.executeQuery(sql);

			if(rs != null){
				while(rs.next()){
					ContentModel cm = new ContentModel();
					cm.setCmid(rs.getString("conid"));
					cm.setContent(rs.getString("cons"));
					
					cons.add(cm);
				}	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return cons;
	}
}
