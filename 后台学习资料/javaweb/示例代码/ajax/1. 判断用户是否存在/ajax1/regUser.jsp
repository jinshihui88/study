<%@ page language="java" contentType="text/html;charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>ע��ҳ��</title>
    
    <script type="text/javascript">
    	 //����һ���������ڴ��XMLHttpRequest����    
   		 var xmlHttp; 
   		
   		//�ĺ������ڴ���һ��XMLHttpRequest����    
	    function createXMLHttpRequest(){    
	       if(window.ActiveXObject){  
	           xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");    
	       }else if(window.XMLHttpRequest){    
	           xmlHttp = new XMLHttpRequest();    
	       }
	    }
	    
	    //����һ������AJAX�첽ͨ�ŵķ���    
	    function check(){    
	       //alert("���id�Ƿ��Ѵ���......");    
	       
	       //����һ��XMLHttpRequest����    
	       createXMLHttpRequest();   
	        
	       //��״̬�������󶨵�һ������    
	       xmlHttp.onreadystatechange= processServerTime; 
	          
	       //ͨ��GET������ָ����URL�����������ĵ���,�Ӹ���ʱ�Ĳ���,�Ա��ʾһ��ȫ�µ�����    
	       var url="/servletExam1/userIsExisted?tid="+document.getElementById("tid1").value; //��д���������һ�仰    
	       xmlHttp.open("GET",url,true);    
	       //��������    
	       xmlHttp.send(null);    
	    }

	    //����һ����������״̬�ı�ĺ���    
	    function processServerTime(){    
	    	//alert("readyState: " + xmlHttp.readyState + ",  status: " + xmlHttp.status);
	    	
	       //����һ���������ڴ�Ŵӷ��������ص���Ӧ���
	       var responseContext;    
	       if(xmlHttp.readyState==4){    
	           //�����Ӧ�ɹ�    
	           if(xmlHttp.status==200){    
	               //ȡ������������Ӧ����    
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
  		<input type="button" value="�ύ" />
  	</form>
  </body>
</html>
