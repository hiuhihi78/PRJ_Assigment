<%-- 
    Document   : update
    Created on : Feb 16, 2022, 10:35:18 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="update" method="POST">
            <input type="hidden" name="id" value="${requestScope.product.id}">
            <label for="name">Name: </label>
            <input type="text" name="name" value="${requestScope.product.name}"/> <br>
            <label for="price">Price: </label>
            <input type="number" min="0" name="price" value="${requestScope.product.price}"/> <br>
            <label for="quantity">Quantity:  </label>
            <input type="number" min="0" name="quantity" value="${requestScope.product.quantity}"/> <br>
            <label for="image">Image : </label>
            <input type="text"  name="image" placeholder="Please!Fill the link image"
                   value="${requestScope.product.image}"/> <br>
            <c:if test = "${requestScope.alter != ''}">
                <p style="color: red"><c:out value = "${salary}"/><p>
            </c:if>
            <input type="submit" value="Update">
        </form>
    </body>
</html>
