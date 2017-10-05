<%--
  Created by IntelliJ IDEA.
  User: kumahyou
  Date: 2017/10/4
  Time: 下午2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Advanced Search</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="navigation.css" type="text/css">
    <link rel="stylesheet" href="home.css" type="text/css">
    <script src="navigation.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function(){
            $('#adsearch').submit(function(){
                $.ajax({
                    url:'/searchFriends',
                    data:$(this).serialize(),
                    success:function(data){
                        if (data == 'success'){
                            window.location.href='/searchResult.jsp'
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
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="collapse navbar-collapse">
            <p class="navbar-left nav-title">UNSWBook</p>
            <ul class="nav navbar-nav navbar-right">
                <li class="nav-btn">
                    <button class="btn btn-default navbar-btn btn-profile" onclick="{location.href='advancedSearch.jsp'}">Advanced Search</button>
                </li>
                <li class="nav-btn">
                    <button class="btn btn-default navbar-btn btn-profile" onclick="{location.href='profile.jsp'}">Profile</button>
                </li>
                <li class="nav-btn">
                    <button class="btn btn-default navbar-btn btn-logout" onclick="{location.href='login.jsp'}">Logout</button>
                </li>
            </ul>

            <form id="searchform" class="navbar-form navbar-right" action="searchFriends">
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
    <div class="row">
        <form id="adsearch" class="col-lg-4 col-lg-offset-4" action="searchFriends">
            <input type="hidden" name="action" value="advancedSearchFriend">
            <div class="form-group">
                <label >Birth:</label>

                <input class="form-control" type="text" placeholder="Birth" name="friendBirth">

            </div>
            <div class="form-group">
                <label>Name:</label>
                <input class="form-control" type="text" placeholder="Name" name="friendName">
            </div>
            <div class="form-group">
                <label >Gender:</label>
                <input class="form-control" type="text" placeholder="Gender" name="friendGender">
            </div>
            <div class="form-group">
                <input class="btn btn-default col-lg-12" type="submit" value="Search">
            </div>
        </form>
    </div>
</div>
</body>
</html>
