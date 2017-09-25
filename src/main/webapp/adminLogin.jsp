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
    <title>Title</title>
    <script type="text/javascript" src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
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
</head>
<body>
<p>Log in to Administrator account</p>
<div class="container">
    <form id="adminLogin" method="get">
        <div class="textbox">
            <input type="hidden" name="action" value="adminLogin">
            <div><input type="text" placeholder="username" id="username" name="username" value="admin"></div>
            <div><input type="password" placeholder="password" id="password" name="password" value="password"></div>
            <div><input id="submit" type="submit" value="Log in"></div>
        </div>
    </form>
</div>
</body>
</html>
