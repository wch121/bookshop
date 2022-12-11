<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>结账页面</title>
    <%
        String basePath = request.getScheme()
                + "://"
                + request.getServerName()
                + ":"
                + request.getServerPort()
                + request.getContextPath()
                + "/";
        pageContext.setAttribute("basePath", basePath);

    %>
    <base href="<%=basePath%>">
</head>
<style>
    * {
        padding: 0;
        margin: 0;

    }

    body {
        background-color: rgb(73, 88, 110);
    }

    .box1 {
        height: 89px;
        overflow: hidden;
        padding-top: 10px;
    }

    .box1_001 {
        font-size: 45px;
        margin-left: 170px;
    }


    .box2 {
        width: 1273px;
        margin: 124px auto;
        text-align: center;
    }



    table {
        border-collapse: collapse;
        margin: 10px auto;

    }

    table tr td {
        border: 1px solid #999;
        width: 122px;
        height: 47px;
        text-align: center;
        background-color: #eee;

    }

    table tbody tr:hover {
        background-color: rgb(121, 126, 144);
    }

    .box2_002 {
        width: 980px;
        text-align: right;
        font-size: 21px;
        padding-bottom: 23px;
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
    <table>
        <tr>
            <td>订单号</td>
            <td>创建时间</td>
            <td>价格</td>
            <td>状态</td>
            <td>用户id</td>
            <td>查看详情</td>
        </tr>
        <tr>
            <td>${ sessionScope.order.order_id }</td>
            <td>${ sessionScope.order.create_time }</td>
            <td>${ sessionScope.order.price }</td>
            <td>${ sessionScope.order.status }</td>
            <td>${ sessionScope.order.user_id }</td>
            <td><a href="#">详情</a></td>
        </tr>
    </table>
    <div class="box2_002"><a href="#">确认支付</a></div>
</div>

</body>
</html>