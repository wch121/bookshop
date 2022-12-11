<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
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
        /*background-color: rgb(48, 141, 122);*/
        background-color: rgb(82, 139, 180);

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
        height: 406px;
        background-color: rgb(252, 254, 254);
        border: 0.5px black solid;
        margin-right: 564px;
        margin-top: 128px;
    }


    .box2_002_001 {
        margin-left: 57px;
        margin-top: 11px;
        font-size: 29px;
    }

    .msg {
        margin-top: 54px;
        margin-left: -144px;
        font-size: 16px;
        color: red;
    }

    .box2_002_002 {
        margin-top: 23px;
        margin-right: 23px;
        font-size: 26px;
    }

    .box2_002_003 {
        margin-top: 25px;
        margin-left: 33px;
    }

    .box2_002_003_code {
        margin-top: 8px;
        margin-left: 47px;
    }

    .box2_002_003_001 {
        padding-right: 15px;
    }

    .box2_002_003_003 {
        width: 90px;
        height: 45px;
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

            $(".username").blur(function () {
                $.getJSON("http://localhost:8080/demo02/userServlet", "action=ajaxChechUsername&username=" + this.value, function (msg) {
                    if (msg.username) {
                        $(".msg_error").text("用户名可用");

                    } else {

                        $(".msg_error").text("用户名已存在");
                    }
                })
            });
        });
    });
</script>
<body>
<%--<div class="box1"><span></span></div>--%>
<div class="box2">
    <div class="box2_001"></div>
    <ul class="box2_002">
        <li><span class="box2_002_001 floatl">注册会员</span>
        </li>
        <li class="floatl msg">
            <span class="msg_error">${ requestScope.msg }</span>
        </li>
        <form action="userServlet" method="post">
            <input type="hidden" name="action" value="regist">
            <li class="floatl box2_002_003">
                <span>用户名称:</span> <input type="text" name="username" value="${ requestScope.username }">
            </li>
            <li class="floatl box2_002_003">
                <span class="">用户密码: </span> <input type="text" name="password">

            </li>
            <li class="floatl box2_002_003">
                <span class="">确认密码: </span> <input type="text" name="repwd">

            </li>
            <li class="floatl box2_002_003">
                <span class="">电子邮件: </span> <input type="text" name="email" value="${ requestScope.email }">

            </li>
            <li class="floatl box2_002_003_code">
                <span class="">验证码: </span> <input type="text" name="code"> <img id="img_flu" class="box2_002_003_003"
                                                                                 src="kaptcha.jpg" alt="验证码">
            </li>


            <li class="floatl box2_002_004">
                <input type="submit" value="注册" name="">

            </li>
        </form>

    </ul>
</div>


</body>
</html>