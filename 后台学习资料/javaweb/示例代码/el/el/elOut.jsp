<%@ page language="java" contentType="text/html;charset=gb2312" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<html>
  <head>
    <title>EL测试页面</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
  </head>
  
  <body>
    <form name="elOutForm" method="post">
		从request对象中获取parameter：<br />
		名字：${ param.userName }<br />
		密码：${ param.password }<br />
		性别：${ param.sex }<br />
		喜欢的游戏：${ paramValues.game[0] }, ${ paramValues.game[1] }
		
		
		<br /><br /><br />
		从request对象中获取attribute:<br />
		${ success }
		<br />
		${ error }
		
		<br /><br /><br />
		从session对象中获取attribute:
		${ session_info }
		
		<br /><br /><br />
		表达式的值：<br />
		${ 2+3 },  ${ 2<3 },  ${ 2>3 && 5<6 }
	</form>
  </body>
</html>
