<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>订单页面</title>
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
    <%--    <%=basePath%>--%>
    <base href="<%=basePath%>">
</head>
<style>
    * {
        padding: 0;
        margin: 0;

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
        height: 280px;
        width: 1273px;
        border: 1px black solid;
        margin: 14px 136px;
        text-align: center;
    }

    table {
        border-collapse: collapse;
        margin: 70px auto;

    }

    table tr td {
        border: 1px solid #999;
        width: 122px;
        height: 47px;
        /*collapse: collapse;*/
        text-align: center;
        background-color: #eee;

    }

    table tbody tr:hover {
        background-color: rgb(121, 126, 144);
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
</style>
<body>

<jsp:include page="/pages/common/loginsuccess_head_menu.jsp"></jsp:include>


<div class="box2">
    <table>
        <tr>
            <td>日期</td>
            <td>金额</td>
            <td>状态</td>
            <td>详情</td>
        </tr>
        <tr>
            <td>日期</td>
            <td>金额</td>
            <td>状态</td>
            <td><a></a></td>
        </tr>
        <tr>
            <td>日期</td>
            <td>金额</td>
            <td>状态</td>
            <td>详情</td>
        </tr>
    </table>
</div>

<jsp:include page="/pages/common/bottom.jsp"></jsp:include>


</body>
</html>