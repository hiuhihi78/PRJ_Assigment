<%-- 
    Document   : home_admin
    Created on : Feb 13, 2022, 5:41:38 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        </script>
    </head>

    <body>
        <div class="container">

            <div class="header col-md-12">
                <img src="../../images/Banner01.jpg" alt=""/>
            </div>

            <div class="main col-md-12">

                <div class="text-center">
                    <h2>Xin chào, <br> Chúc bạn có một ngày tốt lành</h2>
                </div>

                <div class="row">
                    <button class="col-md-3 task"
                            onclick="doClick('adaw');">
                        View orders
                    </button>

                    <button class="col-md-3 task"
                            onclick="doClick('adaw');">
                        View customer
                    </button>

                    <button class="col-md-3 task"
                            onclick="doClick('adaw');">
                    </button>
                </div>

                <div class="row">
                    <button class="col-md-3 task"
                            onclick="doClick('adaw');">

                    </button>

                    <button class="col-md-3 task"
                            onclick="doClick('adaw');">

                    </button>

                    <button class="col-md-3 task"
                            onclick="doClick('adaw');">

                    </button>
                </div>
            </div>

            <div class="col-md-12 footer">
                <div class="row">
                    <div class="text-center footer">
                        <p>Email : RauCuQuaNhanhHau@gmail.com</p>
                        <p>Address: La Tinh - Dong La - Hoai Duc - Ha Noi</p>
                        <h5>&copy; Copyright 2021. RauCuQua.VN</h5>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
