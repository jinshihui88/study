<%@ page language="java" import="java.util.List, model.UserModel" contentType="text/html;charset=gb2312" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
  <head>
   
    <title>�û���ҳ��</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
  </head>
  
  <body>
    <form >
    	<table border="1px">
    		<tr>
    			<td>�û���</td>
    			<td>�Ա�</td>
    			<td>����</td>
    			<td>�绰</td>
    			<td>���֤</td>
    			<td>��ַ</td>
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
    		<font color="red"> ����ɫ������ </font>
    	</c:if>
    	
    	<c:choose>
    		<c:when test="${ 3>2 }">
    			<font color="green"> ����ɫ������ </font>
    		</c:when>
    		<c:otherwise>
    			<font color="red"> ����ɫ������ </font>
    		</c:otherwise>
    	</c:choose>

	<fmt:formatDate value="<%= new java.util.Date() %>" type="both"/>
        <fmt:formatDate value="<%= new java.util.Date() %>" pattern="yyyy/MM/dd"/>
        <fmt:formatNumber value="12.3" pattern=".">
        </fmt:formatNumber>

	<br />
	 <%= new java.util.Date() %>
    <br />
    
    ���ڣ�<fmt:formatDate value="<%= new java.util.Date() %>" type="date" />
    <br />
    ʱ�䣺<fmt:formatDate value="<%= new java.util.Date() %>" type="time" />
    <br />
    ���ں�ʱ�䣺<fmt:formatDate value="<%= new java.util.Date() %>" type="both"  />
    <br />
    ��ʽ������:<fmt:formatDate value="<%= new java.util.Date() %>" type="date" pattern="yyyy/MM/dd"  />
    <br />
    ��ʽ�����֣�<fmt:formatNumber value="12.9" type="currency" currencySymbol="$"></fmt:formatNumber>
    </form>
  </body>
</html>
