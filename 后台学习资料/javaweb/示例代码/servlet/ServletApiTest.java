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
		
		//初始化参数：
		Enumeration ens = getInitParameterNames();
		String paraName = "";
		out.println("servlet initParameters: <br/>");
		while(ens.hasMoreElements()){
			paraName = (String) ens.nextElement();
			out.println(paraName + "=" + getInitParameter(paraName));
			out.println("<br/>");
		}
		
		//配置信息：
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
		
		
		//上下文环境：
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

		//头信息：
		Enumeration e = req.getHeaderNames();
		while(e.hasMoreElements()){
			String name = (String)e.nextElement();
			String value = req.getHeader(name);
			out.println(name + "=" + value);
		}
		
		//读取所有属性值：
		Enumeration ans = req.getAttributeNames();
		String an = "";
		while(ans.hasMoreElements()){
			an = (String) ans.nextElement();
			out.println("attribute: " + an + "=" + req.getAttribute(an));
			out.println("\n");
		}
		
		//读取所有参数值：
		Enumeration aps = req.getParameterNames();
		String ap = "";
		while(aps.hasMoreElements()){
			ap = (String) aps.nextElement();
			out.println("parameter: " + ap + "=" + req.getParameter(ap));
		
		//记录日志信息：
		log("测试信息--110302");
		
		//request:
		//返回证明配置的名字,用于保护servlet
		out.println("authType: " + req.getAuthType());
		out.println("\n");
		
		//返回部分请求的URI,指出这个请求的上下文关系(根路径)：
		out.println("contextPath: " + req.getContextPath());
		out.println("<br/>");
		
		//发送请求的主机地址：
		out.println("localAddr: " + req.getLocalAddr());
		out.println("\n");
		
		//发送请求的主机名称
		out.println("localName: " + req.getLocalName());
		out.println("<br/>");
		
		//发送请求的端口
		out.println("localPort: " + req.getLocalPort());
		out.println("\n");
		
		//返回请求方式：
		out.println("method: " + req.getMethod());
		out.println("<br/>");
		
		//返回与请求想关联的额外的信息路径：
		out.println("pathInfo: " + req.getPathInfo());
		out.println("\n");
		
		//返回一些扩展的路径信息：
		out.println("pathTranslated: " + req.getPathTranslated());
		out.println("<br/>");
		
		//协议：
		out.println("protocol: " + req.getProtocol());
		out.println("\n");
		
		//请求的参数串：
		out.println("queryString: " + req.getQueryString());
		out.println("<br/>");
		
		//远程地址：
		out.println("remoteAddr: " + req.getRemoteAddr());
		out.println("\n");
		
		//远程主机：
		out.println("remoteHost: " + req.getRemoteHost());
		out.println("<br/>");
		
		out.println("port: " + req.getRemotePort());
		out.println("\n");
		
		//返回用户使用这个请求的注册：
		out.println("remoteUser: " + req.getRemoteUser());
		out.println("<br/>");
		
		//返回指定用户的sessionID:
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
		
		//请求的URL:
		out.println("requestURL: " + req.getRequestURL());
		out.println("<br/>");
		
		out.println("request headers: <br/>");
		ens = req.getHeaderNames();
		while(ens.hasMoreElements()){
			paraName = (String) ens.nextElement();
			out.println(paraName + "=" + req.getHeader(paraName));
			out.println("<br/>");
		}
		
		//返回一个数组，包含所有的客户端发送的cookie对象
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
