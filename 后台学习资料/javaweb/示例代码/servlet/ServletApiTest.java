package hbjr1108.servletExamples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletApiTest extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out = new PrintWriter(resp.getOutputStream(),true);
		
		//��ʼ��������
		Enumeration ens = getInitParameterNames();
		String paraName = "";
		out.println("servlet initParameters: <br/>");
		while(ens.hasMoreElements()){
			paraName = (String) ens.nextElement();
			out.println(paraName + "=" + getInitParameter(paraName));
			out.println("<br/>");
		}
		
		//������Ϣ��
		ServletConfig sc = getServletConfig();
		if(sc != null){
			out.println("servlet name:" + sc.getServletName());
			out.println("<br/>");
		}
		out.println("servlet config initParameters: <br/>");
		ens = sc.getInitParameterNames();
		while(ens.hasMoreElements()){
			paraName = (String) ens.nextElement();
			out.println(paraName + "=" + sc.getInitParameter(paraName));
			out.println("<br/>");
		}
		
		
		//�����Ļ�����
		ServletContext sct = getServletContext();
		if(sct != null){
			out.println("servletInfo:" + sct.getServerInfo() + "&nbsp;&nbsp;");
			out.println("context path: " + sct.getContextPath());
			out.println("<br/>");
		}
		out.println("servlet context initParameter: <br/>");
		ens = sct.getInitParameterNames();
		while(ens.hasMoreElements()){
			paraName = (String) ens.nextElement();
			out.println(paraName + "=" + sct.getInitParameter(paraName));
			out.println("<br/>");
		}

		//ͷ��Ϣ��
		Enumeration e = req.getHeaderNames();
		while(e.hasMoreElements()){
			String name = (String)e.nextElement();
			String value = req.getHeader(name);
			out.println(name + "=" + value);
		}
		
		//��ȡ��������ֵ��
		Enumeration ans = req.getAttributeNames();
		String an = "";
		while(ans.hasMoreElements()){
			an = (String) ans.nextElement();
			out.println("attribute: " + an + "=" + req.getAttribute(an));
			out.println("\n");
		}
		
		//��ȡ���в���ֵ��
		Enumeration aps = req.getParameterNames();
		String ap = "";
		while(aps.hasMoreElements()){
			ap = (String) aps.nextElement();
			out.println("parameter: " + ap + "=" + req.getParameter(ap));
		
		//��¼��־��Ϣ��
		log("������Ϣ--110302");
		
		//request:
		//����֤�����õ�����,���ڱ���servlet
		out.println("authType: " + req.getAuthType());
		out.println("\n");
		
		//���ز��������URI,ָ���������������Ĺ�ϵ(��·��)��
		out.println("contextPath: " + req.getContextPath());
		out.println("<br/>");
		
		//���������������ַ��
		out.println("localAddr: " + req.getLocalAddr());
		out.println("\n");
		
		//�����������������
		out.println("localName: " + req.getLocalName());
		out.println("<br/>");
		
		//��������Ķ˿�
		out.println("localPort: " + req.getLocalPort());
		out.println("\n");
		
		//��������ʽ��
		out.println("method: " + req.getMethod());
		out.println("<br/>");
		
		//����������������Ķ������Ϣ·����
		out.println("pathInfo: " + req.getPathInfo());
		out.println("\n");
		
		//����һЩ��չ��·����Ϣ��
		out.println("pathTranslated: " + req.getPathTranslated());
		out.println("<br/>");
		
		//Э�飺
		out.println("protocol: " + req.getProtocol());
		out.println("\n");
		
		//����Ĳ�������
		out.println("queryString: " + req.getQueryString());
		out.println("<br/>");
		
		//Զ�̵�ַ��
		out.println("remoteAddr: " + req.getRemoteAddr());
		out.println("\n");
		
		//Զ��������
		out.println("remoteHost: " + req.getRemoteHost());
		out.println("<br/>");
		
		out.println("port: " + req.getRemotePort());
		out.println("\n");
		
		//�����û�ʹ����������ע�᣺
		out.println("remoteUser: " + req.getRemoteUser());
		out.println("<br/>");
		
		//����ָ���û���sessionID:
		out.println("requestedSessionId: " + req.getRequestedSessionId());
		out.println("\n");
		
		out.println("requestURI: " + req.getRequestURI());
		out.println("<br/>");
		
		out.println("scheme: " + req.getScheme());
		out.println("\n");
		
		out.println("serverName: " + req.getServerName());
		out.println("<br/>");
		
		out.println("serverPort: " + req.getServerPort());
		out.println("<br/>");
		
		out.println("serverPath: " + req.getServletPath());
		out.println("\n");
		
		//�����URL:
		out.println("requestURL: " + req.getRequestURL());
		out.println("<br/>");
		
		out.println("request headers: <br/>");
		ens = req.getHeaderNames();
		while(ens.hasMoreElements()){
			paraName = (String) ens.nextElement();
			out.println(paraName + "=" + req.getHeader(paraName));
			out.println("<br/>");
		}
		
		//����һ�����飬�������еĿͻ��˷��͵�cookie����
		Cookie[] cks = req.getCookies();
		if(cks != null){
			int iLength = cks.length;
			while(iLength>0){
				Cookie ck = cks[iLength];
				out.println("comment:" + ck.getComment());
				out.println("\n");
				
				out.println("domain:" + ck.getDomain());
				out.println("\n");
				
				out.println("maxAge:" + ck.getMaxAge());
				out.println("\n");
				
				out.println("name:" + ck.getName());
				out.println("\n");
				
				out.println("path:" + ck.getPath());
				out.println("\n");
				
				out.println("value:" + ck.getValue());
				out.println("\n");
				
				out.println("isSecure:" + ck.getSecure());
				out.println("\n");
				
				iLength--;
			}
		}
		
		//response:
		out.println("isCommitted:" + resp.isCommitted());
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
