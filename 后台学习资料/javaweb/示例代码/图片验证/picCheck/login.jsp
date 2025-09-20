<%@ page language="java" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>图片验证测试</title>
	
	<link href="<%=basePath %>css/css.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath %>/jquery/jquery-1.8.0.min.js"></script>
	
	<script type="text/javascript">
			$(function(){
				$("#changePicBtn").toggle( 
					function () {$("#img").attr("src","/servletExam1/CodeServlet1.code");},
					function () {$("#img").attr("src","/servletExam1/CodeServlet.code");}
					); 
			}
			);
				
		</script>


</head>

<body>
	<form action="" method="post">
    <font color="red"><span id="msgs">${msgs}</span></font><br>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="31%" height="35" class="login-text02">用户名称：<br /></td>
        <td width="69%"><input name="wname" type="text" size="30" /></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">密　码：<br /></td>
        <td><input name="wpassword" type="password" size="33" /></td>
      </tr>
      
      <tr>
        <td height="35" class="login-text02">请输入验证码：</td>
        <td><input name="inputcode" id="inputcode" type="text" size="30" /> <img src="/servletExam1/CodeServlet.code" id="img">
      
             <input type="button" value="换一张" id="changePicBtn"><br>
      </tr>
      <tr>
        <td height="35">&nbsp;</td>
        <td><input name="Submit2" type="submit" class="right-button01" value="确认登陆"  />
          <input name="Submit232" type="reset" class="right-button02" value="重 置" /></td>
      </tr>
    </table>
    </form>
</body>
</html>
