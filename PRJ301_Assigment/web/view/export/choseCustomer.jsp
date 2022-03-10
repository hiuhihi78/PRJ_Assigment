<%-- 
    Document   : choseCustomer
    Created on : Mar 1, 2022, 5:43:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/export/choseCustomer.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container-fluid ">
            <div class="row text-center header">
                <a id="btn-home" class="btn btn-lg" href="home">
                    <i class="fa fa-home fa-2x" aria-hidden="true"></i>
                    <span style="font-weight: bold;">Home</span>
                </a>    
                <h2 id="title"  >Chọn loại khách hàng</h2>
            </div>
        </div>
        <div class="text-center"> 
            <form  action="export" method="POST">
                <input type="hidden" name="customerType" value="new"/>
                <input class="button" type="submit" value="Khách hàng mới">
            </form>
        </div>
        <div class="text-center"> 
            <form  action="export" method="POST">
                <input type="hidden" name="customerType" value="old"/>
                <input class="button" type="submit" value="Khách đã mua hàng">
            </form>
        </div>
    </body>
</html>
