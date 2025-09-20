package picCheckTest;

import java.awt.image.RenderedImage;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CodeServlet1 extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0L);
		
		ImageIO.write((RenderedImage) CodeNumber.getInstance().codeNumber(4, 10, request), "JPEG", response.getOutputStream());
		request.setAttribute("id", request.getSession().getAttribute("codeNum"));
		
		HttpSession session =request.getSession();
		session.setAttribute("code",request.getSession().getAttribute("codeNum") );
		System.out.println(request.getSession().getAttribute("codeNum"));
	}
		
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	

}
