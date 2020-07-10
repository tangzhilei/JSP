<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/7/10
  Time: 7:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, initial-scale=1.0, user-scalable=no">
    <!-- 引入 FrozenUI -->
    <title>登录</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div align="center">
    <div align="center" style="width: 500px;margin-top: 150px">
        <p class="bg-danger">${msg}</p>
        <form class="form-horizontal" method="post" action="<%=request.getContextPath()%>/login">
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="username" placeholder="用户名" name="username">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">Password</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password" placeholder="密码" name="password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button class="btn btn-danger" type="submit">登录</button>
                    <button class="btn btn-warning">
                        <a href="${pageContext.request.contextPath}/login/regist.jsp">注册</a>
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>

