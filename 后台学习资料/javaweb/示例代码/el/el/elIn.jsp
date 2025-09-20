<%@ page language="java" contentType="text/html;charset=gb2312" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<html>
  <head>
    <title>登陆</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
  </head>
  
  <body>
    <form action="<%=basePath %>/el" method="post">
    	<br />
    	
		用户名：<input type="text" name = "userName" id = "userName" /> <br/>
		密码：<input type="password" name = "password" id = "password" /> <br/>
		
		性别：<input type="radio" name="sex" value="man" />男  <input type="radio" name="sex" value="female" />女<br />
		
		请选择你喜欢的游戏：
		<input type="checkbox" name="game" value="dota" />DOTA
		<input type="checkbox" name="game" value="LOL" />LOL
		<input type="checkbox" name="game" value="CF" />CF
		<input type="checkbox" name="game" value="CS" />CS
		<input type="checkbox" name="game" value="DNF" />DNF
		<input type="checkbox" name="game" value="SuperMarry" />SuperMarry
		<input type="checkbox" name="game" value="SGS" />三国杀
		
		<br />
		<input type="submit" value = "登录" />
	</form>
  </body>
</html>
