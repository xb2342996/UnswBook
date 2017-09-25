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
    List<UserBean> list = (List<UserBean>) request.getSession().getAttribute("allUsers");

%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
    <script type="text/javascript">
        $(function(){
            var button = $('button#control')
            button.click(function(){
                var mid = $(this).val();
                var title = $(this).text() == "ban" ? "active" : "ban";
                $(this).text(title);
                $.ajax({
                    type:'POST',
                    url:'/control',
                    data:{"username":mid,"flag":title},
                })
            });
        });
    </script>
</head>
<body>

<%
    for (UserBean user: list) {
        String title = user.isActived() ? "ban" : "active";
%>
    <div>
        <a href="userReoprt.jsp?username=<%=user.getUsername()%>"><%=user.getUsername()%></a>
        <span><%=user.getEmail()%></span>
        <span><%=user.getName()%></span>
        <span><%=user.getBirth()%></span>
        <span><%=user.getGender()%></span>
        <span><%=user.isActived()%></span>
        <button id="control" value="<%=user.getUsername()%>"><%=title%></button>
    </div>
<%}%>
</body>
</html>
