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
        <script src="../js/checkout.js" type="text/javascript"></script>
        <title>JSP Page</title>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/header.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
              crossorigin="anonymous">
        <link href="../css/export/checkout.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        ProductDBContext productDB = new ProductDBContext();
        Orders order = (Orders) request.getSession().getAttribute("cart");
    %>
    <body>
        <div class="container-fluid ">
            <div class="row text-center header">
                <a id="btn-home" class="btn btn-lg" href="../home">
                    <i class="fa fa-home fa-2x" aria-hidden="true"></i>
                    <span style="font-weight: bold;">Home</span>
                </a>    
                <h2 id="title">Thanh toán</h2>
            </div>
        </div>
        <div class="body">
            <form action="../export/viewInvoice" method="GET">
                <table class="table table-striped">
                    <tr>
                        <td>Name</td>
                        <td>Quantity</td>
                        <td>Discout</td>
                        <td>Sell Price</td>
                        <td></td>
                    </tr>
                    <% for (Order_Product p : order.getOrder_Products()) {%>
                    <tr>
                    <input type="hidden" name="productid" value="<%= p.getProduct().getId()%>">
                    <td><%= p.getProduct().getName()%></td>
                    <td><input type="number" name="quantity" min="0"
                               max="<%= productDB.getProductById(p.getProduct().getId()).getQuantity()%>"
                               value="<%= p.getQuantity()%>">
                    </td>
                    <td><input type="number" name="discount" max="100" min="0" value="<%= p.getDiscount()%>"></td>
                    <td><input type="number" min="0" name="sellprice" value="<%= p.getSellPrice()%>"></td>
                    <td><a href = "delete?productid=<%= p.getProduct().getId()%>">Xoa</a></td>
                    </tr>
                    <%}%>
                </table>
                </table>
                <p>So tien da nhan: 
                    <input  style="width: 200px; " type="number" min="0" value="0" name="paid">
                </p>
                    <c:if test="${requestScope.alter!=null}">
                    <i id="alter" style="color: red;">${requestScope.alter}</i>
                </c:if>
                <input id="submit" class="btn btn-danger" type="submit" value="Tạo hóa đơn">
            </form>
                <button id="previous" class="btn btn-secondary" onclick="location.href = '../export/listProduct'">Tiep tuc mua hang</button>
        </div>

    </body>
</html>
