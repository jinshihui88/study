package hbjr1108.servletSeniorExams;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieTest2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=gbk");
		
		//�Ա����ʽչ��Cookie:
		PrintWriter out = resp.getWriter();
		out.println("<table>\n");
		out.println("<tr>\n");
		out.println("<td> name:���� </td>\n");
		out.println("<td> value:ֵ </td>\n");
		out.println("<td> comment:ע�� </td>\n");
		out.println("<td> domain:�� </td>\n");
		out.println("<td> maxAge:ʧЧ�� </td>\n");
		out.println("<td> path:·�� </td>\n");
		out.println("<td> version:�汾 </td>\n");
		out.println("</tr>\n");
		Cookie[] cks = req.getCookies();
		Cookie ck = null;
		for(int i=0; i<cks.length; i++){
			out.println("<tr>\n");
			
			ck = cks[i];
			out.println("<td> " + ck.getName() + "</td> \n");
			out.println("<td> " + ck.getValue() + "</td> \n");
			out.println("<td>" + ck.getComment() + "</td>\n");
			out.println("<td>" + ck.getDomain() + "</td>\n");
			out.println("<td>" + ck.getMaxAge() + "</td>\n");
			out.println("<td>" + ck.getPath() + "</td>\n");
			out.println("<td>" + ck.getVersion() + "</td>\n");
			out.println("<td>" + ck.getSecure() + "</td>\n");
			
			out.println("</tr>\n");
		}
		out.println("</table>");
		
		out.flush();
		out.close();
	}

}
