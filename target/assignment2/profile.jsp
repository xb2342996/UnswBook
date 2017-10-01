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
%>
<html>
<head>
    <title>Change My Profile</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="profile.js" type="text/javascript"></script>
    <script src="navigation.js" type="text/javascript"></script>
    <link rel="stylesheet" href="navigation.css" type="text/css">
    <link rel="stylesheet" href="profile.css" type="text/css">
</head>
<body>
<%
    if (message!=null){
%>
%>
    <p>The profile has been changed successfully!</p>
<%}%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="collapse navbar-collapse">
            <p class="navbar-left nav-title">UNSWBook</p>
            <ul class="nav navbar-nav navbar-right">
                <li class="nav-btn">
                    <button class="btn btn-default navbar-btn btn-profile" onclick="{location.href='profile.jsp'}">Profile</button>
                </li>
                <li class="nav-btn">
                    <button class="btn btn-default navbar-btn btn-logout" onclick="{location.href='login.jsp'}">Logout</button>
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
            <!--<ul class="nav navbar-nav navbar-left">-->
            <!--<li class="dropdown">-->
            <!--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Advanced Search <span class="caret"></span></a>-->
            <!--<ul class="dropdown-menu">-->
            <!--<li>-->
            <!--<form action="searchFriends">-->
            <!--<input type="hidden" name="action" value="advancedSearchFriend">-->
            <!--<input class="ads" type="text" placeholder="Birth" name="friendBirth">-->
            <!--<input class="ads" type="text" placeholder="Name" name="friendName">-->
            <!--<input class="ads" type="text" placeholder="Gender" name="friendGender">-->
            <!--<input class="ads search-btn" type="submit" value="Search">-->
            <!--</form>-->
            <!--</li>-->
            <!--</ul>-->
            <!--</li>-->
            <!--</ul>-->
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row" >
        <div class="col-lg-4 col-lg-offset-4" >
            <div class="textbox" style="background: #e6f6fe">
                <form id="submitform" class="form-horizontal">
                    <input type="hidden" name="action" value="profile">
                    <div class="form-group"><div class="col-lg-10 col-lg-offset-1"><button class="carema"><span class="glyphicon glyphicon-camera"></span></button></div></div>
                    <fieldset disabled>
                        <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-1">
                                <input class="form-control " type="text" readonly="readonly" value="<%=user.getUsername()%>" id="username" name="username">
                            </div>
                        </div>
                    </fieldset>
                    <div class="form-group"><div class="col-lg-10 col-lg-offset-1"><input class="col-lg-10 form-control" type="password" placeholder="Password" id="password" name="password"></div></div>
                    <div class="form-group"><div class="col-lg-10 col-lg-offset-1"><input class="form-control" type="password" placeholder="Confirm Password"></div></div>
                    <div class="form-group"><div class="col-lg-10 col-lg-offset-1"><input class="form-control" type="text" placeholder="E-mail" id="email" name="email"></div></div>
                    <div class="form-group"><div class="col-lg-10 col-lg-offset-1"><input class="form-control" type="text" placeholder="Name" id="name" name="name"></div></div>
                    <div class="form-group"><div class="col-lg-10 col-lg-offset-1"><input class="form-control" type="text" placeholder="Gender" id="gender" name="gender"></div></div>
                    <div class="form-group"><div class="col-lg-10 col-lg-offset-1"><input class="form-control" type="text" placeholder="Birth" id="birth" name="birth"></div></div>
                    <div class="op-btn">
                        <div><button class="btn savebtn pull-right" type="submit">Save</button></div>
                        <div><a class="btn savebtn pull-right" href="home.jsp">Cancel</a></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
