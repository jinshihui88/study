package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ContentModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ajax.service.ShowContentService;

public class ContentCompletServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String nc=req.getParameter("news_cont");
		System.out.println("the new content is: " + nc);
		
		ShowContentService scc = new ShowContentService();
		
		PrintWriter out =resp.getWriter();
		out.print(scc.showContens(nc));
		out.flush();
		out.close();
	}

}
