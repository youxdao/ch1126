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
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script>
        $(function () {
            $("#ajaxbtn").click(function () {
                var mTitle=$("#mTitle").val();
                var email=$("#email").val();
                // var mContent=$(".content-body").val();

                $.ajax({
                    url:"http://localhost:80/days1126/msg.do",
                    data:{action:"send",mTitle:mTitle,email:email,mContent:editor.txt.html()},
                    type:"GET",
                    dataType:"text",
                    success:function (data) {
                        alert(data);
                        // var jsonObj=JSON.parse(data);
                    }
                });
            });
        });
    </script>
</head>
<body>
<%
    UserDao userDao = new UserDaoImpl();
    User user = (User) session.getAttribute("user");
//    Msg msgDetail= (Msg) request.getAttribute("msgDetails");
//    User fromUser =userDao.queryUserById(msgDetail.getFromUId());
%>
<div class="wrapper">
    <form>
        <div class="header">
            <div class="menu">
                <span>当前用户：<%=user.getUsername()%></span><span></span>
                <span><a href="logout.jsp">退出</a></span>
            </div>
        </div>
        <div class="clear"></div>
        <div class="content">
            <div class="content-top">
                <span>标题：<input name="mTitle" type="text" id="mTitle"/></span>
                <span>收件人邮箱：<input name="email" type="text" id="email"/></span>
            </div>
            &nbsp;&nbsp;内容:<br/>
            <div class="content-body">
            </div>
            <script type="text/javascript" src="https://unpkg.com/wangeditor/dist/wangEditor.min.js"></script>
            <script type="text/javascript">
                const E=window.wangEditor;
                const editor = new E('.content-body');
                // 或者 const editor = new E( document.getElementById('div1') )
                editor.config.uploadImgServer='http://localhost:80/days1126/imageUpload';
                editor.create();
            </script>
            <div>
                <span><button type="submit" id="ajaxbtn">发送</button></span>
            </div>

        </div>
    </form>

</div>
</body>
</html>
