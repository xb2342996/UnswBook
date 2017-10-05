<%--
  Created by IntelliJ IDEA.
  User: kumahyou
  Date: 2017/10/4
  Time: 下午3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>上传</title>

    <script src="http://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript">
        function selectimg() {
            $('#uploadImg').trigger("click");
            return false;
        }
        $(function () {
            $('#form').submit(function () {
                var form = new FormData(document.getElementById("form"));
                console.log(form);
                $.ajax({
                    type:'post',
                    url:'/UploadTestServlet',
                    processData: false,
                    contentType: false,
//                    cache: false,
                    data:form,
                    success:function (data) {
                        console.log('success');
                    }
                });
            });
        })
    </script>
</head>
<body>
<div>
    <!--用来存放文件信息-->
    <form id="form" enctype="multipart/form-data" name="loginform">
        <input type="file" id="uploadImg" name="filename" style="visibility: hidden">
        <button type="button" id="selectImg" onclick="selectimg()">select Img</button>
        <input type="radio" name="gender" value="male"><label>Male</label>
        <input type="radio" name="gender" value="female"><label>Female</label>
        <input class="form-control" type="text" placeholder="E-mail" id="email" name="email">
        <input type="submit" value="提交">
    </form>
    <img src="upload/534075ca-aaab-45a7-94a4-22a48cf8f736.jpg" width="100" height="100">
</div>
</body>

</html>