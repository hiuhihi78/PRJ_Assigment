<%-- 
    Document   : insert
    Created on : Feb 15, 2022, 11:01:04 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="insert" method="POST">
            Name: <input type="text" name="name"/> <br>
            Price: <input type="number" min="0" name="price"/> <br>
            Quantity: <input type="number" min="0" name="quantity"/> <br>
            Image : <input type="text"  name="image" placeholder="Please!Fill the link image"/> <br>
            <c:if test = "${requestScope.alter != ''}">
                <p style="color: red"><c:out value = "${salary}"/><p>
            </c:if>
            <input type="submit" value="Insert">
        </form>
    </body>
</html>
