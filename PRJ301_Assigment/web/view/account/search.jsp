<%-- 
    Document   : search
    Created on : Feb 19, 2022, 5:03:12 PM
    Author     : Admin
--%>

<%@page import="model.Account"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Account> accounts = (ArrayList<Account>) request.getAttribute("accounts");
            if (accounts == null) {
                accounts = new ArrayList<Account>();
            }
        %>
    </head>
    <body>
        <form action="search" method="Get">
            <input type="text" name="username" value="${param.pname}">
            <input type="submit" value="Searh">
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Displayname</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.accounts}" var="a">
                    <tr>
                        <td>${a.username}</td>
                        <td>${a.password}</td>
                        <td>${a.displayname}</td>
                        <c:if test="${a.username !='admin'}">
                            <td><a href="decentralization?username=${a.username}">Phan quyen</a></td>
<!--                            <td><a href="delete?id=${a.username}">Delete</a></td>-->
                        </c:if>
                        <c:if test="${a.username=='admin'}">
                            <td></td>
                            <td></td>
                        </c:if>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="insert">Insert</a>

    </body>
</html>