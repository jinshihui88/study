<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
<script type="text/javascript">
	function fun_back() {
		var pageId = parseInt(document.testForm.pageId.value);
		if (1 == pageId) {
			alert("已经是第一页，没有上一页了！");
		} else {
			pageId = pageId - 1;
			document.testForm.pageId.value = pageId;
			document.testForm.submit();

		}
	}

	function fun_next() {
		var pageId = parseInt(document.testForm.pageId.value);
		var count = parseInt(document.testForm.count.value);

		if (count == pageId) {
			alert("已经是最后一页，没有下一页了！");
		} else {
			pageId = pageId + 1;
			document.testForm.pageId.value = pageId;
			document.testForm.submit();
		}
	}
	
	function fun_Link(id) {
		alert(id);
		document.testForm.pageId.value = id;
		//document.testForm.submit();
	}
</script>
</head>
<body>
	<form action="<%=request.getContextPath()%>/TestServlet"
		name="testForm" method="post" target="_self">
		<table>
			<tr>
				<td>ID</td>
				<td>姓名</td>
				<td>密码</td>
			</tr>
			<c:forEach items="${ tmList }" var="obj">
				<tr>
					<td>${ obj.id }</td>
					<td>${ obj.name }</td>
					<td>${ obj.pwd }</td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="button" value="上一页" name="back"
					onclick="fun_back()" /></td>
				<td></td>
				<td><input type="button" value="下一页" name="next"
					onclick="fun_next()" /></td>
			</tr>
			<tr>
				<td colspan="3">
				
				<c:forEach var="i" begin="1" end="${ count }" step="1">
					<a href="<%=request.getContextPath()%>/TestServlet?pageId=${ i }">[${ i }]</a>
				</c:forEach>
				</td>
			</tr>

		</table>
		<input type="hidden" value="${ count }" name="count" /> <input
			type="hidden" name="pageId" value="${ pageId }" />
	</form>
</body>
</html>