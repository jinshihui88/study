<%@ page language="java" contentType="text/html;charset=gb2312" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<html>
  <head>
    <title>EL����ҳ��</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
  </head>
  
  <body>
    <form name="elOutForm" method="post">
		��request�����л�ȡparameter��<br />
		���֣�${ param.userName }<br />
		���룺${ param.password }<br />
		�Ա�${ param.sex }<br />
		ϲ������Ϸ��${ paramValues.game[0] }, ${ paramValues.game[1] }
		
		
		<br /><br /><br />
		��request�����л�ȡattribute:<br />
		${ success }
		<br />
		${ error }
		
		<br /><br /><br />
		��session�����л�ȡattribute:
		${ session_info }
		
		<br /><br /><br />
		���ʽ��ֵ��<br />
		${ 2+3 },  ${ 2<3 },  ${ 2>3 && 5<6 }
	</form>
  </body>
</html>
