<%@ page import="Models.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: kumahyou
  Date: 2017/9/22
  Time: 上午3:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String error = (String) request.getSession().getAttribute("searchError");
    boolean flag = (boolean) request.getSession().getAttribute("friendFlag");
    String buttonValue = !flag ? "add Friend" : "cancal Friend";
    UserBean searchResult = (UserBean) request.getSession().getAttribute("searchResult");
    if (error != null){
%>
<html>
<head>
    <title>Search Result</title>
</head>
<body>
<p><%=error%></p>
<%
    }else{
%>
<form action="addFriend" method="get">
    <input type="hidden" name="action" value="addFriend">
    <input type="hidden" name="flag" value="<%=flag%>">
    <input type="hidden" name="friendEmail" value="<%=searchResult.getEmail()%>">
    <input type="hidden" name="friendName" value="<%=searchResult.getUsername()%>">
    <span><%=searchResult.getUsername()%></span><br>
    <span><%=searchResult.getEmail()%></span><br>
    <span><%=searchResult.getName()%></span><br>
    <span><%=searchResult.getBirth()%></span><br>
    <span><%=searchResult.getGender()%></span>
    <input type="submit" value="<%=buttonValue%>">
</form>
<%
    }
%>

</body>
</html>
