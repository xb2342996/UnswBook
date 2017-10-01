<%@ page import="DAO.UserDAO" %>
<%@ page import="Models.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: kumahyou
  Date: 2017/9/19
  Time: 下午6:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserBean user = (UserBean) request.getSession().getAttribute("user");
    if (!user.isActived()){
%>
<html>
<head>
    <title>Notice</title>
</head>
<body>
    <p>This account has not actived, Please check your E-mail box!</p>
<%
    }
%>

</body>
</html>
