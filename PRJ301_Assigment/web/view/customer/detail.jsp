<%-- 
    Document   : detail
    Created on : Mar 17, 2022, 12:07:24 PM
    Author     : Admin
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="model.Customer"%>
<%@page import="model.Orders"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
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
            <h4><b>Mã số khách hàng:</b> ${requestScope.customer.person.id}</h4>
            <h4><b>Tên khách hàng:</b> ${requestScope.customer.person.name}</h4>
            <h4><b>Giới tính:</b> ${requestScope.customer.person.gender}</h4>
            <h4><b>Ngày sinh:</b> ${requestScope.customer.person.dob}</h4>
            <h4><b>Địa chỉ:</b> ${requestScope.customer.person.address}</h4>
            <h4><b>Số điện thoại:</b> ${requestScope.customer.person.phone}</h4>
            <h4><b>Hóa đơn:</b></h4>
            <table class="table table-bordered table-hover" style="font-size: 20px;">
                <tr style="background-color: #07A0C7">
                    <th>Mã hóa đơn</th>
                    <th>Thời gian mua</th>
                    <th>Số tiền đã trả</th>
                    <th>Tổng tiền hóa đơn</th>
                    <th>Người bán</th>
                    <th></th>
                </tr>
                <c:forEach items="${requestScope.customer.getOrders()}" var="order">
                    <tr>
                        <td>${order.getId()}</td>
                        <td>${order.date}</td>
                        <td>${order.paid}</td>
                        <td>${order.amount}</td>
                        <td>${order.seller.displayname}</td>
                        <td><a href="../order/detail?orderID=${order.id}">Chi tiết</a></td>
                    </tr>
                </c:forEach>
            </table>
            <h4><b>Tổng hóa tiền đã trả:</b> ${requestScope.customer.getTotalPaid()}</h4>
            <h4><b>Tổng hóa tiền tất cả hóa đơn:</b> ${requestScope.customer.getTotalAmount()}</h4>
        </div>
    </body>
</html>
