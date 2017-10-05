<%@ page import="Models.UserBean" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: kumahyou
  Date: 2017/9/22
  Time: 上午3:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<UserBean> searchResult = (ArrayList<UserBean>) request.getSession().getAttribute("searchResult");
%>
<html>
<head>
    <title>Search Result</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="navigation.css" type="text/css">
    <link rel="stylesheet" href="searchResult.css" type="text/css">
    <script type="text/javascript" src="navigation.js"></script>
    <script type="text/javascript" src="searchResult.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="collapse navbar-collapse">
            <p class="navbar-left nav-title">UNSWBook</p>
            <ul class="nav navbar-nav navbar-right">
                <li class="nav-btn">
                    <button class="btn btn-default navbar-btn btn-profile" onclick="{location.href='advancedSearch.jsp'}" style="outline: 0">Advanced Search</button>
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
    <div class="row" >
        <div class="col-lg-8 col-lg-offset-2" style="background: #ededed">
        <%
            for (UserBean user : searchResult) {
            String title = !user.isFriend() ? "Add Friend" : "Cancal Friend";
            String gender = user.getGender().equals("female") ? "\uD83D\uDEBA" : "\uD83D\uDEB9";
            String avatar = "img/default-avatar.jpg";
            if (user.getPhoto() != null && !user.getPhoto().equals("")){
                avatar = "avatar/"+user.getPhoto();
            }
        %>
            <div class="friend col-lg-4">
                <div class="wrapper"  style="background: white">
                    <div class="content">
                        <div class="image">
                            <img class="icon img-circle" src="<%=avatar%>">
                        </div>
                        <div class="info">
                            <div class="detail"><span>Username: <%=user.getUsername()%> </span></div>
                            <div class="detail"><span>Email: <%=user.getEmail()%></span></div>
                            <div class="detail"><span>Name: <%=user.getName()%></span></div>
                            <div class="detail"><span>Birth: <%=user.getBirth()%></span></div>
                            <div class="detail"><span>Gender: <%=gender%></span></div>
                        </div>
                    </div>
                    <div class="addbtn">
                        <button class="btn btn-danger addbtn" type="button" onclick="add(this,'<%=user.getUsername()%>','<%=user.getEmail()%>','<%=user.isFriend()%>')"><%=title%></button>
                    </div>
                </div>
            </div>
        <%
            }
        %>

        </div>
    </div>
</div>

</body>
</html>
