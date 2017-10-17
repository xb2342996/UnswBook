<%@ page import="Models.UserBean" %>
<%@ page import="DAO.UserDAO" %>
<%@ page import="Models.MessageBean" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.MessageDAO" %>
<%@ page import="DAO.FriendDAO" %>
<%@ page import="Models.FriendBean" %>
<%@ page import="Models.Activity" %>
<%@ page import="DAO.ReportDAO" %><%--
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
    List<Activity> activities = ReportDAO.getActivityByUser(username);
    List<FriendBean> friendList = FriendDAO.getFriends(username);
    String gender = user.getGender().equals("male") ? "\uD83D\uDEB9" : "\uD83D\uDEBA";
    String avatar = "img/default-avatar.jpg";
    if (user.getPhoto() != null && !user.getPhoto().equals("")){
        avatar = "avatar/"+user.getPhoto();
    }
%>
<html>
<head>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <title>Report</title>
    <link rel="stylesheet" href="navigation.css" type="text/css" />
    <link rel="stylesheet" href="userReport.css" type="text/css" />
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="collapse navbar-collapse">
            <a class="navbar-left nav-title" href="adminControl.jsp">UNSWBook Administrator</a>
            <ul class="nav navbar-nav navbar-right">
                <li class="nav-btn">
                    <button class="btn btn-default navbar-btn btn-logout" onclick="{location.href='adminLogin.jsp'}"  style="outline: 0">Logout</button>
                </li>
            </ul>

            <form class="navbar-form navbar-left" action="searchUser">
                <div class="form-inline">
                    <div class="input-group">
                        <input  type="hidden" name="action" value="searchUser">
                        <input class="search-input" type="text" placeholder="Search User" name="searchUser">
                        <div class="input-group-addon">
                            <button class="search-btn" type="submit" value="Search">
                                <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="content col-lg-8 col-lg-offset-2" >
            <div class="left-detail col-lg-4 pull-left">
                <div class="info">
                    <div class="avatar">
                        <img class="img-circle" src="<%=avatar%>" width="100" height="100">
                    </div>
                    <div class="detail">
                        <div><label>Username:</label><p><%=user.getUsername()%></p></div>
                        <div><label>E-mail:</label><p><%=user.getEmail()%></p></div>
                        <div><label>Name:</label><p><%=user.getName()%></p></div>
                        <div><p><label>Gender:</label> <%=gender%></p></div>
                        <div><p><label>Birth:</label> <%=user.getBirth()%></p></div>
                        <div><p><label>Join date:</label> <%=user.getJoindate()%></p></div>
                    </div>
                </div>
                <div class="friends">
                    <h4>Friends</h4>
                    <%
                        for (FriendBean friend : friendList) {
                    %>
                    <div class="friend">
                        <p class="name"><%=friend.getFriend()%></p>
                        <p class="email"><%=friend.getEmail()%></p>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
            <div class="messages col-lg-8 pull-right" >
                <div>
                    <%
                        for (Activity message : activities) {
                    %>
                    <div>
                        <div class="message">
                            <span class="content"><%=message.getOperation()%></span>
                            <label class="date"><%=message.getDate()%></label>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
