package s1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProvinceServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.
		String sname = req.getParameter("sname");
		String sage = req.getParameter("sage");
		int iage = 0;
		if(sage != null  && !sage.equals("")){
			iage = Integer.parseInt(sage);
		}
		System.out.println("省政府接收到的姓名：" + sname + ",  年齡：" + iage);
		
		//2. 
		resp.sendRedirect("http://localhost:8092/servletExam2/centerReg");
		
		//req.getRequestDispatcher("/centerReg").forward(req, resp);
		
		//3. 
	}

	
}
