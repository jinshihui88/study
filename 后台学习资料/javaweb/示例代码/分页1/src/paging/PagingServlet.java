package paging;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PagingServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PagingService ps = new PagingService();
		String cp = req.getParameter("currentPage");
		
		//声明一页可以显示的记录数：
		int pageSize = 3;
		//声明当前页：
		int currPage = 1;
		if(cp != null && !(cp.equals(""))){
			currPage = Integer.parseInt(cp);
		}
		
		List<EMPModel> empList = ps.queryByPage(currPage, pageSize);
		
		req.setAttribute("empInfoList", empList);
		
		req.getRequestDispatcher("/pages/empInfo.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
