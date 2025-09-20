<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>两级联动框架</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="<%= basePath %>/jquery/jquery-1.8.0.min.js"></script>
		
		<script type="text/javascript">
			$(function(){
				//alert("aaaaaaaaaaa");
				
				$("#province").change(function(){
					//alert("bbbbbbbbbbbb");
					
					$.post(
						"<%= basePath%>/showCitys",
						{province_id:$(this).val()},
						function(citys){
							$("#city").empty();
							for(i=0;i<citys.length;i++){
								$("#city").append("<option value="+citys[i].city_id+">"+citys[i].city_name+"</option>");
							}	
						},
						"json"
					);
				});
			});
		</script>
	</head>
	<body>
		<select id="province" name="province">
				<option value="-1">请选择</option>
				<option value="1">河北省</option>
				<option value="2">浙江省</option>
		</select>
		<select id="city" name="citys"></select>
	</body>
</html>