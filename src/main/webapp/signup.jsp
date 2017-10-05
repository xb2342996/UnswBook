<%--
  Created by IntelliJ IDEA.
  User: kumahyou
  Date: 2017/9/16
  Time: 下午4:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String message = (String)request.getSession().getAttribute("errorMessage");
%>
<html>
<head>
    <title>Register UNSWBook</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="signup.css" rel="stylesheet">
    <script src="signup.js" type="text/javascript"></script>
</head>
<body>
<nav class="navbar navbar-default " role="navigation">
    <div class="container-fluid">
        <div class="collapse navbar-collapse">
            <p class="navbar-left nav-title">UNSW Book</p>
            <ul class="nav navbar-nav navbar-right">
                <li><button class="btn btn-default navbar-btn btn-info" onclick="{location.href='/login.jsp'}"  style="outline: 0">Login</button></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <form id="signform" class="form-horizontal col-lg-4 col-lg-offset-4" action="signup" method="get">
            <div class="textbox">
                <h2>Join UNSWBook Today.</h2>
                <input type="hidden" name="action" value="signup">
                <div class="form-group-lg">
                    <input class="form-control" type="text" placeholder="Username" id="username" name="username">
                </div>
                <div class="form-group-lg">
                    <input class="form-control" type="password" placeholder="Password" id="password" name="password">
                </div>
                <div class="form-group-lg">
                    <input class="form-control" type="password" placeholder="Confirm Password">
                </div>
                <div class="form-group-lg">
                    <input class="form-control" type="text" placeholder="E-mail" id="email" name="email">
                </div>
                <div class="form-group-lg">
                    <input class="form-control" type="text" placeholder="Name" id="name" name="name">
                </div>
                <div class="radio">
                    <label class="radio-inline">
                        <input class="radio" type="radio" placeholder="Gender" name="gender" value="male">
                        🚹
                    </label>
                    <label class="radio-inline">
                        <input class="radio" type="radio" placeholder="Gender" name="gender" value="female">
                        🚺
                    </label>
                </div>
                <div class="form-group-lg">
                    <input class="form-control" type="text" placeholder="Birth" id="birth" name="birth">
                </div>
                <div class="form-group-lg">
                    <input class="submit-button btn col-lg-12" type="submit" value="Sign up">
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>