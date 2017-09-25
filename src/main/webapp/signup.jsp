<%--
  Created by IntelliJ IDEA.
  User: kumahyou
  Date: 2017/9/16
  Time: 下午4:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String message = (String)request.getSession().getAttribute("errorMessage");
%>
<html>
<head>
    <title>Register UNSWBook</title>
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
<p>Join UNSWBook Today.</p>
<div class="container">
    <form action="signup" method="get">
        <div class="textbox">
            <input type="hidden" name="action" value="signup">
            <div><input type="text" placeholder="username" id="username" name="username"></div>
            <div><input type="password" placeholder="password" id="password" name="password"></div>
            <div><input type="password" placeholder="confirm password"></div>
            <div><input type="text" placeholder="E-mail" id="email" name="email"></div>
            <div><input type="text" placeholder="name" id="name" name="name"></div>
            <div><input type="text" placeholder="Gender" id="gender" name="gender"></div>
            <div><input type="text" placeholder="Birth" id="birth" name="birth"></div>
            <div><input type="submit" value="Sign up"></div>
        </div>
    </form>
</div>
</body>
</html>