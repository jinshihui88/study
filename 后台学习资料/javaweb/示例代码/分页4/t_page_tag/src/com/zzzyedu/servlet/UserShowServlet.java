package com.zzzyedu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzzyedu.bean.User;
import com.zzzyedu.dao.UserDAO;

public class UserShowServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		int count = userDAO.getCount();
		int pageSize = 2;
	/*	int totalPage = 0;
		if(count % pageSize == 0){
			totalPage = count/pageSize;
		}else{
			totalPage = count/pageSize + 1;
		}*/
		String str_page = request.getParameter("page");
		if(null == str_page){
			str_page = "1";
		}
		int pageIndex = Integer.parseInt(str_page);
		
		
		request.setAttribute("count", count);
		request.setAttribute("pageSize", pageSize);
		List<User> users = userDAO.getUserByPage(pageIndex, pageSize);
		request.setAttribute("users", users);
		request.getRequestDispatcher("user_show.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
