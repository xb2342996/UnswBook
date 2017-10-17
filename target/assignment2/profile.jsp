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
//    String message = (String)request.getSession().getAttribute("message");
%>
<html>
<head>
    <title>Change My Profile</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/base/jquery-ui.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.min.js"></script>
    <script src="profile.js" type="text/javascript"></script>
    <script src="navigation.js" type="text/javascript"></script>
    <link rel="stylesheet" href="navigation.css" type="text/css">
    <link rel="stylesheet" href="profile.css" type="text/css">
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
    <div class="row" >
        <div class="col-lg-4 col-lg-offset-4" >
            <div class="textbox" style="background: #e6f6fe">
                <form id="submitform" class="form-horizontal" enctype="multipart/form-data">
                    <input type="hidden" name="action" value="profile">
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-1">
                            <input type="file" id="uploadImg" name="filename" style="visibility: hidden; height: 0px; width: 0px">
                            <button type="button" class="carema" onclick="selectimg()" aria-label="Left Align"><span class="glyphicon glyphicon-camera"></span></button>
                        </div>
                    </div>
                    <fieldset disabled>
                        <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-1">
                                <input class="form-control " type="text" readonly="readonly" value="<%=user.getUsername()%>" id="username" name="username">
                            </div>
                        </div>
                    </fieldset>
                    <!--
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-1">
                            <input class="col-lg-10 form-control" type="password" placeholder="Password" id="password" name="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-1">
                            <input class="form-control" type="password" placeholder="Confirm Password">
                        </div>
                    </div>
                    -->
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-1">
                            <input class="form-control" type="text" placeholder="E-mail" id="email" name="email" value="<%=user.getEmail()%>" data-rule-email="true" data-msg-email="Illegal Email Address" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-1">
                            <input class="form-control" type="text" placeholder="Name" id="name" name="name" value="<%=user.getName()%>" required>
                        </div>
                    </div>
                    <div class="radio" id="radio">
                        <div class="col-lg-10 col-lg-offset-1">
                            <label class="radio-inline">
                                <input class="radio" type="radio" checked="<%= user.getGender().equals("male")%>" placeholder="Gender" name="gender" value="male">
                                🚹
                            </label>
                            <label class="radio-inline">
                                <input class="radio" type="radio" checked="<%= user.getGender().equals("female")%>" placeholder="Gender" name="gender" value="female">
                                🚺
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-1">
                            <input class="form-control" type="text" placeholder="Birth" id="datepicker" name="birth" value="<%=user.getBirth()%>" required>
                        </div>
                    </div>
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
