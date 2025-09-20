<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>静态包含与动态包含测试</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>
  
  <body> 
    <form action="">
    	<input type="text" value="文本框" />
    	<br />
    	<%--@ include file="jsp2.jsp" --%>
    	
    	<jsp:include page="jsp2.jsp">
    		<jsp:param name="userName" value="wr"/>
    	</jsp:include>
    </form>
  </body>
</html>
