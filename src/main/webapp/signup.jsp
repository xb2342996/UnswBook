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
    <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/base/jquery-ui.css">
    <script src=" http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.min.js"></script>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="signup.css" rel="stylesheet">
    <script src="signup.js" type="text/javascript"></script>
</head>
<body>
<nav class="navbar navbar-default " role="navigation">
    <div class="container-fluid">
        <div class="collapse navbar-collapse">
            <a class="navbar-left nav-title" href="login.jsp">UNSWBook</a>
            <ul class="nav navbar-nav navbar-right">
                <li><button class="btn btn-default navbar-btn btn-info" onclick="{location.href='/login.jsp'}"  style="outline: 0">Login</button></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <form id="signform" class="form-horizontal col-lg-6 col-lg-offset-4" action="signup" method="get">
            <div class="textbox col-lg-8">
                <h2>Join UNSWBook Today.</h2>
                <input type="hidden" name="action" value="signup">
                <div class="form-group-lg">
                    <input class="form-control" type="text" placeholder="Username" id="username" name="username" required>
                </div>
                <div class="form-group-lg">
                    <input class="form-control" type="password" placeholder="Password" id="password" name="password" required data-rule-regex="^\w{8,12}$">
                </div>
                <div class="form-group-lg">
                    <input class="form-control" name="repeat" type="password" placeholder="Confirm Password" required data-rule-equal="#password">
                </div>
                <div class="form-group-lg">
                    <input class="form-control" type="text" placeholder="E-mail" id="email" name="email" required data-rule-email="true" data-msg-email="Illegal Email Address">
                </div>
                <div class="form-group-lg">
                    <input class="form-control" type="text" placeholder="Name" id="name" name="name" required>
                </div>
                <div class="radio">
                    <label class="radio-inline">
                        <input class="radio" type="radio" checked="checked" placeholder="Gender" name="gender" value="male">
                        🚹
                    </label>
                    <label class="radio-inline">
                        <input class="radio" type="radio" placeholder="Gender" name="gender" value="female">
                        🚺
                    </label>
                </div>
                <div class="form-group-lg">
                    <input class="form-control" type="text" placeholder="Birth" id="datepicker" name="birth" required>
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