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
            #regiser{
                position: relative;
                left:40%;
            }
            #regiser a{
                text-decoration: none;
                color: black;
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
        <h2>Đăng nhập</h2>
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
                    <td><button id="regiser"><a href="account/insert">Đăng kí</a></button></td>
                    <td>
                        <input type="submit" value="Đăng nhập">
                    </td>
                </tr>
            </table>
        </form>

    </body>
</html>
