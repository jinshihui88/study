<%@ page language="java" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册页面r</title>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<script type="text/javascript" src="<%=basePath %>/jquery/jquery-1.8.0.min.js"></script>
	<style type="text/css">
		.b1{
			border:3px  red  dashed;
		}
		.b2{
			border:3px  green  dashed;
		}
		
		.b3{
			border:3px  blue  dashed;
		}
	</style>
	
	<script type="text/javascript">
		$(
			function(){
				//alert("vvvv");
				//1.获取元素对象：
				//var obj = $("#uname");
				//alert(obj);
				
				//2. 操作元素对象的属性：
				//$("#uname").attr("value","陈和萍");
				//$("input[type='radio'][value='女']").attr("checked", true);
				//2.1 获取属性值：
				//var pwd = $("#upassword").attr("value");
				//alert(pwd);
				//2.2 改变属性值：
				//$("#uphone").attr("value","15010725865");
				//$("#unum").attr({value:"166",title:"请输入身份证号" });
				
				//3.操作css：
				//3.1 为元素添加一个样式表：
				//$("div").addClass("b1");
				//3.2 移除样式表：
				//$("div").removeClass("b2");
				//3.3 操作样式表的属性：
				//var vc = $("div").css("color");
				//alert(vc);
				
				//$("div").css("color","green");
				
				//4. 为元素绑定事件：
				var count=0;
				$("div").click(function(){
					//切换样式表：
					$("div").toggleClass("b3",  (count++)%2 ==0);
				});
				
				$("#uname").blur(function(){
					
					$.post("<%=basePath%>/cnu",
					{uname:$(this).val()},
					function(data){
						alert("thie server infomation is : " + data);
						
						$("#resultArea").text(data);
					}
					,"html");
				});
				
				
				//5. 操作子元素：
				//$("p").append("<b>狄凯</b>");
			}
		);
	</script>
  </head>
  
  <body>
  	<form action="" method="post" name="register_form">
  		用户姓名：<input type="text" name="uname" id="uname" value="uu" ><span id="resultArea" style="color:red;"></span><br><br>
  		用户密码：<input type="password" name="upassword" id="upassword" value="123"><br><br>
  		性别：<input type="radio" name="usex" id="usexm" value="男">男
  		<input type="radio" name="usex" id="usexf" value="女">女<br><br>
  		用户电话：<input type="text" name="uphone" id="uphone" value="4444444"><br><br>
  		身份证号：<input type="text" name="unum" id="unum" value="555"><br><br>
  		用户住址：<input type="text" name="uaddress" id="uaddress" value="666"><br><br>
  		<div >
  			div框框
  		</div>
  		<p>
  			p段落
  		</p>
  		<input type="button" value="注册">
  	</form>
  </body>
</html>
