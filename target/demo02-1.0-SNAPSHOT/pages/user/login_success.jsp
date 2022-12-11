<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<head>
    <meta charset="UTF-8">
    <title>登陆成功</title>
    <%
        String basePath = request.getScheme()
                + "://"
                + request.getServerName()
                + ":"
                + request.getServerPort()
                + request.getContextPath()
                + "/";
    %>

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
        font-size: 18px;
        height: 100px;

    }


    .box1_002 {
        width: 409px;
        display: block;
        margin: 297px auto;

    }

    .box2 {
        height: 280px;
        width: 1273px;
        border: 1px black solid;
        margin: 14px 136px;
        text-align: center;
        padding-top: 200px;
    }

    .box1_002_001 {
        font-size: 34px;
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

<jsp:include page="/pages/common/loginsuccess_head_menu.jsp"></jsp:include>

</body>
</html>