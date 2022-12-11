<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<!DOCTYPE html>--%>
<%--<html lang="EN">--%>

<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <%
        String basePath = request.getScheme()
                + "://"
                + request.getServerName()
                + ":"
                + request.getServerPort()
                + request.getContextPath()
                + "/";
    %>
    <%--    <%=basePath%>--%>
    <base href="<%=basePath%>">
</head>
<script src="static/Jquery.js"></script>
<style>
    * {
        padding: 0;
        margin: 0;
    }

    body {
        background-color: rgb(82, 139, 180);
    }

    .box1 {
        height: 100px;

    }

    .box1 span {
        float: left;
        font-size: 43px;
        margin-top: 18px;
        margin-left: 50px;
    }

    .box2 {
        height: 500px;
    }

    .box2_001 {
        width: 200px;
        height: 30px;
        font-size: 36px;
        padding-left: 230px;
        padding-top: 200px;
        float: left;

    }


    .box2_002 {
        list-style: none;
        float: right;
        width: 400px;
        background-color: rgb(252, 254, 254);
        border: 0.5px black solid;
        margin-right: 544px;
        margin-top: 176px;
        padding-bottom: 20px;
    }

    .box2_002_001 {
        margin-left: 57px;
        margin-top: 17px;
        font-size: 29px;
    }


    .box2_002_002 {
        text-decoration: none;
        margin-top: 23px;
        margin-right: 23px;
        font-size: 26px;
    }
    .box2_002_002:hover{
        color: rgb(0, 161, 214);
    }

    .box2_002_003 {
        margin-top: 32px;
        margin-left: 33px;
    }

    .box2_002_003_futh {
        margin-top: -3px;
    }

    .box2_002_003_001 {
        padding-right: 15px;
    }
    .box2_002_003_002 {
        margin-left: -16px;
    }

    .box2_002_003_003 {
        height: 41px;
        width: 90px;
    }

    .box2_002_003_004 {
        /*height: 5px;*/
    }

    .box2_002_004 input {
        border: none;
        background: blue;
        color: #fff;
        padding: 11px 87px;
        border-radius: 11px;
        margin-top: 26px;
        margin-left: 49px;
    }

    .msg_cont {
        padding-top: 20px;
        padding-left: 20px;
        font-size: 18px;
    }

    .box3 {
        text-align: center;
        font-size: 20px;

    }

    .floatl {
        float: left;
    }

    .floatr {
        float: right;
    }


</style>
<script type="text/javascript">
    $(function () {
        $(function () {
            $("#img_flu").click(function () {
                this.src = "${ basePath }" + "kaptcha.jpg?d=" + new Date();
            });


        });
    });
</script>
<body>

<div class="box2">
    <div class="box2_001"></div>
    <ul class="box2_002">
        <li><span class="box2_002_001 floatl">会员</span>
            <a class="box2_002_002 floatr" href="./pages/user/regist.jsp">立即注册</a>
        </li>
        <li class="msg_cont floatl">
            <span id="errorMsg" class="errorMsg">
                ${empty requestScope.msg?"请输入你的用户名和密码":requestScope.msg}
            </span>
        </li>
        <form action="userServlet" method="post">
            <input type="hidden" name="action" value="login">
            <li class="floatl box2_002_003">
                <span>用户名:</span> <input class="username" type="text" name="username" value="${ requestScope.username }">
            </li>
            <li class="floatl box2_002_003">
                <span class="box2_002_003_001">密码: </span> <input type="text" name="password">

            </li>
            <li class="floatl box2_002_003 box2_002_003_futh">
                <span class="box2_002_003_001">验证码: </span> <input class="box2_002_003_002" type="text" name="code"> <img id="img_flu" class="box2_002_003_003" src="kaptcha.jpg" alt="验证码">
                <div class="box2_002_003_004">${ requestScope.code_msg }</div>
            </li>
            <li class="floatl box2_002_004">
                <input type="submit" value="登录">

            </li>
        </form>

    </ul>
</div>


</body>
</html>