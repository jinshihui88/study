<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>分页练习</title>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"> 
  </head>
  
  <body>
    <form name="myForm" action="">
    	<table border="1px" width="500px">
    		<tr>
    			<td>员工编号</td>
    			<td>员工姓名</td>
    			<td>岗位</td>
    			<td>受雇日期</td>
    			<td>工资</td>
    			<td>奖金</td>
    		</tr>
    		<c:forEach items="${requestScope.empInfoList}" var="empObj">
    			<tr>
	    			<td>${ empObj.empno1 }</td>
	    			<td>${ empObj.empname1 }</td>
	    			<td>
	    				<c:choose>
	    					<c:when test="${empty empObj.job}">
	    						&nbsp;
	    					</c:when>
	    					<c:otherwise>
	    						${ empObj.job }
	    					</c:otherwise>
	    				</c:choose>
	    			</td>
	    			<td>
	    				<c:choose>
	    					<c:when test="${empty empObj.hiredate1}">
	    						&nbsp;
	    					</c:when>
	    					<c:otherwise>
	    						${ empObj.hiredate1 }
	    					</c:otherwise>
	    				</c:choose>
	    			</td>
	    			<td>
	    				<c:choose>
	    					<c:when test="${empObj.salary <= 0}">
	    						&nbsp;
	    					</c:when>
	    					<c:otherwise>
	    						${ empObj.salary }
	    					</c:otherwise>
	    				</c:choose>
	    			</td>
	    			<td>
	    				<c:choose>
	    					<c:when test="${empObj.bound <= 0}">
	    						&nbsp;
	    					</c:when>
	    					<c:otherwise>
	    						${ empObj.bound }
	    					</c:otherwise>
	    				</c:choose>
	    			</td>
	    		</tr>
    		</c:forEach>
    		<tr>
    			<td colspan="6" align="right">
    				<a href="<%=basePath %>/page?currentPage=1">[1]</a>
    				<a href="<%=basePath %>/page?currentPage=2">[2]</a>
    				<a href="<%=basePath %>/page?currentPage=3">[3]</a>
    				<a href="<%=basePath %>/page?currentPage=4">[4]</a>
    				<a href="<%=basePath %>/page?currentPage=5">[5]</a>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
