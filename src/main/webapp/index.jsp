<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 2019/4/27
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if (session.getAttribute("account") != null){
        response.sendRedirect("/user_info");
    }else{
        response.sendRedirect("/login");
    }
%>
</body>
</html>
