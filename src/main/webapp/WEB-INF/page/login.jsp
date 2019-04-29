<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 2019/4/27
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oauth登录</title>
</head>
<body>
<div >
    <div style="display: inline;"><a href="https://openapi.baidu.com/oauth/2.0/authorize?
	response_type=code&
	client_id=gkTh2xPm81Qoe7e5d6oczTYf&
	redirect_uri=http://localhost:8080/baiduAuth&
	scope=basic&
	display=popup&
confirm_login=1">百度</a></div>
    <div style="display: inline;"> qq</div>
    <div style="display: inline;">微信</div>
</div>
<div style="width: 500px; align-self: center ;" >
    <%
     if (request.getAttribute("errorMsg") != null){
         %>
         <p>${errorMsg}</p>
    <%
     }
    %>
    <form name="login"  action="/login" method="post">
        <p>账号<input name="account" value = "${account}"></p>
        <p>密码<input name="password" type="password" ></p>
        <input type="submit" value="登录" style="float: right;">
    </form>
</div>
</body>
</html>
