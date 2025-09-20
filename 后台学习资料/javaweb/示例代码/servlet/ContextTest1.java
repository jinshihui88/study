package hbjr1108.servletExamples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextTest1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out = resp.getWriter();
		
		ServletContext sc = getServletContext();
		
		Integer count = (Integer) sc.getAttribute("count");
		if(count == null){
			count = new Integer(0);
		}
		
		sc.setAttribute("count", count.intValue()+1);
		
		out.println("<html> \n");
		out.println("<head> \n");
		out.println("<title>des</title> \n");
		out.println("<body> \n");
		out.println("<h1>注意此数的变化</h1> \n");
		out.println("get attribute from servletContext:" + count + "\n");
		out.println("</body> \n");
		out.println("</html> \n");
		out.flush();
		out.close();
	}

}
