<%@ page language="java" contentType="text/html;charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册页面</title>
    
    <script type="text/javascript">
    	 //定义一个变量用于存放XMLHttpRequest对象    
   		 var xmlHttp; 
   		
   		//改函数用于创建一个XMLHttpRequest对象    
	    function createXMLHttpRequest(){    
	       if(window.ActiveXObject){  
	           xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");    
	       }else if(window.XMLHttpRequest){    
	           xmlHttp = new XMLHttpRequest();    
	       }
	    }
	    
	    //这是一个启动AJAX异步通信的方法    
	    function check(){    
	       //alert("检查id是否已存在......");    
	       
	       //创建一个XMLHttpRequest对象    
	       createXMLHttpRequest();   
	        
	       //将状态触发器绑定到一个函数    
	       xmlHttp.onreadystatechange= processServerTime; 
	          
	       //通过GET方法向指定的URL建立服务器的调用,加个临时的参数,以便表示一个全新的请求    
	       var url="/servletExam1/userIsExisted?tid="+document.getElementById("tid1").value; //等写完回来看这一句话    
	       xmlHttp.open("GET",url,true);    
	       //发送请求    
	       xmlHttp.send(null);    
	    }

	    //这是一个用来处理状态改变的函数    
	    function processServerTime(){    
	    	//alert("readyState: " + xmlHttp.readyState + ",  status: " + xmlHttp.status);
	    	
	       //定义一个变量用于存放从服务器返回的响应结果
	       var responseContext;    
	       if(xmlHttp.readyState==4){    
	           //如果响应成功    
	           if(xmlHttp.status==200){    
	               //取出服务器的响应内容    
	               responseContext=xmlHttp.responseText;    
	               //alert("response: " + responseContext);
	               
	               document.getElementById("dtid").innerHTML=responseContext;
	           }    
	       }    
	    }
    </script>
  </head>
  
  <body>
  	<form name="testForm" action="" method="post">
  		id: <input type="text" name="tid1" id="tid1" onblur="check()" />&nbsp;<span id="dtid"></span>
  		<br />
  		name: <input type="text" name="tname" /><br>
  		<input type="button" value="提交" />
  	</form>
  </body>
</html>
