<%@ page import="Models.UserBean" %>
<%@ page import="DAO.UserDAO" %>
<%@ page import="Models.MessageBean" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.MessageDAO" %><%--
  Created by IntelliJ IDEA.
  User: kumahyou
  Date: 2017/9/25
  Time: 上午11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = request.getParameter("username");
    UserBean user = UserDAO.getUser(username);
    List<MessageBean> messageList = MessageDAO.getUserMessage(username);

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>UserReport</h3>
    <div>
        <p><%=user.getUsername()%></p>
        <p><%=user.getEmail()%></p>
        <p><%=user.getName()%></p>
        <p><%=user.getGender()%></p>
        <p><%=user.getBirth()%></p>
        <p><%=user.getJoindate()%></p>
        <div>

        <%
            for (MessageBean message : messageList) {
        %>
                <span><%=message.getMessage()%></span>
                <span><%=message.getUsername()%></span>
                <span><%=message.getDate()%></span><br>
        <%
            }
        %>
        </div>
    </div>
</body>
</html>
