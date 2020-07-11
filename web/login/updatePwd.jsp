<%--
  Created by IntelliJ IDEA.
  User: tzl
  Date: 2020/7/10
  Time: 18:53
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
    <title>修改密码</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%
    String  username = request.getParameter("username");
%>
<div align="center">
    <div align="center" style="width: 500px;margin-top: 150px">
        <p class="bg-danger">${msg}</p>
        <form class="form-horizontal" method="post" action="<%=request.getContextPath()%>/updatePwd">
            <input type="hidden" name="username" value="<%=username%>">
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">原密码</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="password" placeholder="原密码" name="password">
                </div>
            </div>
            <div class="form-group">
                <label for="password1" class="col-sm-2 control-label">新密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password1" placeholder="请输入新密码" name="password1">
                </div>
            </div>
            <div class="form-group">
                <label for="password2" class="col-sm-2 control-label">确认密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password2" placeholder="请确认密码" name="password2">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button class="btn btn-danger" type="submit">修改密码</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
