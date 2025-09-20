<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
	$.ajaxSetup({
	 
	  cache: false
	  
	});
	
		
	$(function(){
		$("#send").bind("click",function(event){
			
			$.post("send.do",
					{"mes":$("#mymes").val()},
					function(mess){
						$("#mymes").val("");
						$("#allmes").html(mess);
						
					}
				);
			}
		);
		
		
		$("#mymes").bind("keydown",function(event){
				if(event.keyCode==13){
					$.post("send.do",
							{"mes":$("#mymes").val()},
							function(mess){
								$("#mymes").val("");
								$("#allmes").html(mess);
								
							}
					);
				}
			}
		);
	});
	
	function reflesh(){
		
		$.post("reflesh.do",
				function(mess){
					$("#allmes").html(mess);
				}
		);
		myreflesh=setTimeout("reflesh()", 2000);
	};
	function stopreflesh(){
		clearTimeout(myreflesh);                                                                                                                                                                                                                                                                                                                                                                                                                                         
	}
</script>
</head>
<body onload="reflesh(),test()">
<div>
	<textarea rows="20" cols="70" id="allmes"></textarea>
	
	<input type="text" name="mes" id="mymes" size="60" />
	<input type="button" value="发送" id="send"/><br/>
	<input type="button" value="锁屏" onclick="stopreflesh();" />
	<input type="button" value="解锁" onclick="reflesh();" />
</div>
</body>
</html>