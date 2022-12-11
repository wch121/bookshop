
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆成功头部的菜单</title>
</head>
<body>
<div class="box1">
    <span class="box1_002">欢迎 <span class="box1_002_001">${ sessionScope.user.username }</span>回来  <a href="userServlet?action=logout">注销</a> <a href="index.jsp">返回商城</a></span>
</div>
</body>
</html>
