<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/7/10
  Time: 7:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>注册页面</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/regist.css'/>">

    <script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/regist.js'/>"></script>
</head>

<body style="bgcolor:#cdcdcd">
<div id="divMain">
    <div id="divTitle">
        <span id="spanTitle">新用户注册</span>
    </div>
    <div id="divBody">
        <form action="<c:url value='/UserServlet'/>" method="post" id="registForm">
            <input type="hidden" name="method" value="regist"/>
            <table id="tableForm">
                <tr>
                    <td class="tdText">用户名：</td>
                    <td class="tdInput">
                        <input class="inputClass" type="text" name="loginname" id="loginname" value="${form.loginname }"/>
                    </td>
                    <td class="tdError">
                        <label class="errorClass" id="loginnameError">${errors.loginname }</label>
                    </td>
                </tr>
                <tr>
                    <td class="tdText">登录密码：</td>
                    <td>
                        <input class="inputClass" type="password" name="loginpass" id="loginpass" value="${form.loginpass }"/>
                    </td>
                    <td>
                        <label class="errorClass" id="loginpassError">${errors.loginpass }</label>
                    </td>
                </tr>
                <tr>
                    <td class="tdText">确认密码：</td>
                    <td>
                        <input class="inputClass" type="password" name="reloginpass" id="reloginpass" value="${form.reloginpass }"/>
                    </td>
                    <td>
                        <label class="errorClass" id="reloginpassError">${errors.reloginpass}</label>
                    </td>
                </tr>
                <tr>
                    <td class="tdText">Email：</td>
                    <td>
                        <input class="inputClass" type="text" name="email" id="email" value="${form.email }"/>
                    </td>
                    <td>
                        <label class="errorClass" id="emailError">${errors.email}</label>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="立即注册"/>
                    </td>
                    <td>
                        <label></label>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
