package servlet.el;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ELServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.
		
		//2.
		
		//3.
		req.setAttribute("success", req.getParameter("userName"));
		req.setAttribute("error", "��¼ʧ�ܣ������û���������");
		req.getSession().setAttribute("session_info", "�º�Ƽ");
		
		req.getRequestDispatcher("/el/elOut.jsp").forward(req, resp);
	}

}
