<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<head>
    <meta charset="UTF-8">
    <title>商品管理</title>
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
<script type="text/javascript" src="static/Jquery.js"></script>


<script type="text/javascript">
    $(function () {
        $(".a_deleteClass").click(function () {
            return confirm("你确定要删除" + $(this).parent().parent().find("td:first").text() + "吗？");
        });
    })

</script>
<style>

    * {
        padding: 0;
        margin: 0;
    }

    body {
        background-color: rgb(73, 88, 110);
    }

    .box1 {
        height: 70px;
    }

    .box1_001 {
        font-size: 31px;
        margin-top: 25px;
        margin-left: 170px;
    }

    .box1_002 {
        color: black;
        font-size: 25px;
        margin-top: 46px;
        margin-right: 130px;
    }

    a {
        text-decoration: none;
    }

    a:hover {
        color: rgb(0, 161, 214);
    }

    .box2 {
        width: 1273px;
        margin: 0 136px;
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
<div class="box1">
    <div class="box1_002 floatr"> <a href="index.jsp">返回商城</a>
    </div>
</div>
<div class="box2 ">
    <table class="">
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="book">
            <tr class="">
                <td>${ book.name }</td>
                <td>${ book.price }</td>
                <td>${ book.author }</td>
                <td>${ book.sales }</td>
                <td>${ book.stock }</td>
                <td><a href="manager/bookServlet?action=getBook&id=${ book.id }&pageNo=${ requestScope.page.pageNo }">修改</a></td>
                <td><a href="manager/bookServlet?action=delete&id=${ book.id }&pageNo=${ requestScope.page.pageNo }" class="a_deleteClass">删除</a></td>
            </tr>

        </c:forEach>
        <tr class="">
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp?&pageNo=${ requestScope.page.pageTotal }">添加商品</a></td>
        </tr>
    </table>

    <jsp:include page="/pages/common/page_nav.jsp"></jsp:include>
</div>



</body>
</html>
