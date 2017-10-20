<%--
  Created by IntelliJ IDEA.
  User: kumahyou
  Date: 2017/10/17
  Time: 下午7:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visiable Data</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/vis/4.20.1/vis.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/vis/4.20.1/vis.min.js"></script>
    <script src="graph.js" type="text/javascript"></script>
    <script src="navigation.js" type="text/javascript"></script>
    <link href="navigation.css" rel="stylesheet">
    <link href="graph.css" rel="stylesheet">

</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="collapse navbar-collapse">
            <a class="navbar-left nav-title" href="home.jsp">UNSWBook</a>
            <ul class="nav navbar-nav navbar-right">
                <li class="nav-btn">
                    <button class="btn btn-default navbar-btn btn-profile" onclick="{location.href='advancedSearch.jsp'}" style="outline: 0">Advanced Search</button>
                </li>
                <li class="nav-btn">
                    <button class="btn btn-default navbar-btn btn-profile" onclick="{location.href='messageboard.jsp'}" style="outline: 0">MessageBoard</button>
                </li>
                <li class="nav-btn">
                    <button class="btn btn-default navbar-btn btn-profile" onclick="{location.href='#'}" style="outline: 0">Graph</button>
                </li>
                <li class="nav-btn">
                    <button class="btn btn-default navbar-btn btn-profile" onclick="{location.href='profile.jsp'}" style="outline: 0">Profile</button>
                </li>
                <li class="nav-btn">
                    <button class="btn btn-default navbar-btn btn-logout" onclick="{location.href='login.jsp'}" style="outline: 0">Logout</button>
                </li>
            </ul>


            <form class="navbar-form navbar-right" action="searchFriends">
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
    <form id="graphSearch" class="graphForm col-lg-offset-3 form-inline">
        <input type="hidden" name="action" value="detail">
        <select class="options form-group form-control" name="options">
            <option value="person">Person</option>
            <option value="message">Message</option>
            <option value="friend">FriendOfFriend</option>
        </select>
        <input class="keyword form-control form-group" type="text" name="keyword" placeholder="Please input the keyword you want to search" style="width:350px">
        <input class="search form-control" type="submit" value="Search">
        <button class="view-btn  form-control" type="button" onclick="showAll()">View All Graph</button>
    </form>
    <div id="mynetwork" class="container-fluid network"></div>
</div>
</body>
</html>
