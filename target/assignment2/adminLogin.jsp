<%--
  Created by IntelliJ IDEA.
  User: kumahyou
  Date: 2017/9/24
  Time: 上午11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administrator</title>
    <script type="text/javascript" src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript">
        $(function(){
            $('#adminLogin').submit(function(){

                $.ajax({
                    type:'GET',
                    url:'/adminLogin',
                    data:$(this).serialize(),
                    success: function(data){
                        if (data == "success") {
                            window.location.href = "/adminControl.jsp";
                        }else {
                            alert("The administrator account is not correct, Please input again")
                        }
                    },
                    error:function(){
                    }

                });
                return false
            });
        });

    </script>
    <style type="text/css">
        body{background: url(img/starSky.jpg) no-repeat;background-size:cover;font-size: 16px;}
        .form{
            background: rgba(255,255,255,0);
            margin:180px auto;
        }
        .login-box{
            border:2px white solid;
        }
        .box{
            margin-top: 22px;
        }
        h2{
            color: #ffffff;
        }
        .notice{
            background: rgba(255,255,255,0.3);
            color: white;
            font-size:20px;
            font-family: Arial;
            margin-top: 35px;
        }
        p{
            margin-top: 5px;
        }
        .btn{
            background-color: #ff81ad;
            color: black;
            font-weight: bolder;
            font-size: 20px;
        }
        input{
            font-weight: bolder;
        }
    </style>
</head>
<body>

<div class="container-fluid">
    <div class="row form">
        <div class="col-lg-5 col-lg-offset-1 notice">
            <p>This page is used for administrator to manage this website.</p>
            <p>Function:</p>
            <p>1. The administrator can ban users through this account.</p>
            <p>2. The administrator can check users' activities in the control page.</p>
        </div>
        <div class="col-lg-4 col-lg-offset-1 login-box">
            <form class="form-horizontal" id="adminLogin" method="get">
                <h2 class="text-center">Login to Administrator</h2>
                <input type="hidden" name="action" value="adminLogin">
                <div class="form-group-lg box"><input class="form-control" type="text" placeholder="username" id="username" name="username" value="admin"></div>
                <div class="form-group-lg box"><input class="form-control" type="password" placeholder="password" id="password" name="password" value="password"></div>
                <div class="form-group-lg box"><input class="form-control btn" id="submit" type="submit" value="Login"></div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
