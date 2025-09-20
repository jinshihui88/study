<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>js 练习</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">

	<script type="text/javascript">
		function change(){
			//基础语法：
			
			//操作页面标签，标签属性及其css属性：
			//1. 获取标签对象：
			//var obj = document.getElementById("txt1");
			//var obj = document.getElementsByName("txt1");
			//alert(obj[0].value + ",   " + obj[1].value + ",  " + obj.length);
			
			//2. 操作标签对象的属性：
			var obj = document.getElementById("txt1");
			//alert(obj.type);
			//obj.value = "文本框值被更改";
			
			//3. 操作标签对象css属性：
			obj.style.color = "#ff0000";
			alert(obj.style.color);
			
			//var obj = document.getElementById("txt1");
			//obj.value = "做梦";
		}
	</script>	
  </head>
  
  <body>
    <form>
    	<input type="text" name="txt1" id="txt1" value="我们都会努力完成作业的" />
    	<div style="border:2px green dashed;">
    		老师放心
    	</div>
    	<input name="txt1" type="button" value="更改" onclick="change();" />
    </form>
  </body>
</html>
