<%--
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
    <div  align="center" style="width: 50px;height: 50px;">
        <img src="/head/${account}.png">
    </div>


    <p><span>${account},欢迎回来！</span><a href="/logout">注销</a></p>
</div>
</body>
</html>
