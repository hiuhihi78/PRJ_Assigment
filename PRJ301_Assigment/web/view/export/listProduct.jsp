<%-- 
    Document   : listProduct
    Created on : Mar 1, 2022, 8:32:55 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/export/listProduct.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
              crossorigin="anonymous">
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/header.css" rel="stylesheet" type="text/css"/>

        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    </head>

    <body>
        <div class="container-fluid ">
            <div class="row text-center header">
                <a id="btn-home" class="btn btn-lg" href="../home">
                    <i class="fa fa-home fa-2x" aria-hidden="true"></i>
                    <span style="font-weight: bold;">Home</span>
                </a>    
                <h2 id="title">Xin mời bạn ${sessionScope.customer.person.name}, chọn mặt hàng yêu thích!</h2>
            </div>
        </div>
        <div class="container" style="margin-top: 50px;">
            <table id="table" class="table table-bordered table-hover" style="font-size: 20px;
                   background-color: white; border-radius: 10px; ">
                <thead>
                    <tr style="background-color: #07A0C7">
                        <th>Name</th>
                        <th>Price</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.products}" var="p">
                        <tr>
                            <td>${p.name}</td>
                            <td>${p.price}</td>
                            <td style="width: 20%;" class="text-center">
                                <form action="../cart/add" method="POST">
                                    <input type="hidden" name="id" value="${p.id}">
                                    <input  class="btn btn-success" type="submit" value="Select">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div style="margin-left: 70%;">
            <c:if test="${requestScope.alter != null}">
                <div style="width: 15vw;" class="alert alert-danger alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Thông báo!</strong> ${requestScope.alter}
                </div>
            </c:if>
            <button class="btn btn-info" id="previous" onclick="window.history.go(-1);">Quay lại</button>
            <button class="btn btn-danger" onclick="location.href = '../cart/checkout'">Thanh toan</button>
        </div>
    </body>
</html>
