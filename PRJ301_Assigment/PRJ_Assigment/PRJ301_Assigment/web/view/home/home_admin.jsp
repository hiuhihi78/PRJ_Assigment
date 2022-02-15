<%-- 
    Document   : home_admin
    Created on : Feb 13, 2022, 5:41:38 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../../css/styleHomeAdmin.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
        <script>
            function doClick(link) {
                location.href = link;
            }
            function doLogout() {
                var comfirm = comfirm("Are you sure?");
                if (comfirm == true) {
                    location.href = "#";
                }
            }
        </script>
    </head>

    <body>
        <div class="container">

            <div class="container-fluid">
                <div class="navbar navbar-inverse">

                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">HaNaShop</a>
                    </div>

                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#">Xuất hàng</a></li>
                        <li><a href="#">Nhập hàng</a></li>
                        <li><a href="#">Hóa đơn</a></li>
                        <li><a href="#">Biên lai nhận hàng</a></li>
                        <li><a href="#">Quản lý tài khoản</a></li>
                    </ul>
                    <div class="navbar-right logout">
                        <button class="btn btn-default" onclick="doLogout();">Đăng xuất</button>
                    </div>


                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse"
                                data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>

                    </div>
                </div>
            </div>
            <div class="row">
                <div class="header col-md-12">
                    <img src="../../images/Banner01.jpg" alt=""/>
                </div>
            </div>
            
            
            
            <div class="row" style="margin-top: 300px;">

            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="text-center footer">
                        <p>Email : NhanhHauCuQua@gmai.com</p>
                        <p>Address: La Tinh- Dong La- Hoai Duc - HN</p>
                        <h5>&copy; Copyright 2022. HaNaShop.VN</h5>
                    </div>
                </div>
            </div>

        </div>
    </body>

</html>
