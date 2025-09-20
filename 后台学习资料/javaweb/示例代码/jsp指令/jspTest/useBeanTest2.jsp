<%@ page import="hbjr1108.jspTest.Card" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>include test</title>
  </head>
  <body>
    <jsp:useBean id="test1" class="hbjr1108.jspTest.Card" scope="page" >
      <jsp:setProperty name="test1" property="cardid" value="300" />
      <jsp:setProperty name="test1" property="password" value="200" />
    </jsp:useBean>
    <jsp:setProperty name="test1" property="cardid" value="400" /><br/>
    <jsp:getProperty name="test1" property="cardid" /><br/>
    <jsp:getProperty name="test1" property="password" />
  </body>
</html>