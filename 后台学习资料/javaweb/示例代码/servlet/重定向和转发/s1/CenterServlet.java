package s1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CenterServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("���_���롣����������");
		
		//1.
		String sname = req.getParameter("sname");
		String sage = req.getParameter("sage");
		int iage = 0;
		if(sage != null  && !sage.equals("")){
			iage = Integer.parseInt(sage);
		}
		System.out.println("�����������յ���������" + sname + ",  ���g��" + iage);
		
		HttpSession hs = req.getSession();
		sname = (String) hs.getAttribute("sname");
		iage = (Integer) hs.getAttribute("sage");
		ArrayList al = (ArrayList)hs.getAttribute("infoList");
		System.out.println("�����������յ���Ϣ�� session ��,  ��������" + sname + ",  ���g��" + iage);
		
		//2. 
		System.out.println("��������C���k������������");
		
		//3. 
		PrintWriter out = resp.getWriter();
		if(sname != null && iage>=16){
			out.println("id is ready, please get it form town in weeks....");
		}else{
			out.println("please input informatioin........");
		}
	}

}
