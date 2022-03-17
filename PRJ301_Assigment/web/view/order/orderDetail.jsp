<%-- 
    Document   : orderDetail
    Created on : Mar 12, 2022, 12:00:55 PM
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
                <h1 id="title"  > Hóa Đơn</h1>
            </div>
        </div>

        <div class="container" >
            <h4><b>Mã số hóa đơn:</b> ${requestScope.order.customer.person.id}</h4>
            <h4><b>Mã số khách hàng:</b> ${requestScope.order.customer.person.id}</h4>
            <h4><b>Tên khách hàng:</b> ${requestScope.order.customer.person.name}</h4>
            <h4><b>Thời gian mua hàng: </b> ${requestScope.order.date}</h4>
            <h4><b>Người bán: </b>${requestScope.order.seller.displayname}</h4>
            <h4><b>Sản phẩm:</b></h4>
            <table class="table table-bordered table-hover" style="font-size: 20px;">
                <tr style="background-color: #07A0C7">
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Discout</th>
                    <th>Sell Price</th>
                </tr>
                <c:forEach items="${requestScope.order.getOrder_Products()}" var="p">
                    <tr>
                        <td>${p.product.name}</td>
                        <td>${p.quantity}</td>
                        <td>${p.discount}</td>
                        <td>${p.sellPrice}</td>
                    </tr>
                </c:forEach>
            </table>
            <h4><b>Tổng tiền cần phải trả:</b> ${requestScope.order.amount}</h4>
            <h4><b>Số tiền đã trả:</b> ${requestScope.order.paid}</h4>
            <button class="btn btn-info" id="previous" onclick="history.go(-1);">Quay lại</button>
           
        </div>
    </body>
</html>
