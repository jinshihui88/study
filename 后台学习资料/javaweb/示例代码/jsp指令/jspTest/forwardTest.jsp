<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>转发测试</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>
  
  <body> 
    <form action="">
    	<jsp:forward page="forwardTest2.jsp">
    		<jsp:param name="userName" value="wangr"/>
    	</jsp:forward>
    </form>
  </body>
</html>
