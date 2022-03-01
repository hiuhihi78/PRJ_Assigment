<%-- 
    Document   : checkout
    Created on : Mar 1, 2022, 9:40:50 PM
    Author     : Admin
--%>

<%@page import="model.Order_Product"%>
<%@page import="model.Orders"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dal.ProductDBContext"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        ProductDBContext productDB = new ProductDBContext();
        Orders order = (Orders) request.getSession().getAttribute("cart");
    %>
    <body>
        <h2>Thanh toán</h2>
        <form action="checkout" method="POST">
            <table>
                <tr>
                    <td>Name</td>
                    <td>Quantity</td>
                    <td>Discout</td>
                    <td>Sell Price</td>
                </tr>
                <% for (Order_Product p : order.getOrder_Products()) {%>
                <tr>
                    <td><%= p.getProduct().getName() %></td>
                    <td><input type="number" name="quantity" min="0"
                               max="<%= productDB.getProductById(p.getProduct().getId()) %>"
                               value="<%= p.getQuantity() %>">
                    </td>
                    <td><input type="number" name="discount" max="100" min="0" value="<%= p.getDiscount()%>"></td>
                    <td><input type="number" min="0" name="sellprice" value="<%= p.getSellPrice()%>"></td>
                </tr>
                <%}%>

               

            </table>
        </form>
    </body>
</html>
