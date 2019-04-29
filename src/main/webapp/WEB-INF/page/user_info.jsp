<%@ page import="com.yejf.oauth.dto.UserInfoDTO" %><%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 2019/4/27
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
</head>
<body>
<div align="center" style="width: 500px;">
    <div align="center" style="width: 50px;height: 50px;">
    <%
        if ("baidu".equals(((UserInfoDTO)session.getAttribute("userInfo")).getInfoFrom())) {
    %>
        <img src="http://tb.himg.baidu.com/sys/portraitn/item/${userInfo.portrait}">
    <%
    }else{
    %>

        <img src="/head/${userInfo.uid}.png">

    <%
        }
    %>
    </div>


    <p><span>${userInfo.uname},欢迎回来！</span><a href="/logout">注销</a></p>
</div>
</body>
</html>
