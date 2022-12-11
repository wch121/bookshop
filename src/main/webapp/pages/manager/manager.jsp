<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
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
        background-color: rgb(90, 182, 223);
    }

    .box1 {
        height: 600px;
        overflow: hidden;
    }

    .box1_001 {
        font-size: 31px;
        margin-top: 25px;
        margin-left: 170px;
    }

    .box1_002 {
        font-size: 18px;
        width: 500px;
        margin: 350px auto;
    }

    .box1_002 a {
        text-decoration: none;
    }

    .box2 {
        height: 280px;
        width: 1273px;
        margin: 14px 136px;
        text-align: center;
        padding-top: 200px;
    }

    .box3 {
        text-align: center;
        font-size: 18px;
    }
    a:hover {
        color: rgb(0, 161, 214);

    }
    .floatl {
        float: left;
    }

    .floatr {
        float: right;
    }
</style>
<body>

<div class="box1">
    <div class="box1_002"><span>这里是后台管理中心,你可以选择 </span><a href="manager/bookServlet?action=page">商品管理</a> <a href="index.jsp">返回商城</a></div>
</div>




</body>
</html>
