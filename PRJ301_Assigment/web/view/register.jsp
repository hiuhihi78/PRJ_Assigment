<%-- 
    Document   : register
    Created on : Mar 14, 2022, 4:44:52 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4" id="form">
                    <h2>Đăng kí</h2>
                    <form action="register" method="POST" class="was-validated">
                        <div class="form-group">
                            <label for="username">Tên đang nhập:</label>
                            <input type="text" class="form-control" placeholder="Nhập tên đang nhập" 
                                   name="username" value="${param.username}" required>
                            <div class="valid-feedback">Hợp lệ</div>
                            <div class="invalid-feedback">Hãy điền đầy đủ thông tin</div>
                        </div>

                        <div class="form-group">
                            <label for="password">Mật khẩu:</label>
                            <input type="password" class="form-control" placeholder="Nhập mật khẩu" 
                                   name="password" value="${param.password}" required>
                            <div class="valid-feedback">Hợp lệ</div>
                            <div class="invalid-feedback">Hãy điền đầy đủ thông tin</div>
                        </div>

                        <div class="form-group">
                            <label for="displayname">Tên người dùng:</label>
                            <input type="text" class="form-control" placeholder="Nhập tên người dùng" 
                                   name="displayname" value="${param.password}" required>
                            <div class="valid-feedback">Hợp lệ</div>
                            <div class="invalid-feedback">Hãy điền đầy đủ thông tin</div>
                        </div>
                        <c:if test="${requestScope.alter == 'failed' }">
                            <div class="alert alert-danger">
                                Tên đăng nhập đã tồn tại!
                            </div>
                            <i style="color:  red"></i>
                        </c:if>
                        <c:if test="${requestScope.alter == 'success' }">
                            <div class="alert alert-success">
                                Đăng kí thành công!<br>
                                <a href="login" class="btn btn-info" role="button" >Đăng nhập</a>
                            </div>
                        </c:if>
                        <a href="login" class="btn btn-info" role="button" >Quay lại</a>
                        <input type="submit" class="btn btn-success" value="Đăng kí">
                    </form>
                </div>
                <div  class="col-md-4"></div>
            </div>
        </div>
    </body>
</html>
