    <%-- 
    Document   : admin
    Created on : Feb 15, 2022, 8:29:42 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!--bosstrap-->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/home.js" type="text/javascript"></script>
        <!--bosstrap-->

        <!--css-->
        <link href="css/stylehomeadmin.css" rel="stylesheet" type="text/css"/>
        <!--css-->

        <!--js-->
        <script src="js/home.js" type="text/javascript"></script>
        <!--js-->


        <title>JSP Page</title>
    </head>
    <body>
        <div class="header">

            <div class="menu">

                <div id="mySidenav" class="sidenav">
                    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                    <a href="#">Tài khoản</a>
                    <a href="../../logout">Đăng xuất</a>
                </div>
                <span id="open" style="font-size:30px;cursor:pointer;" onclick="openNav()">&#9776;</span>
            </div>

            <!--            <div id="logo">
                            <a href="admin.jsp"><img src=""></a>
                        </div>-->

        </div>
        <div class="container-fluid">
            <img src="images/banner.png" class="img-responsive" alt=""/>
        </div>

        <div class="container-fluid">

            <div class="row wellcome text-center">
                <h2>Xin chào, ${requestScope.displayname}<br> Chúc bạn có một ngày tốt lành!</h2>
            </div>

            <div class="row">
                <div class="col-lg-4 navigation">
                    <button onclick="doNavigation('#');">Xuất hàng</button>
                </div>
                <div class="col-lg-4 navigation">
                    <button onclick="doNavigation('#');">Nhập hàng</button>
                </div>
                <div class="col-lg-4 navigation">
                    <button onclick="doNavigation('#');">Hóa Đơn</button>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-4 navigation">
                    <button onclick="window.location='product/search'">Sản Phẩm</button>
                </div>
                <div class="col-lg-4 navigation">
                    <button onclick="doNavigation('#');">Khách hàng</button>
                </div>
                <div class="col-lg-4 navigation">
                    <button onclick="window.location='account/search'">Quản Lý tài khoản</button>
                </div>
            </div>

            <div class="row">
                <div id="footer" class="text-center">
                    <p>Email : NhanhHauCuQua@gmail.com</p>
                    <p>Address: La Tinh - Đông La - Hoài Đức - Hà Nội</p>
                    <h5>&copy; Copyright 2022. NhanhHauCuQua.com</h5>
                </div>
            </div> 
        </div>

    </body>
</html>
