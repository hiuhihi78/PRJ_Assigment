<%-- 
    Document   : login
    Created on : Jan 14, 2022, 11:02:23 AM
    Author     : Admin
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <style>
            #form{
                border: 1px solid black;
                border-radius: 10px;
                padding-bottom: 20px;
                margin-top: 100px;
                padding-top: 20px;
                background-color: white;
            }
        </style>
    </head>
    <body style="background-color: #efecec;">
        <div  class="container-fluid">
            <div class="row">
                <div class="col-md-2"></div>

                <div class="col-md-3" id="form">
                    <h2>Đăng nhập</h2>
                    <form action="login" method="POST" class="was-validated">
                        <div class="form-group">
                            <label for="username">Tên đăng nhập: </label>
                            <input  type="text" onchange="checkInput();" class="form-control"  placeholder="Nhập tên đăng nhập" 
                                    name="username" value="${param.username}" required>
                        </div>

                        <div class="form-group">
                            <label for="username">Mật khẩu: </label>
                            <input type="password" onchange="checkInput();"  class="form-control" id="uname" placeholder="Nhập mật khẩu" 
                                   name="password"  value="${param.password}" required>

                        </div>

                        <c:if test="${requestScope.message!=null}">
                            <div id="message" class="alert alert-danger ">
                                Tên đăng nhập hoặc mật khẩu không đúng!
                            </div>
                        </c:if>
                        <a href="register" class="btn btn-info" role="button">Đăng ký</a>
                        <input class="btn btn-success" type="submit" value="Đăng nhập">
                    </form>
                </div>
            </div>
        </div>
        <script>
            function checkInput(){
                document.getElementById('message').style = 'display : none';
            }
        </script>
    </body>
</html>
