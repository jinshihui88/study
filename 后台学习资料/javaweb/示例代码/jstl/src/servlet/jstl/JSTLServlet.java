package servlet.jstl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserModel;

public class JSTLServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.
		
		//2.
		List usersList = new ArrayList();
		UserModel um = new UserModel();
		um.setUaddress("ceti");
		um.setUname("zhy");
		um.setUnum("1231545");
		um.setUpassword("123");
		um.setUphone("45121");
		um.setUsex("m");
		usersList.add(um);
		
		UserModel um2 = new UserModel();
		um2.setUaddress("ceti");
		um2.setUname("wsr");
		um2.setUnum("4545");
		um2.setUpassword("123");
		um2.setUphone("4654");
		um2.setUsex("m");
		usersList.add(um2);
		
		UserModel um3 = new UserModel();
		um3.setUaddress("ceti");
		um3.setUname("xhs");
		um3.setUnum("4654600");
		um3.setUpassword("123");
		um3.setUphone("431321");
		um3.setUsex("m");
		usersList.add(um3);
		
		
		//3.
		req.setAttribute("users_list_info", usersList);
		req.getRequestDispatcher("/jstl/jstlOut.jsp").forward(req, resp);
	}

}
