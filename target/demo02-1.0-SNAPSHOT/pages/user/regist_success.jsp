<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--

--%>
<head>
    <meta charset="UTF-8">
    <title>注册成功</title>
    <%
        String basePath = request.getScheme()
                + "://"
                + request.getServerName()
                + ":"
                + request.getServerPort()
                + request.getContextPath()
                + "/";
    %>

<%--        <%=basePath%>--%>
    <base href="<%=basePath%>">
</head>
<style>
    * {
        padding: 0;
        margin: 0;

    }

    body {
        background-color: rgb(74, 202, 203);
    }

    .box1 {
        height: 100px;
        overflow: hidden;
        /*background-color: rebeccapurple;*/
    }

    .box1_001 {
        font-size: 31px;
        margin-top: 25px;
        margin-left: 170px;
    }

    .box1_002 {
        margin-top: 46px;
        margin-right: 130px;
    }

    .box2 {
        font-size: 25px;
        height: 280px;
        width: 1273px;
        margin: 14px 136px;
        text-align: center;
        padding-top: 324px;
    }

    .box3 {
        text-align: center;
        font-size: 18px;
    }
    .box2 a:hover {
        color: black;

    }
    .floatl {
        float: left;
    }

    .floatr {
        float: right;
    }

    a {
        text-decoration: none;
    }
</style>
<body>

<div class="box2">
    <span>注册成功 </span> <a href="pages/user/login.jsp">转到登录</a>
</div>

</body>
</html>