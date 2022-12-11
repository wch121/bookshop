<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .inp {
        height: 22px;
        width: 36px;
    }
</style>
<body>
<div id="page_nav">
    <c:if test="${ requestScope.page.pageNo > 1 }">
        <a href="${ requestScope.page.pageUrl }&pageNo=1">首页</a>
        <a href="${ requestScope.page.pageUrl }&pageNo=${ requestScope.page.pageNo - 1 }">上一页</a>
    </c:if>
    <%--        这里是显示其他页码，并可以进行跳转的--%>
    <c:if test="${ requestScope.page.pageNo > 2 }">
        <a href="${ requestScope.page.pageUrl }&pageNo=${ requestScope.page.pageNo - 2 }">${ requestScope.page.pageNo - 2 }</a>
    </c:if>
    <c:if test="${ requestScope.page.pageNo > 1 }">
        <a href="${ requestScope.page.pageUrl }&pageNo=${ requestScope.page.pageNo - 1 }">${ requestScope.page.pageNo - 1 }</a>
    </c:if>

    【${ requestScope.page.pageNo }】

    <c:if test="${ requestScope.page.pageNo < requestScope.page.pageTotal }">
        <a href="${ requestScope.page.pageUrl }&pageNo=${ requestScope.page.pageNo + 1 }">${ requestScope.page.pageNo + 1 }</a>
    </c:if>
    <c:if test="${ requestScope.page.pageNo < requestScope.page.pageTotal - 1 }">
        <a href="${ requestScope.page.pageUrl }&pageNo=${ requestScope.page.pageNo + 2 }">${ requestScope.page.pageNo + 2 }</a>
    </c:if>


    <c:if test="${ requestScope.page.pageNo < requestScope.page.pageTotal }">
        <a href="${ requestScope.page.pageUrl }&pageNo=${ requestScope.page.pageNo+1 }">下一页</a>
        <a href="${ requestScope.page.pageUrl }&pageNo=${ requestScope.page.pageTotal }">末页</a>
    </c:if>
    共${ requestScope.page.pageTotal }页，${ requestScope.page.pageTotalCount }条记录
    到第<input class="inp" type="text" value="${ requestScope.page.pageNo }" name="pn" id="pn_input">页
    <input id="serchPageBtn" type="button" value="确定">
    <script type="text/javascript">
        $(function () {
            $("#serchPageBtn").click(function () {

                var pageIn = $("#pn_input").val();
                var pageTotal = ${ requestScope.page.pageTotal };
                if (pageIn < 1) {
                    pageIn = 1;
                } else if (pageIn > pageTotal) {
                    pageIn = pageTotal;
                }
                location.href = "${ pageScope.basePath }${ requestScope.page.pageUrl }&pageNo=" + pageIn;
            });

        });
    </script>
</div>

</body>
</html>
