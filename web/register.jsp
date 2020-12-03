<%--
  Created by IntelliJ IDEA.
  User: lintao
  Date: 2020/7/28
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
<html>
<head>
    <title>Title</title>

    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>

    <script type="text/javascript">
        $(function () {
           $("#username").blur(function () {
               var username=$("#username").val();
               $.ajax({
                   url:"http://localhost:80/days1126/user.do",
                   data:{action:"queryUserByUsername",username:username},
                   type:"GET",
                   dataType:"text",//返回的数据类型
                   success:function (data) {
                       // alert(data);
                       // var jsonObj=JSON.parse(data);
                       $("#usernameMsg").html(data);
                       }
               });
           });
           $("#email").blur(function () {
               var email=$("#email").val();
              $.ajax({
                  url:"http://localhost:80/days1126/user.do",
                  data:{action:"queryUserByEmail",email:email},
                  type:"GET",
                  dataType:"text",//返回的数据类型
                  success:function (data) {
                      // alert(data);
                      // var jsonObj=JSON.parse(data);
                      $("#emailMsg").html(data);
                  }
              })
           });
        });
    </script>
    <style type="text/css" rel="stylesheet">
        .wrapper{
            width: 500px;
            font-size: 14px;
            border: 1px black solid ;
        }
        .wrapper .title{
            font-weight: bold;
            font-size: 18px;
            background-color: aliceblue;
            padding: 10px;
        }
        .wrapper div{
            padding: 5px;
            margin: 5px;
        }
        .red{
            color: red;
        }
    </style>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>
<div class="wrapper">
    <div class="title">欢迎注册</div>
    <form action="<%=basePath%>user.do" method="post" enctype="multipart/form-data">
        <input type="hidden" name="action" value="register">
        <div>
            用户名<span class="red">*</span>
            <span><input type="text" name="username" id="username"></span>
            <span id="usernameMsg"></span>
        </div>
        <div>
            密码<span class="red">*</span>
            <span><input type="password" name="password" id="password"></span>
        </div>
        <div>
            确认密码<span class="red">*</span>
            <span><input type="password" name="repassword" id="repassword"></span>
        </div>
        <div>
            邮箱<span class="red">*</span>
            <span><input type="text" name="email" id="email"></span>
            <span id="emailMsg"></span>
        </div>
        <div>
            头像<span class="red">*</span>
            <span><input type="file" name="imgPath" id="imgPath"></span>
        </div>
        <div>
            <span><button type="submit">注册</button></span>
        </div>
    </form>
</div>
</body>
</html>

