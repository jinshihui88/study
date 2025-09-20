package hbjr1108.servletSeniorExams;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieTest1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=gbk");
		//添加Cookie:
		//第一种方式：
//		resp.setHeader("Set-Cookie", "customId=123456");
//		resp.setHeader("Set-Cookie", "color=bule");
//		resp.setHeader("Set-Cookie", "name=eniyah");
		
		//第二种方式：
		Cookie ck = new Cookie("userID","123456");
		ck.setComment("for test1");
		ck.setMaxAge(60);
		resp.addCookie(ck);
		
		Cookie ck2 = new Cookie("userName","eniyah");
		resp.addCookie(ck2);
		
		PrintWriter out = resp.getWriter();
		out.println("<a href=\"st11\" />查看Cookie");
	}

}
