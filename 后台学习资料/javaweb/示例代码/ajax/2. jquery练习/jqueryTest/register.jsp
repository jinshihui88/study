<%@ page language="java" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>ע��ҳ��r</title>
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
				//1.��ȡԪ�ض���
				//var obj = $("#uname");
				//alert(obj);
				
				//2. ����Ԫ�ض�������ԣ�
				//$("#uname").attr("value","�º�Ƽ");
				//$("input[type='radio'][value='Ů']").attr("checked", true);
				//2.1 ��ȡ����ֵ��
				//var pwd = $("#upassword").attr("value");
				//alert(pwd);
				//2.2 �ı�����ֵ��
				//$("#uphone").attr("value","15010725865");
				//$("#unum").attr({value:"166",title:"���������֤��" });
				
				//3.����css��
				//3.1 ΪԪ�����һ����ʽ��
				//$("div").addClass("b1");
				//3.2 �Ƴ���ʽ��
				//$("div").removeClass("b2");
				//3.3 ������ʽ������ԣ�
				//var vc = $("div").css("color");
				//alert(vc);
				
				//$("div").css("color","green");
				
				//4. ΪԪ�ذ��¼���
				var count=0;
				$("div").click(function(){
					//�л���ʽ��
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
				
				
				//5. ������Ԫ�أ�
				//$("p").append("<b>�ҿ�</b>");
			}
		);
	</script>
  </head>
  
  <body>
  	<form action="" method="post" name="register_form">
  		�û�������<input type="text" name="uname" id="uname" value="uu" ><span id="resultArea" style="color:red;"></span><br><br>
  		�û����룺<input type="password" name="upassword" id="upassword" value="123"><br><br>
  		�Ա�<input type="radio" name="usex" id="usexm" value="��">��
  		<input type="radio" name="usex" id="usexf" value="Ů">Ů<br><br>
  		�û��绰��<input type="text" name="uphone" id="uphone" value="4444444"><br><br>
  		���֤�ţ�<input type="text" name="unum" id="unum" value="555"><br><br>
  		�û�סַ��<input type="text" name="uaddress" id="uaddress" value="666"><br><br>
  		<div >
  			div���
  		</div>
  		<p>
  			p����
  		</p>
  		<input type="button" value="ע��">
  	</form>
  </body>
</html>
