<%--
  Created by IntelliJ IDEA.
  User: kumahyou
  Date: 2017/9/16
  Time: 下午3:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String message = (String)request.getSession().getAttribute("errorMessage");

%>
<html>
<head>
    <title>Login on UNSWBook</title>
</head>
<body>
<%
    if (message != null){
%>
<div>
    <h1><%=message%></h1>
</div>
<%
    }
%>
<a href="signup.jsp">Sign up</a>

<p>Log in to your account</p>
<div class="container">
    <form action="login" method="get">
        <div class="textbox">
            <input type="hidden" name="action" value="login">
            <div><input type="text" placeholder="username" id="username" name="username" value="HarleyQuinn"></div>
            <div><input type="password" placeholder="password" id="password" name="password" value="1234"></div>
            <div><input type="submit" value="Log in"></div>
        </div>
    </form>
</div>
</body>
</html>
