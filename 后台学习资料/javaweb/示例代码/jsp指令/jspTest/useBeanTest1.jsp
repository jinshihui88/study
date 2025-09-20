<%@ page import="hbjr1108.jspTest.Card" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>include test</title>
  </head>
  <body>
    <jsp:useBean id="test1" class="hbjr1108.jspTest.Card" scope="page" />
    <% 
      test1.setCardid("200");
      test1.setPassword("eniyah");
    %>
    <%=test1.getCardid() %><br/>
    <%=test1.getPassword() %>
  </body>
</html>