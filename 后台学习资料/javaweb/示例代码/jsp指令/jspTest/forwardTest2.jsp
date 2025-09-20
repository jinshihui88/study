<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>转发目的地页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>
  
  <body>
    <img src="/servletExam1/images/face1.gif" />
    <br />
    <%=request.getParameter("userName") %>
  </body>
</html>
