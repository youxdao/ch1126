<%--
  Created by IntelliJ IDEA.
  User: youji
  Date: 2020/12/2
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结果</title>
    <%
        String msgResult= (String) request.getAttribute("msgResult");
    %>
</head>
<body>
<%=msgResult%>
</body>
</html>
