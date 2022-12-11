<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%--<!DOCTYPE html>--%>
<html>
<head>
    <title>商城</title>
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
<script src="static/Jquery.js"></script>
<style>
    * {
        padding: 0;
        margin: 0;
    }

    body {
        background-color: rgb(73, 88, 110);
    }

    .box1 {

        overflow: hidden;
    }

    .box1_left {
        /*font-size: 38px;*/
        float: left;
        margin-left: 200px;
        margin-top: 29px;
        margin-bottom: 31px;

    }

    .box1_left img {
        height: 72px;
        width: 116px;
    }

    .box1_right {
        font-size: 18px;
        float: right;
        margin-right: 200px;
        margin-top: 57px;
        color: rebeccapurple;

    }

    .box1 a {
        text-decoration: none;
    }

    .box1 a:hover {
        color: rgb(0, 161, 214);
    }

    .box1_right:hover {
        color: black;
    }

    .box1_002_001 {
        font-size: 45px;
    }

    .box2 {
        width: 1391px;
        background-color: rgb(242, 242, 242);
        border: black 1px solid;
        margin-left: 50px;
        margin-bottom: 58px;

    }

    .box2 .box2_001 {
        text-align: center;
    }

    .box2_priceinput {
        height: 20px;
        width: 54px;
    }

    .box2 .box2_002 {
        text-align: center;
    }

    .box2 .box2_003 {
        text-align: center;
    }

    .box2 .box2_004 {

        list-style: none;

    }

    .box2 .box2_004:after {
        content: '';
        display: block;
        clear: both;
    }

    .box2 .box2_004 li {
        float: left;
        margin-left: 68px;
        height: 480px;
        width: 260px;
        border: 1px rgb(234, 236, 234) solid;
        margin-top: 30px;
    }

    .box2 .box2_004 img {
        width: 264px;
        height: 278px;

    }

    .box2 .box2_004_001 {
        margin-top: 5px;
    }

    .box2 .box2_004_002 {
        border: none;
        background: rgb(74, 89, 111);
        color: rgb(229, 214, 180);
        padding: 3px 47px;
        border-radius: 11px;
        margin-top: 10px;
        margin-left: 6px;
    }

    .box2 .box2_004_002:hover {
        background-color: rgb(96, 105, 124);
        cursor: pointer;

    }

    #page_nav {

        text-align: center;
    }

    .box3 {
        text-align: center;
        margin-left: -80px;
    }

    .box3 .box3_001 {
        font-size: 22px;
    }

    .box4 {
        list-style: none;
        margin-bottom: 32px;
        padding-left: 65px;
    }

    .box4:after {
        content: '';
        display: block;
        clear: both;
    }

    .box4 li {
        float: left;
    }

    .box4 li a {
        display: block;
        height: 46px;
        width: 111px;
        font-size: 17px;
        line-height: 46px;
        text-align: center;
        color: black;
    }

    .box4 li a:hover {
        background-color: rgb(96, 105, 124);
    }

    .box4_100 {
        background-color: rgb(68, 71, 78);
    }

    a {
        text-decoration: none;
        color: black;
    }
</style>
<script type="text/javascript">
    $(function () {
        $(".box2_004_002").click(function () {
            var attr = $(this).attr("bookId");
            if ($("#login_show").text() == "") {
                location.href = "http://localhost:8080/demo02/pages/user/login.jsp"
            } else {
                $.getJSON("http://localhost:8080/demo02/cartServlet", "action=ajaxAddItem&bookId=" + attr, function (data) {
                    console.log(data);
                    return confirm("你确定要添加【" + data.cartItemName + "】到购物车吗？");
                })
            }

        });


    });
</script>
<body>
<div class="box1">
    <%--    <h1 class="box1_left"><img src="photo/1.png" ></h1>--%>
    <span class="box1_right">
<%--        没登陆时显示的页头--%>
        <c:if test="${ empty sessionScope.user }">
            <a href="./pages/user/login.jsp">登录</a> <a href="./pages/user/regist.jsp">注册</a>
        </c:if>
<%--        登陆后显示的页头--%>
        <c:if test="${ not empty sessionScope.user }">
            <span id="login_show" class="box1_002_001">${ sessionScope.user.username }</span>
            <a href="userServlet?action=logout">注销</a>
            <a href="./pages/cart/cart.jsp">购物车</a>
        </c:if>
        <c:if test="${ sessionScope.user.username == 'root' }">
            <a href="./pages/manager/manager.jsp">后台管理</a>
        </c:if>
    </span>

</div>

<div class="box4_100">
    <ul class="box4">
        <li><a href="#">WCH电器城</a></li>
        <li><a href="#">老陈手机数码</a></li>
        <li><a href="#">土拨鼠超市</a></li>
        <li><a href="#">家具建材</a></li>
        <li><a href="#">生活家电</a></li>
        <li><a href="#">帮客服务</a></li>
        <li><a href="#">金融</a></li>
        <li><a href="#">食品</a></li>
        <li><a href="#">美妆</a></li>
        <li><a href="#">箱包</a></li>
        <li><a href="#">汽车</a></li>
        <li><a href="#">医药健康</a></li>
    </ul>
</div>

<div class="box2">
    <div class="box2_001">
        <form action="client/bookServlet" method="get">
            <input type="hidden" name="action" value="pageByPrice">

            <span>价格: <input class="box2_priceinput" type="text" name="min" value="${ param.min }">元-<input
                    class="box2_priceinput" type="text" name="max"
                    value="${ param.max }">元</span>
            <input type="submit" value="确定">
        </form>
    </div>

    <p class="box2_002">你的购物车里有${sessionScope.cart.totalCount}件物品</p>
    <ul class="box2_004">
        <c:forEach items="${ requestScope.page.items }" var="book">
            <li><img src="${ book.img_path }">
                <p class="box2_004_001">${ book.name }</p>
                <p>价格：${ book.price }</p>
                <p>销量：${ book.sales }</p>
                <p>库存：${ book.stock }</p>
                <input bookId="${ book.id }" class="box2_004_002" type="button" value="加入购物车">
            </li>
        </c:forEach>

    </ul>
    <jsp:include page="/pages/common/page_nav.jsp"></jsp:include>
</div>

</body>
</html>