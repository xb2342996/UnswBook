<%@ page import="Models.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: kumahyou
  Date: 2017/9/22
  Time: 下午4:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
//    UserBean user = (UserBean) request.getSession().getAttribute("userInfo");
    String username = (String) request.getSession().getAttribute("friendname");
%>
<html>
<head>
    <title>Friend add Successfully</title>
</head>
<body>
<h2>You have already added <%=username%> as friend successfully!</h2>
</body>
</html>
