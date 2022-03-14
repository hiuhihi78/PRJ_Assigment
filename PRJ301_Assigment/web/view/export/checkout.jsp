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
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/export/checkout.css" rel="stylesheet" type="text/css"/>
        <link href="../css/header.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
              crossorigin="anonymous">
    </head>
    <%
        ProductDBContext productDB = new ProductDBContext();
        Orders order = (Orders) request.getSession().getAttribute("cart");
    %>
    <body style="background-color: #efecec;">
        <div class="container-fluid ">
            <div class="row text-center header">
                <a id="btn-home" class="btn btn-lg" href="../home">
                    <i class="fa fa-home fa-2x" aria-hidden="true"></i>
                    <span style="font-weight: bold;">Home</span>
                </a>    
                <h2 id="title">Thanh toán</h2>
            </div>
        </div>

        <div class="body" style="margin-top: 50px;border: 1px solid black;
             border-radius: 10px; background-color: white; padding-left: 5px;
             padding-right: 5px;"
             >
            <p></p>
            <form action="../export/viewInvoice" method="POST">
                <table class="table table-bordered table-hover">
                    <tr style="background-color: #07A0C7">
                        <td ><b>Giá</b></td>
                        <td ><b>Số lượng</b></td>
                        <td ><b>Giảm giá(%)</b></td>
                        <td ><b>Giá bán</b></td>
                        <td ></td>
                    </tr>
                    <% for (Order_Product p : order.getOrder_Products()) {%>
                    <tr>
                    <input type="hidden" name="productid" value="<%= p.getProduct().getId()%>">
                    <td><%= p.getProduct().getName()%></td>
                    <td><input type="number" name="quantity" min="1"
                               max="<%= productDB.getProductById(p.getProduct().getId()).getQuantity()%>"
                               value="<%= p.getQuantity()%>">
                    </td>
                    <td><input type="number" name="discount" max="100" min="0" value="<%= p.getDiscount()%>"></td>
                    <td><input type="number" min="0" name="sellprice" value="<%= p.getSellPrice()%>"></td>
                    <td><a href = "delete?productid=<%= p.getProduct().getId()%>">Xóa</a></td>
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
            <button id="previous" class="btn btn-secondary" onclick="location.href = '../export/listProduct'">
                Tiếp tục mua hàng
            </button>
        </div>

    </body>
</html>
