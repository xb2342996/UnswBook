<%@ page import="Models.UserBean" %>
<%@ page import="Models.MessageBean" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kumahyou
  Date: 2017/9/18
  Time: 下午3:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserBean user = (UserBean)request.getSession().getAttribute("userInfo");
    List<MessageBean> results = (List<MessageBean>)request.getSession().getAttribute("allMessages");
%>

<html>
<head>
    <title>Home</title>
    <script type="text/javascript" src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
    <script type="text/javascript">
        $(function(){
            var button = $('li.message button')
            button.click(function(){
                var mid = $(this).val();
                var title = $(this).text() == "unLike" ? "Like" : "unLike";
                $(this).text(title);
                $.ajax({
                    type:'POST',
                    url:'like',
                    data:{"messageId":mid,"flag":title},
                    dataType:'json',
                    contentType:'application/x-www-form-urlencoded'
                })
            });
        });
    </script>
</head>
<body>
<form action="searchFriends">
    <input type="text" placeholder="Search Friend" name="searchFriend">
    <input type="submit" value="Search">
</form>
<a href="login.jsp">Log out</a>
<a href="profile.jsp">Profile</a>

<ul>
<%

    for (MessageBean message : results) {
        String title = message.liked ? "unLike" : "Like";
%>
        <li class="message" value="<%=message.getUuid()%>">
            <span><%=message.getMessage()%></span>
            <span><%=message.getUsername()%></span>
            <span><%=message.getDate()%></span>
            <button id="like" type="button" value="<%=message.getUuid()%>"><%=title%></button>
        </li>
<%
    }
%>
</ul>
<div>
    <form action="message" method="post">
        <input type="hidden" name="action" value="message">
        <textarea name="message" id="" cols="30" rows="10"></textarea>
        <div><input type="submit" value="Send"></div>
    </form>
</div>
</body>
</html>
