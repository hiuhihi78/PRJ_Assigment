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

            function doDelete(id) {
                var comfirm = window.confirm("Are you sure?");
                if (comfirm == true) {
                    window.location.href = "delete?id=" + id;
                }
            }
        </script>
    </head>
    <body>
        <form action="search" method="Get">
            <input type="text" onchange="doSubmit();" name="pname" value="${param.pname}">
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

                <c:forEach items="${requestScope.products}" var="p">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.name}</td>
                        <td>${p.price}</td>
                        <td>${p.quantity}</td>
                        <td>${p.image}</td>
                        <td><a href="update?id=${p.id}">Update</a></td>
                        <td><a href="#" onclick="doDelete(${p.id});">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <button onclick="location.href = 'insert'">Insert new product</button>

    </body>
</html>
