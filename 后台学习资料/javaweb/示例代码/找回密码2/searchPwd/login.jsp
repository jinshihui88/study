<%@ page contentType="text/html; charset=GBK" %>
<html>
<head>
<title>
登录
</title>
</head>
<body bgcolor="#ffffff">
<h1>欢迎使用本系统!</h1>
<form action="loginservlet" method="POST">
<table border="0">
<tr>
   <td>用户名:</td>
   <td><input type="text" name="username"/></td>
</tr>
<tr>
   <td>密码:</td>
   <td><input type="password" name="password"/></td>
</tr>
<tr>
   <td><input type="submit" name="submit1" value="登录"/></td>
   <td>&nbsp;</td>
</tr>
</table>
<a href="search.jsp">找回密码</a>
</form>
</body>
</html>
