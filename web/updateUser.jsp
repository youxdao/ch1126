<%@ page import="entity.User" %>
<%@ page import="entity.Msg" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: youji
  Date: 2020/12/1
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css" rel="stylesheet">
        .wrapper {
            width: 500px;
            font-size: 14px;
            border: 1px black solid;
        }

        .wrapper .title {
            font-weight: bold;
            font-size: 18px;
            background-color: aliceblue;
            padding: 10px;
        }

        .wrapper div {
            padding: 5px;
            margin: 5px;
        }

        .red {
            color: red;
        }
    </style>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    List<Msg> msgList = (List<Msg>) request.getAttribute("msg");
%>
<div class="wrapper">
    <div class="title">修改个人信息</div>
    <form action="<%=basePath%>user.do"  method="post" enctype="multipart/form-data">
        <input type="hidden" name="action" value="update">
        <div>
            用户名<span class="red">*</span>
            <span><input type="text" name="username" id="username" value="<%=user.getUsername()%>"></span>
        </div>
        <div>
            密码<span class="red">*</span>
            <span><input type="text" name="password" id="password" value="<%=user.getPassword()%>"></span>
        </div>
        <div>
            邮箱<span class="red">*</span>
            <span><input type="text" name="email" id="email" value="<%=user.getEmail()%>" ></span>
        </div>
        <div>
            头像<span class="red">*</span>
            <span><input type="file" name="imgPath" id="imgPath"></span>
        </div>
        <div>
            <span><button type="submit">修改</button></span>
        </div>
    </form>
</div>
</body>
</html>
