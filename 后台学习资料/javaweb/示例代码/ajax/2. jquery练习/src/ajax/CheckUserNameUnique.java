package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckUserNameUnique extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1. 
		String userName = req.getParameter("uname");
		System.out.println("username is : " + userName);
		
		//2.
		System.out.println(userName + "is existed!");
		
		//3. 
		PrintWriter out = resp.getWriter();
		out.println( userName  + " is existed!");
		out.flush();
		out.close();
	}

}
