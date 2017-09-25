<%@ page import="Models.UserBean" %>
<%@ page import="DAO.UserDAO" %><%--
  Created by IntelliJ IDEA.
  User: kumahyou
  Date: 2017/9/20
  Time: 下午1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserBean user = (UserBean)request.getSession().getAttribute("userInfo");
    String message = (String)request.getSession().getAttribute("message");
    if (message!=null){

%>
<html>
<head>
    <title>Change My Profile</title>
</head>
<body>
    <p>The profile has been changed successfully!</p>
<%}%>
<div class="container">
    <form action="profile" method="get">
        <div class="textbox">
            <input type="hidden" name="action" value="profile">
            <div><input type="text" readonly="readonly" value="<%=user.getUsername()%>" id="username" name="username"></div>
            <div><input type="password" placeholder="password" id="password" name="password"></div>
            <div><input type="password" placeholder="confirm password"></div>
            <div><input type="text" placeholder="E-mail" id="email" name="email"></div>
            <div><input type="text" placeholder="name" id="name" name="name"></div>
            <div><input type="text" placeholder="Gender" id="gender" name="gender"></div>
            <div><input type="text" placeholder="Birth" id="birth" name="birth"></div>
            <div><input type="submit" value="Save"></div>
            <div><a href="home.jsp">cancel</a></div>
        </div>
    </form>
</div>
</body>
</html>
