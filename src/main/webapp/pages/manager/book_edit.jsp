<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<head>
    <meta charset="UTF-8">
    <title>修改商品</title>
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
        background-color: rgb(73, 88, 110);
    }

    .box1 {
        height: 100px;
        overflow: hidden;
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
        margin: 127px 136px;
        text-align: center;
        padding-top: 200px;
    }

    table {
        border-collapse: collapse;
        margin: -170px auto;

    }

    table tr td {
        width: 70px;
        height: 36px;
        text-align: center;
    }

    table tr td input {
        height: 28px;
        width: 144px;
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

    a:hover {
        color: rgb(0, 161, 214);
    }
</style>
<body>


<div class="box2">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>

        <form action="manager/bookServlet" method="post">
            <input type="hidden" name="pageNo" value="${ param.pageNo }">
            <input type="hidden" name="action" value="${ empty param.id? "add":"update" }">
            <input type="hidden" name="id" value="${ requestScope.book.id }">
            <tr class="">
                <td><input type="text" name="name" value="${ requestScope.book.name }"></td>
                <td><input type="text" name="price" value="${ requestScope.book.price }"></td>
                <td><input type="text" name="author" value="${ requestScope.book.author }"></td>
                <td><input type="text" name="sales" value="${ requestScope.book.sales }"></td>
                <td><input type="text" name="stock" value="${ requestScope.book.stock }"></td>
                <td><input type="submit" value="提交"></td>
            </tr>
        </form>


    </table>
</div>


</body>
</html>
