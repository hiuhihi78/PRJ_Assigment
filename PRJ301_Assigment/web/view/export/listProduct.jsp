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
    </head>
    <%
        ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
    %>

    <body>
        <h2>Xin mời bạn ${sessionScope.customer.person.name}, chọn mặt hàng yêu thích!</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.products}" var="p">
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td>
                    <form action="../cart/add" method="POST">
                        <input type="hidden" name="id" value="${p.id}">
                        <input type="submit" value="Select">
                    </form>
                </td>
            </c:forEach>
        </tbody>
    </table>
        <button onclick="location.href = '../cart/checkout'"">Thanh toan</button>
</body>
</html>
