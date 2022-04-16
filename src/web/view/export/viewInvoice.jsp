<%-- 
    Document   : viewInvoice
    Created on : Mar 5, 2022, 8:58:04 AM
    Author     : Admin
--%>

<%@page import="model.Orders"%>
<%@page import="model.Order_Product"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
              crossorigin="anonymous">
        <link href="../css/export/viewInvoice.css" rel="stylesheet" type="text/css"/>
        <link href="../css/header.css" rel="stylesheet" type="text/css"/>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <%
        Orders order = (Orders) request.getSession().getAttribute("cart");
    %>
    <body>

        <div class="container-fluid header">
            <div class="row text-center">
                <a id="btn-home" class="btn btn-lg" href="../home">
                    <i class="fa fa-home fa-2x" aria-hidden="true"></i>
                    <span style="font-weight: bold;">Home</span>
                </a>    
                <h2 id="title"  >Kiem tra hoa don</h2>
            </div>
        </div>

        <div class="container" >
            <h4><b>Mã số khách hàng:</b> ${sessionScope.cart.customer.person.id}</h4>
            <h4><b>Tên khách hàng:</b> ${sessionScope.cart.customer.person.name}</h4>
            <h4><b>Thời gian mua hàng: </b> ${sessionScope.cart.date}</h4>
            <h4><b>Người bán: </b>${sessionScope.account.displayname}</h4>
            <h4><b>Sản phẩm:</b></h4>
            <table class="table table-bordered table-hover" style="font-size: 20px;">
                <tr style="background-color: #07A0C7">
                    <th>Tên sản phẩn</th>
                    <th>Số lượng</th>
                    <th>Giảm giá(%)</th>
                    <th>Giá bán</th>
                    <th>Thành tiền</th>
                </tr>
                <c:forEach items="${sessionScope.cart.getOrder_Products()}" var="p">
                    <tr>
                        <td>${p.product.name}</td>
                        <td>${p.quantity}</td>
                        <td>${p.discount}</td>
                        <td>${p.sellPrice}</td>
                        <td>${(p.quantity * p.sellPrice) * (1 - p.discount/100)}</td>
                    </tr>
                </c:forEach>
            </table>
            <h4><b>Tổng tiền cần phải trả:</b> <%= order.getAmount()%></h4>
            <h4><b>Số tiền đã trả:</b> <%= order.getPaid()%></h4>
            <button class="btn btn-info" id="previous" onclick="window.history.go(-1);">Quay lại</button>
            <form action="../export/makeInvoice" method="GET">
                <input class="btn btn-danger" id="submit" type="submit" value="Chấp nhận"/>
            </form>
        </div>
    </body>
</html>
