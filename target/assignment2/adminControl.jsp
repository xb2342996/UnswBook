<%@ page import="java.util.List" %>
<%@ page import="Models.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: kumahyou
  Date: 2017/9/24
  Time: 下午12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<UserBean> searchResult = (List<UserBean>) request.getSession().getAttribute("searchUserResult");
    String errorMessage = (String) request.getSession().getAttribute("errorMessage");
    List<UserBean> list = (List<UserBean>) request.getSession().getAttribute("allUsers");
    if (searchResult != null){

        list = searchResult;
    }

%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <title>Control Panel</title>
    <link rel="stylesheet" href="navigation.css" type="text/css" />
    <link rel="stylesheet" href="adminControl.css" type="text/css" />
    <script type="text/javascript">
        $(function(){
            $('button#control').click(function(){
                var mid = $(this).val();
                var title = $(this).text() == "Ban" ? "Active" : "Ban";
                $(this).text(title);
                $.ajax({
                    type:'POST',
                    url:'/control',
                    data:{"username":mid,"flag":title}
                });
                return false;
            });
            $('#usersearch').submit(function(){
                $.ajax({
                    url:'/searchFriends',
                    data:$(this).serialize(),
                    success:function(data){
                        if (data == 'success'){
                            window.location.href='/adminControl.jsp'
                        }else if(data == 'failure'){
                            alert("This user does not exists!");
                        }
                    }
                });
                return false;
            });
        });
    </script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="collapse navbar-collapse">
            <a class="navbar-left nav-title" href="#">UNSWBook Adminstrator</a>
            <ul class="nav navbar-nav navbar-right">
                <li class="nav-btn">
                    <button class="btn btn-default navbar-btn btn-logout" onclick="{location.href='adminLogin.jsp'}"  style="outline: 0">Logout</button>
                </li>
            </ul>

            <form id="usersearch" class="navbar-form navbar-left" action="searchUser">
                <div class="form-inline">
                    <div class="input-group">
                        <input  type="hidden" name="action" value="searchUser">
                        <input class="search-input" type="text" placeholder="Search User" name="searchUser">
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
        <div class="border col-lg-6 col-lg-offset-3">
            <div class="title">
                <h3>Control Panel</h3>
            </div>
            <%
                if (errorMessage != null){

            %>
            <script type="text/javascript">
                alert("<%=errorMessage%>");
            </script>
            <%
                }
                for (UserBean user: list) {
                String title = user.isActived() ? "Ban" : "Active";

//                String gender = user.getGender().equals("male") ? "\uD83D\uDEB9" : "\uD83D\uDEBA";
            %>
            <div class="list" style="background-color: #ffffff">
                <button class="active pull-right" id="control" value="<%=user.getUsername()%>"><%=title%></button>
                <div class="username">
                    <a class="report" href="userReoprt.jsp?username=<%=user.getUsername()%>"><%=user.getUsername()%></a>
                    <%--<span class="info"><%=gender%></span>--%>
                    <span class="info"><%=user.getEmail()%></span>
                </div>
            </div>
            <%}%>
        </div>
    </div>
</div>
</body>
</html>
