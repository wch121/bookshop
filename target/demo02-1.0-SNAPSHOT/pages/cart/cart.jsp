<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>购物车页面</title>
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

    .box1_002_001 {
        font-size: 31px;
    }

    .box2 {
        width: 1273px;
        margin: 155px 136px;
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
        /*collapse: collapse;*/
        text-align: center;
        background-color: #eee;

    }

    table tbody tr:hover {
        background-color: rgb(121, 126, 144);
    }

    .updateCount {
        width: 54px;
        height: 26px;
    }


    .box3 {
        text-align: center;
        font-size: 18px;
    }

    .box2 a:hover {
        color: black;

    }

    .box2_002 {
        text-align: center;
        margin-bottom: 20px;
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
<script type="text/javascript">
    $(function () {
        $(".a_deleteItem").click(function () {
            return confirm("你确定要删除【"+ $(this).parent().parent().find("td:first").text() +"】吗？" );
        });

        $(".clear_cart").click(function () {
            return confirm("你确定要清空购物车吗？");
        })
        $(".updateCount").change(function () {

            var name = $(this).parent().parent().find("td:first").text();
            var value = this.value;
            var id = $(this).attr("bookId");
            if (confirm("你确定要将【" + name +"】数量改变为" + value + "吗？")) {
                location.href = "http://localhost:8080/demo02/cartServlet?action=updateCount&id=" + id + "&count=" + value;
            } else {
                this.value = this.defaultValue;
            }
        });
    });
</script>
<body>



<div class="box2">
    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:if test="${not empty sessionScope.cart.items }">
            <c:forEach items="${ sessionScope.cart.items }" var="item">
                <tr>
                    <td>${ item.value.name }</td>
                    <td><input bookId="${ item.value.id }" class="updateCount" type="text" name="count" value="${ item.value.count }"></td>
                    <td>${ item.value.price }</td>
                    <td>${ item.value.totalPrice=item.value.price*item.value.count }</td>
                    <td><a class="a_deleteItem" href="cartServlet?action=deleteItem&id=${ item.value.id }">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${ empty sessionScope.cart.items }">
            <tr>
               <td colspan="5"><a href="index.jsp">亲，你购物车里还没有商品噢，快和小伙伴们一起去逛逛吧！！！</a></td>
            </tr>
        </c:if>


    </table>
    <div class="box2_002">购物车中一共有 ${ sessionScope.cart.totalCount } 件商品 总金额 ${ sessionScope.cart.totalPrice } 元 <a class="clear_cart" href="cartServlet?action=clear">清空购物车</a> <a href="orderServlet?action=createOrder">去结账</a></div>


</div>



</body>
</html>