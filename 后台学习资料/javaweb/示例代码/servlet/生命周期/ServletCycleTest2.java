package hbjr1108.servletExamples;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCycleTest2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Second: method of get......");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Second: method of post......");
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("Second: apply service......");
		super.service(arg0, arg1);
	}

	@Override
	public void destroy() {
		System.out.println("Second: destroy......");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Second: init......");
		super.init();
	}

	public ServletCycleTest2() {
		System.out.println("Second: create a instance of servlet!");
	}
	
}