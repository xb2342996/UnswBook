<%@ page import="Models.UserBean" %>
<%@ page import="DAO.NotificationDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Models.NotificationBean" %><%--
  Created by IntelliJ IDEA.
  User: kumahyou
  Date: 2017/10/16
  Time: 下午10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserBean user = (UserBean)request.getSession().getAttribute("userInfo");
    ArrayList<NotificationBean> notis = (ArrayList<NotificationBean>)NotificationDAO.getNotificationByUser(user.getUsername());

%>
<html>
<head>
    <title>MessageBoard</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="navigation.css" type="text/css">
    <link rel="stylesheet" href="messageboard.css" type="text/css">
    <script src="navigation.js" type="text/javascript"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="collapse navbar-collapse">
            <a class="navbar-left nav-title" href="#">UNSWBook</a>
            <ul class="nav navbar-nav navbar-right">
                <li class="nav-btn">
                    <button class="btn btn-default navbar-btn btn-profile" onclick="{location.href='advancedSearch.jsp'}" style="outline: 0">Advanced Search</button>
                </li>
                <li class="nav-btn">
                    <button class="btn btn-default navbar-btn btn-profile" onclick="{location.href='#'}" style="outline: 0">MessageBoard</button>
                </li>
                <li class="nav-btn">
                    <button class="btn btn-default navbar-btn btn-profile" onclick="{location.href='graph.jsp'}" style="outline: 0">Graph</button>
                </li>
                <li class="nav-btn">
                    <button class="btn btn-default navbar-btn btn-profile" onclick="{location.href='profile.jsp'}" style="outline: 0">Profile</button>
                </li>
                <li class="nav-btn">
                    <button class="btn btn-default navbar-btn btn-logout" onclick="{location.href='login.jsp'}" style="outline: 0">Logout</button>
                </li>
            </ul>

            <form id="searchform" class="navbar-form navbar-right" action="searchFriends">
                <div class="form-inline">
                    <div class="input-group">
                        <input  type="hidden" name="action" value="searchFriend">
                        <input class="search-input" type="text" placeholder="Search Friend" name="searchFriend">
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
        <div class="col-lg-6 col-lg-offset-3" style="background: white">
            <%
                if (notis == null || notis.size()==0){
            %>
            <div>
                <label class="date">There is no notifications in the messageboard.</label>
            </div>
            <%
                } else {
                    for (NotificationBean noti : notis){
            %>
            <div>
                <div class="message">
                    <label class="date"><%=noti.getDate()%></label>
                    <button type="button" class="remove"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                    <span class="content"><%=noti.getContent()%></span>
                </div>
            </div>
            <%
                    }
                }
            %>
        </div>
    </div>
</div>
</body>
</html>
