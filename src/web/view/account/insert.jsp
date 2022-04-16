<%-- 
    Document   : insert
    Created on : Feb 19, 2022, 4:22:11 PM
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
        <form action="../account/insert" method="POST">
            <label for="username">Tên đăng nhập: </label>
            <input type="text" name="username" value="${param.username}"/><br>
            <label for="password"/>Mật khẩu: </label>
            <input type="password" name="password" value="${param.password}"/><br>
            <label for="displayname"/>Tên người dùng: </label>
            <input type="text" name="displayname" value="${param.displayname}"/><br>
            <c:if test="${requestScope.alter!=null}">
                <i style="color: red">${requestScope.alter}</i><br>
            </c:if>
            <input type="submit" value="Đăng Ký">
        </form>
    </body>
</html>
