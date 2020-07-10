<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/7/10
  Time: 7:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <title>注册</title>
</head>
<body>
<div align="center">
    <form method="post" action="<%=request.getContextPath()%>/regist">
        用户名：<input type="text" name="username"><br>
        密  码：<input type="password" name="password"><br>
        <button class="btn btn-info">注册</button>
        <button class="btn btn-info"> <a href="login.jsp">登录</a></button>
    </form></div>
</body>
</html>
