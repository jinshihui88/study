<%@ page language="java" contentType="text/html;charset=gb2312" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<html>
  <head>
    <title>��½</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
  </head>
  
  <body>
    <form action="<%=basePath %>/el" method="post">
    	<br />
    	
		�û�����<input type="text" name = "userName" id = "userName" /> <br/>
		���룺<input type="password" name = "password" id = "password" /> <br/>
		
		�Ա�<input type="radio" name="sex" value="man" />��  <input type="radio" name="sex" value="female" />Ů<br />
		
		��ѡ����ϲ������Ϸ��
		<input type="checkbox" name="game" value="dota" />DOTA
		<input type="checkbox" name="game" value="LOL" />LOL
		<input type="checkbox" name="game" value="CF" />CF
		<input type="checkbox" name="game" value="CS" />CS
		<input type="checkbox" name="game" value="DNF" />DNF
		<input type="checkbox" name="game" value="SuperMarry" />SuperMarry
		<input type="checkbox" name="game" value="SGS" />����ɱ
		
		<br />
		<input type="submit" value = "��¼" />
	</form>
  </body>
</html>
