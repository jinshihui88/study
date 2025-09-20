<%@ page language="java" pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>jsp test page1</title>
  </head>
  
  <body>
    <jsp:forward page="/jspTest/test2.jsp">
    	<jsp:param name="testParam1" value="testValue1" />
    </jsp:forward>
  </body>
</html>
