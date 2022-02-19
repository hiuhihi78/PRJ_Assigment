<%-- 
    Document   : search
    Created on : Feb 15, 2022, 10:12:39 PM
    Author     : Admin
--%>

<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <%
            ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
            if (products == null) {
                products = new ArrayList<Product>();
            }
        %>
        <script>
            function doSubmit() {
                document.getElementById("searchForm").submit();
            }
        </script>
    </head>
    <body>
        <form action="search" method="Get">
            <input type="text" name="pname" value="${param.pname}">
            <input type="submit" value="Searh">
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Image</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%for (Product p : products) {%>
                <tr>
                    <td><%= p.getId()%></td>
                    <td><%= p.getName()%></td>
                    <td><%= p.getPrice()%></td>
                    <td><%= p.getQuantity()%></td>
                    <td><%= p.getImage()%></td>
                    <td><a href="update?id=<%= p.getId()%>">Update</a></td>
                    <td><a href="delete?id=<%= p.getId()%>">Delete</a></td>
                </tr>
                <%}%>
            </tbody>
        </table>
            
        <button onclick="location.href = 'insert'">Insert new product</button>
        
    </body>
</html>
