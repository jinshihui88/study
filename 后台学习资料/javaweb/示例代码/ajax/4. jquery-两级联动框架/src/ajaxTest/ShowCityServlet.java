package ajaxTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class ShowCityServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String prov_id=request.getParameter("province_id");
		System.out.println("province id is: " + prov_id);
		
		JSONArray jsa=new JSONArray();
		if((prov_id != null) && (prov_id.equals("1"))){
			City c1 = new City("1","石家庄");
			City c2 = new City("2","邯郸");
			City c3 = new City("3","保定");
			City c4 = new City("4","沧州");
			City c5 = new City("5","廊坊");
			
			jsa.put(new JSONObject(c1));
			jsa.put(new JSONObject(c2));
			jsa.put(new JSONObject(c3));
			jsa.put(new JSONObject(c4));
			jsa.put(new JSONObject(c5));

		}else{
			City c1 = new City("1","杭州");
			City c2 = new City("2","苏州");
			City c3 = new City("3","绍兴");
			City c4 = new City("4","乌镇");
			City c5 = new City("5","海宁");
			
			jsa.put(new JSONObject(c1));
			jsa.put(new JSONObject(c2));
			jsa.put(new JSONObject(c3));
			jsa.put(new JSONObject(c4));
			jsa.put(new JSONObject(c5));
		}
		
		PrintWriter out =response.getWriter();
		out.print(jsa.toString());
		out.flush();
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
