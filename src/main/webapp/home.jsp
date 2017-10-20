<%@ page import="Models.UserBean" %>
<%@ page import="Models.MessageBean" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kumahyou
  Date: 2017/9/18
  Time: 下午3:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserBean user = (UserBean)request.getSession().getAttribute("userInfo");
    List<MessageBean> results = (List<MessageBean>)request.getSession().getAttribute("allMessages");
%>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="navigation.css" type="text/css">
    <script src="navigation.js" type="text/javascript"></script>
    <link rel="stylesheet" href="home.css" type="text/css">
    <script src="home.js" type="text/javascript"></script>
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
                    <button class="btn btn-default navbar-btn btn-profile" onclick="{location.href='messageboard.jsp'}" style="outline: 0">MessageBoard</button>
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
        <div class="col-lg-6 col-lg-offset-3" style="background: #ededed">
            <form id="messageform" class="form col-lg-10 col-lg-offset-1" action="message" enctype="multipart/form-data">
                <div class="form-group">
                    <textarea class="form-control" name="message" id="" cols="30" rows="3" placeholder="What's happening"></textarea>
                    <div class="form-group">
                        <input type="file" id="uploadImg" name="filename" style="visibility: hidden; height: 0px; width: 0px">
                        <button type="button" class="btn pull-left btn-default btn-picture" aria-label="Left Align" onclick="selectimg()">
                            <span class="glyphicon glyphicon-picture"></span>
                        </button>
                        <button class="pull-right btn-submit" type="submit">Post</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-lg-6 col-lg-offset-3">
        <%

            for (MessageBean message : results) {
                String title = message.liked ? "glyphicon glyphicon-heart": "glyphicon glyphicon-heart-empty";
                String avatar = "img/default-avatar.jpg";
                if (message.getAvatar() != null && !message.getAvatar().equals("")){
                    avatar = "avatar/"+message.getAvatar();
                }
//                System.out.println(avatar);
        %>
            <div class="content" style="background-color: white">
                <div class="image">
                    <img class="icon" src="<%=avatar%>" alt="no image" width="50" height="50">
                </div>
                <div class="header">
                    <label class="username"><%=message.getUsername()%></label>
                    <label class="date">post at <%=message.getDate()%></label>
                    <button id="likebtn" class="like-btn" onclick="like(this,'<%=message.getUuid()%>','<%=message.getUsername()%>')">
                        <span class="<%=title%>"></span>
                    </button>
                </div>
                <div class="text">
                    <span class="message"><%=message.getMessage()%></span>
                </div>
                <%
                    if (message.getPicture() != null){
                %>
                <div class="picture">
                    <img src="upload/<%=message.getPicture()%>" width="150" height="150">
                </div>
                <%
                    }
                %>
            </div>
        <%
            }
        %>
        </div>
    </div>
</div>
</body>
</html>
