<%-- 
    Document   : login
    Created on : Jan 14, 2022, 11:02:23 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            body{
                text-align: center;
            }
            table{
                margin: 0 auto;
            }
        </style>
    </head>
    <%
        String message = (String) request.getAttribute("message");
        if (message == null) {
            message = "";
        }
    %>
    <body>
        <h2>Login</h2>
        <form action="login" method="POST">
            <table>
                <tr>
                    <td>User name: </td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="password"></td>
                </tr>
                <% if (!message.isEmpty()) {%>
                <tr>
                    <td></td>
                    <td><i style="color: red"><%= message%></i></td>
                </tr>
                <%}%>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Login"></td>
                </tr>

            </table>
        </form>
                
    </body>
</html>
