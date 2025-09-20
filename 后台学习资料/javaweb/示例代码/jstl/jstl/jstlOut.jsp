<%@ page language="java" import="java.util.List, model.UserModel" contentType="text/html;charset=gb2312" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
  <head>
   
    <title>用户主页面</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
  </head>
  
  <body>
    <form >
    	<table border="1px">
    		<tr>
    			<td>用户名</td>
    			<td>性别</td>
    			<td>密码</td>
    			<td>电话</td>
    			<td>身份证</td>
    			<td>地址</td>
    		</tr>
    		
    		<c:forEach items="${ users_list_info }" var="uObj" >
    			<tr>
    				<td>${ uObj.uname }</td>
	    			<td>${ uObj.usex }</td>
	    			<td>${ uObj.upassword }</td>
	    			<td>${ uObj.uphone }</td>
	    			<td>${ uObj.unum }</td>
	    			<td>${ uObj.uaddress }</td>
    			</tr>
    		</c:forEach>
    	</table>

	<c:forEach var="i" begin="1" end="10" step="1">
		<c:out value="${i}" />
		<br />
	</c:forEach>
    	
    	<c:if test="${ 3>2 }">
    		<font color="red"> 红颜色的字体 </font>
    	</c:if>
    	
    	<c:choose>
    		<c:when test="${ 3>2 }">
    			<font color="green"> 绿颜色的字体 </font>
    		</c:when>
    		<c:otherwise>
    			<font color="red"> 红颜色的字体 </font>
    		</c:otherwise>
    	</c:choose>

	<fmt:formatDate value="<%= new java.util.Date() %>" type="both"/>
        <fmt:formatDate value="<%= new java.util.Date() %>" pattern="yyyy/MM/dd"/>
        <fmt:formatNumber value="12.3" pattern=".">
        </fmt:formatNumber>

	<br />
	 <%= new java.util.Date() %>
    <br />
    
    日期：<fmt:formatDate value="<%= new java.util.Date() %>" type="date" />
    <br />
    时间：<fmt:formatDate value="<%= new java.util.Date() %>" type="time" />
    <br />
    日期和时间：<fmt:formatDate value="<%= new java.util.Date() %>" type="both"  />
    <br />
    格式化日期:<fmt:formatDate value="<%= new java.util.Date() %>" type="date" pattern="yyyy/MM/dd"  />
    <br />
    格式化数字：<fmt:formatNumber value="12.9" type="currency" currencySymbol="$"></fmt:formatNumber>
    </form>
  </body>
</html>
