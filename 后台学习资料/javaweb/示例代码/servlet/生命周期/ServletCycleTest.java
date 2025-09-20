package hbjr1108.servletExamples;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCycleTest extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("First: method of get......");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("First: method of post......");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("First: apply service......");
		super.service(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("First: destroy......");
		super.destroy();
	}

	public ServletCycleTest() {
		System.out.println("First: create a instance of servlet!");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("First: init......");
		super.init();
	}

	
}
