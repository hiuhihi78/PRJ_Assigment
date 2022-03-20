<%-- 
    Document   : exportSuccessfully
    Created on : Mar 7, 2022, 11:54:08 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/export/choseCustomer.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" 
              crossorigin="anonymous">
        <!--<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">-->
        <link href="../css/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container-fluid ">
            <div class="row text-center header">
                <a id="btn-home" class="btn btn-lg" href="home">
                    <i class="fa fa-home fa-2x" aria-hidden="true"></i>
                    <span style="font-weight: bold;">Home</span>
                </a>    
                <h2 id="title"  ></h2>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <h1>Tạo hóa đơn thành công!</h1>
                <h3><b>Mã đơn hàng: </b> ${requestScope.orderId} </h3>
                <a href="../home" class="btn btn-info" role="button">Quay lại trang chủ</a>
                <a href="../order/detail?orderID=${requestScope.orderId}" class="btn btn-success" role="button">
                    Kiểm tra thông tin hóa đơn
                </a>
            </div>
        </div>
    </body>
</html>
