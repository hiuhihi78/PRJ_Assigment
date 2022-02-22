<%-- 
    Document   : decentralization
    Created on : Feb 20, 2022, 10:19:59 AM
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
        <h2>Phân quyền truy cập</h2>
        <p>Tên người dùng: ${requestScope.account.displayname}</p>
        <form action="decentralization" method="POST">
            <input type="hidden" name="username" value="${requestScope.account.username}">
            <c:forEach items="${requestScope.groups}" var="g">
                <c:forEach items="${requestScope.account.groups}" var="ag">
                    <input type="checkbox"
                           <c:if test = "${g.id == ag.group.id}">
                               <%= "checked='checked'"%>
                           </c:if>
                           name="gid" value="${g.id}"> ${g.name} <br>
                </c:forEach>
            </c:forEach>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
