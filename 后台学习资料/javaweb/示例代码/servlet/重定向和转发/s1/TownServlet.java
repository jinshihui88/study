package s1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TownServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
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
		
		System.out.println("鎮政府接收到的姓名：" + sname + ",  年齡：" + iage);
		
		//2. 鎮派出所辦理不了身份證，所以它把這個請求轉送到了市派出所
		//重定向：
		
		ArrayList list = new ArrayList();
		Student wri = new Student();
		Student zhy = new Student();
		
		list.add(wri);
		list.add(zhy);
		System.out.println("town list: " + list);
		
		HttpSession hs = req.getSession();
		hs.setAttribute("sname", sname);
		hs.setAttribute("sage", iage);
		hs.setAttribute("infoList", list);
		
		resp.sendRedirect("http://localhost:8092/servletExam2/cityReg");
		//轉發：
		//req.getRequestDispatcher("/cityReg").forward(req, resp);
		
		//3.
	}

}
