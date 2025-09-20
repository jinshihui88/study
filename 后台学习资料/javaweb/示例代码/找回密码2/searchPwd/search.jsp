<%@ page contentType="text/html; charset=GBK" %>
<html>
<head>
<title>
请输入用户名和email
</title>
</head>
<body bgcolor="#ffffff">
<h1>欢迎使用本系统!</h1>
<form action="searchservlet" method="POST">
<table border="0">
<tr>
   <td>用户名:</td>
   <td><input type="text" name="username"/></td>
</tr>
<tr>
   <td>EMAIL:</td>
   <td><input type="text" name="email"/></td>
</tr>
<tr>
   <td><input type="submit" name="submit1" value="确定"/></td>
   <td>&nbsp;</td>
</tr>
</table>
<a href="login.jsp">返回</a>
</form>
</body>
</html>
