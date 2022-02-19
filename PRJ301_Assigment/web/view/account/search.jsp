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
                <%for (Account a : accounts) {%>
                <tr>
                    <td><%= a.getUsername()%></td>
                    <td><%= a.getPassword()%></td>
                    <td><%= a.getDisplayname()%></td>
                    <td><a href="delete?id=<%= a.getUsername()%>">Delete</a></td>
                </tr>
                <%}%>
            </tbody>
        </table>
        <button onclick="location.href = 'insert'">Insert new Account</button>

    </body>
</html>