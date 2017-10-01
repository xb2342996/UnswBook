<%--
  Created by IntelliJ IDEA.
  User: kumahyou
  Date: 2017/9/16
  Time: 下午3:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String message = (String)request.getSession().getAttribute("errorMessage");

%>
<html>
<head>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <title>Login on UNSWBook</title>
    <style type="text/css">
        body{background: url(img/starSky1.jpg) no-repeat;background-size:cover;font-size: 16px;}
        .form{
            background: rgba(255,255,255,0);
            margin:180px auto;
        }
        .box{
            margin-top: 22px;
        }
        h2{
            color: #ffffff;
        }
        .fa{display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;}
        input[type="text"],input[type="password"]{padding-left:26px;}

    </style>
</head>
<body>
<%
    if (message != null){
%>
<div>
    <h1><%=message%></h1>
</div>
<%
    }
%>
<div class="container-fluid">
    <div class="form row">
        <form class="form-horizontal col-lg-offset-4 col-lg-4" action="login" method="get">
            <h2 class="form-title text-center">Log in to your account</h2>
            <input type="hidden" name="action" value="login">
            <div class="form-group-lg box" >
                <i class="fa"></i>
                <input class="form-control" type="text" placeholder="username" name="username" value="">
            </div>
            <div class="form-group-lg box" >
                <i class="fa"></i>
                <input class="form-control" type="password" placeholder="password" name="password" value="">
                <i class="fa"></i>
            </div>
            <div class="form-group-lg box">
                <input class="btn btn-info pull-right col-lg-5" type="submit" value="Log in">
                <a href="signup.jsp" class="btn btn-success pull-left col-lg-5">Sign up</a>
            </div>

        </form>
    </div>
</div>
</body>
</html>
