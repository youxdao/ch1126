<%@ page import="entity.User" %>
<%@ page import="entity.Msg" %>
<%@ page import="dao.UserDao" %>
<%@ page import="dao.Impl.UserDaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css" rel="stylesheet">
        body {
            margin: 0px;
            padding: 0px;

        }

        ul li {
            list-style-type: none;
            margin-bottom: 10px;
            border-bottom: 1px aliceblue dashed;
        }

        .wrapper {
            width: 800px;
            font-size: 14px;
            border: 1px black solid;
        }

        .wrapper .menu {
            width: 100%;
            float: right;
            background-color: aliceblue;
            padding: 10px;
        }

        .wrapper .menu span {
            margin-left: 5px;
        }

        .wrapper .menu span a {
            text-decoration: none;
            margin-left: 15px;
            color: cornflowerblue;
        }

        .wrapper div {
            padding: 5px;
            margin: 5px;
        }

        .rfloat {
            float: right;
        }

        .red {
            color: red;
        }

        .clear {
            clear: both;
        }

        ul li span {
            margin-right: 5px;
        }

        .bordstyle {
            font-weight: bolder;
        }

        .content {
            border: 1px gainsboro solid;
            background-color: azure;
        }

        .content-top span {
            margin-right: 10px;
        }

    </style>
</head>
<body>
<%
    UserDao userDao = new UserDaoImpl();
    User user = (User) session.getAttribute("user");
//    Msg msgDetail= (Msg) request.getAttribute("msgDetails");
//    User fromUser =userDao.queryUserById(msgDetail.getFromUId());
%>
<div class="wrapper">
    <form action="<%=basePath%>msg.do">
        <input type="hidden" name="action" value="send"/>
        <div class="header">
            <div class="menu">
                <span>当前用户：<%=user.getUsername()%></span><span></span>
                <span><a href="logout.jsp">退出</a></span>
            </div>
        </div>
        <div class="clear"></div>
        <div class="content">
            <div class="content-top">
                <span>标题：<input name="mTitle" type="text"/></span>
                <span>收件人邮箱：<input name="email" type="text"/></span>
            </div>
            &nbsp;&nbsp;内容:<br/>
            <div class="content-body">
            <textarea name="mContent" rows="20  " cols="70">
            </textarea>
            </div>
            <div>
                <span><button type="submit">发送</button></span>
            </div>

        </div>
    </form>

</div>
</body>
</html>
