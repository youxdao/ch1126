
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
<%
    session.invalidate();
    response.sendRedirect("login.jsp");
%>
