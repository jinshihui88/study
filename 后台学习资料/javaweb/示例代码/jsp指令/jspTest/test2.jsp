<%@ page language="java" pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>jsp test page1</title>
  </head>
  
  <body>
    <%= request.getParameter("testParam1") %><br />
    <%= request.getParameter("testParam2") %>
  </body>
</html>
