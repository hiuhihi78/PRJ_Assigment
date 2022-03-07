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
        <form action="../export/viewInvoice" method="GET">
            <table>
                <tr>
                    <td>Name</td>
                    <td>Quantity</td>
                    <td>Discout</td>
                    <td>Sell Price</td>
                    <td></td>
                </tr>
                <% for (Order_Product p : order.getOrder_Products()) {%>
                <tr>
                <input type="hidden" name="productid" value="<%= p.getProduct().getId() %>">
                <td><%= p.getProduct().getName()%></td>
                <td><input type="number" name="quantity" min="0"
                           max="<%= productDB.getProductById(p.getProduct().getId()).getQuantity() %>"
                           value="<%= p.getQuantity()%>">
                </td>
                <td><input type="number" name="discount" max="100" min="0" value="<%= p.getDiscount()%>"></td>
                <td><input type="number" min="0" name="sellprice" value="<%= p.getSellPrice()%>"></td>
                <td><a href = "delete?productid=<%= p.getProduct().getId()%>">Xoa</a></td>
                </tr>
                <%}%>
            </table>
        </table>
        So tien da nhan: <input type="number" min="0" value="0" name="paid">
        <c:if test="${requestScope.msg!=null}">
            <i style="color: red;">${requestScope.msg}</i>
        </c:if>
        <input type="submit" value="Tạo hóa đơn">
    </form>
    <button onclick="location.href = '../export/listProduct'">Tiep tuc mua hang</button>

</body>
</html>
