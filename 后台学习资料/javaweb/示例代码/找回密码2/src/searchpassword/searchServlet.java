package searchpassword;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.mail.*;
import javax.activation.*;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

public class searchServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=GBK";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String pass = null;
        try {
              Properties prop = new Properties();
                    prop.put("mail.transport.protocol", "smtp"); //���ü��ʼ�Э��
                    prop.put("mail.smtp.host", "127.0.0.1"); //���÷�������ַ
                    prop.put("mail.smtp.port", "25"); //���÷���˿ں�
                    Session session = Session.getInstance(prop, null); //��������
                    Message msg = new MimeMessage(session);
                    msg.setFrom(new InternetAddress("soft@sohu.com"));
                    msg.setRecipients(Message.RecipientType.TO,
                                      InternetAddress.
                                      parse(email));
                    msg.setSentDate(new java.util.Date());
                    msg.setSubject("����");
		   //the pwd should be selected from database
                    msg.setText("����Ϊ��123");
                    Transport.send(msg);
                    msg.writeTo(System.out);
                    System.out.println("�ʼ��Ѿ��ɹ�����");
                    RequestDispatcher res = request.getRequestDispatcher(
                            "mail.jsp");
                    res.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doGet(request, response);
    }
}
