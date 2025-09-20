<%@ page language="java" import="model.Student,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.ambow.com" prefix="ambow" %>

<html>
  <head>
    <title>自定义标签的使用测试</title>
    
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
  </head>
  
  <body>
    <form>
    	  <br />
    	  自定义标签的使用：
    	  <br />
    	  <ambow:add2 a1="3" a2="15" />
    </form>
  </body>
</html>
