<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/7/10
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, initial-scale=1.0, user-scalable=no">
    <!-- 引入 FrozenUI -->
    <title>购物车列表</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">购物车</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><button class="btn btn-default navbar-btn"><a href="<%=request.getContextPath()%>/product?username=${requestScope.username}" >购买商品</a></button></li>
                <li><button class="btn btn-default navbar-btn"><a href="${pageContext.request.contextPath}/login/updatePwd.jsp?username=${requestScope.username}">修改密码</a></button></li>
                <li><a href="${pageContext.request.contextPath}/login/login.jsp">${requestScope.username}登出</a></li>
            </ul>
        </div>
    </div>
</nav>
<div align="center">
    <div align="center" style="width: 1000px;margin-top: 150px">
        <table class="table table-hover" style="margin-top: 100px">
            <tr>
                <td>#</td>
                <td>商品名称</td>
                <td>价格</td>
                <td>数量</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${requestScope.data}" var="cart" varStatus="id">
                <tr>
                    <td>${id.index+1}</td>
                    <td>${cart.name}</td>
                    <td>${cart.price}</td>
                    <td>${cart.num}</td>
                    <td>删除按钮</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
