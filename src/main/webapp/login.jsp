<%--
  Created by IntelliJ IDEA.
  User: kumahyou
  Date: 2017/9/16
  Time: 下午3:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

%>
<html>
<head>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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

        input[type="text"],input[type="password"]{padding-left:26px;}

    </style>
    <script type="text/javascript">
        $(function(){
            $('#loginform').submit(function(){
                $.ajax({
                    url:'/login',
                    data:$(this).serialize(),
                    success:function(data){
                        if (data == 'success'){
                            window.location.href='/home.jsp'
                        }else {
                            alert(data)
                        }
                    }
                });
                return false;
            });
        });
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="form row">
        <form id="loginform" class="form-horizontal col-lg-offset-4 col-lg-4" method="get">
            <h2 class="form-title text-center">Log in to your account</h2>
            <input type="hidden" name="action" value="login">
            <div class="form-group-lg box" >

                <input class="form-control" type="text" placeholder="Username" name="username" value="" required>
            </div>
            <div class="form-group-lg box" >

                <input class="form-control" type="password" placeholder="Password" name="password" value="" required>

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
