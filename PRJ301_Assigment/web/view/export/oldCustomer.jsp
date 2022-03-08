<%-- 
    Document   : oldCustomer
    Created on : Mar 5, 2022, 9:45:35 PM
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
        <form action="oldCustomer" method="POST">
            <label for="id">Mã CMTND: </label>
            <input type="number" name="id" value="${param.id}">
            <c:if test="${requestScope.msgId!=null}">
                <i style="color: red;">${msgID}</i>
            </c:if>
            <input type="submit" value="search">
            <c:if test="${requestScope.alert!=null}">
                <i style="color: red;">${alert}</i>
            </c:if>
            <c:if test="${requestScope.msgId!=null}">
                <i style="color: red;">${msgId}</i>
            </c:if>
        </form>
    </body>
</html>
