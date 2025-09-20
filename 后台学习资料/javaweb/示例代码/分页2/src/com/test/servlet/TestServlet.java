package com.test.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.TestModel;
import com.test.service.TestService;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码格式
		// 取得页面中当前的页数
		String pageId = request.getParameter("pageId");
		int currentPage = 1;
		if (null != pageId && !"".equals(pageId)) {
			currentPage = Integer.parseInt(pageId);
		}
		System.out.println(currentPage);
		TestService ts = new TestService();
		int count = ts.getAllNum();

		List<TestModel> tmList = ts.getInfor(currentPage );

		request.setAttribute("tmList", tmList);
		request.setAttribute("count", count);
		request.setAttribute("pageId", currentPage);
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

}
