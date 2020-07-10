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
    <div align="center" style="width: 500px;margin-top: 150px">
        <p class="bg-danger">${msg}</p>
        <form class="form-horizontal" method="post" action="<%=request.getContextPath()%>/regist">
            <div class="form-group">
                <label for="username">用户名</label>
                <input type="text" class="form-control" id="username" placeholder="请输入用户名" name="username">
            </div>
            <div class="form-group">
                <label for="password">密码</label>
                <input type="password" class="form-control" id="password" placeholder="请输入密码" name="password">
            </div>
            <div class="form-group">
                <label for="password2">确认密码</label>
                <input type="password" class="form-control" id="password2" placeholder="请确认密码" name="password2">
            </div>
            <div class="form-group">
                <label for="email">邮箱</label>
                <input type="email" class="form-control" id="email" placeholder="请输入邮箱" name="email">
            </div>
            <button type="submit" class="btn btn-danger">注册</button>
        </form>
    </div>
</div>
</body>
</html>
