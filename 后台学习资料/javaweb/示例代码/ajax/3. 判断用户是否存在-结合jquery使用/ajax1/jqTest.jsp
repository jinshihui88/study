<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>jquery test</title> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="<%=basePath %>/jquery/jquery-1.8.0.min.js"></script>
	
	<style type="text/css">
		.border1{
			border:1px solid red;
			width: 300px;
			height:200px;
		}
	</style>
	
	<script type="text/javascript">
		$(function (){
			//click:
			$("#submitBtn").bind("click", function(){
				$("#pwdTxt").attr({value: "the seconde text"});
			});
			
			//blur:
			$("#userNameTxt").bind("blur", 
			function (){
				$.post("<%=basePath%>/userIsExisted",
					{tid:$(this).val()}, 
					function(data){
						alert("the return result is: " + data);
						
						$("#div1").text(data);
					}, 
					"html");
			});
			
			//for each:
			/*
			$("div").each(function (){
				alert($(this).text());
			});
			*/
			
			//alert($("#pwdTxt").val());
			
			//alert($("#pwdTxt").attr("value"));
			
			//add css to element:
			//$("#div2").addClass("border1");
			
			//append children elements to parent element:
			//$("#div2").append("<span>span element</span>");
		});
		
	</script>
  </head>
  
  <body> 
    <form id="myForm" name="myForm" action="">
    	<input type="text" id="userNameTxt" name="userNameTxt"  />
    	<br />
    	<input type="text" id="pwdTxt" name="pwdTxt" value="123456"  />
    	<br />
    	<input type="button" id="submitBtn" name="submitBtn" value="submit"  />
    	<br />
    	<div id="div1">div1</div>
    	<p>p dialog 1</p>
    	<div id="div2">div2</div>
    	<p>p dialog 2</p>
    </form>
  </body>
</html>
