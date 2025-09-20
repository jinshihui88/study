package com.guigu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SendMesServlet
 */
public class SendMesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		String mess="";
		String user_name="";
		String mes=request.getParameter("mes");
		HttpSession session=request.getSession();
		if(session.getAttribute("user_name")==""){
			user_name="游客";
		}else{
			user_name=session.getAttribute("user_name")+"";
		}
		
		//获取application对象
		ServletContext application=this.getServletContext();
		if(application.getAttribute("mes")==null){
			mess=user_name+":"+mes;
		}else{
			mess=application.getAttribute("mes")+user_name+":"+mes;
		}
		application.setAttribute("mes",mess+"<br/>");
		PrintWriter out =response.getWriter();
		out.print(mess);
		out.flush();
		out.close();
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
