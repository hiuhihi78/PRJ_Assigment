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
    </head>
    <%
        Orders order = (Orders) request.getSession().getAttribute("cart");
    %>
    <body>
        Mã số khách hàng: ${sessionScope.cart.customer.person.id}<br>
        Tên khách hàng: ${sessionScope.cart.customer.person.name}<br>
        Thời gian mua hàng:  ${sessionScope.cart.date}<br>
        Sản phẩm:
        <table>
            <tr>
                <td>Name</td>
                <td>Quantity</td>
                <td>Discout</td>
                <td>Sell Price</td>
                <td></td>
            </tr>
            <%for(Order_Product p : order.getOrder_Products()){%>
            <tr>
                <td><%= p.getProduct().getName() %></td>
                <td><%= p.getQuantity() %></td>
                <td><%= p.getDiscount() %></td>
                <td><%= p.getSellPrice() %></td>
            </tr>
            <%}%>
        </table>
        Tổng tiền cần phải trả: <%= order.getAmount() %><br>
        Số tiền đã trả: <%= order.getPaid() %><br>
        <button onclick="location.history.back();">Quay lại</button>
        <form action="../cart/checkout" method="POST">
            <input type="submit" value="Chấp nhận"/>
        </form>
    </body>
</html>
