<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<link rel="stylesheet" href="css/css.css" type="text/css"></link></head>
<body>
	<table class="table5">
		<tr>
			<td>编号</td>
			<td>用户名</td>
			<td>密码</td>
			<td>邮件</td>
		</tr>
		<c:choose>
			<c:when test="${empty users}">
				<tr>
					<td colspan=4>没有数据</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${users}" var="u">
					<tr>
						<td>${u.id }</td>
						<td>${u.username }</td>
						<td>${u.userpwd }</td>
						<td>${u.email }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan=4>
						共${pc.totalPages }页&nbsp;当前第${pc.currentPage }页
						<c:choose>
							<c:when test="${pc.hasPrevious}">
								<a href="UserShowServlet?page=${pc.currentPage-1}">上一页</a>||
							</c:when>
							<c:otherwise>
								上一页
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${pc.hasNext}">
								<a href="UserShowServlet?page=${pc.currentPage+1}">下一页</a>
							</c:when>
							<c:otherwise>
								下一页
							</c:otherwise>
						</c:choose>
						
					</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>