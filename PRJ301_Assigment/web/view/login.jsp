<%-- 
    Document   : login
    Created on : Jan 14, 2022, 11:02:23 AM
    Author     : Admin
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
    
    <body>
        <h2>Đăng nhập</h2>
        <form action="login" method="POST">
            <table>
                <tr>
                    <td>User name: </td>
                    <td><input type="text" name="username" value="${param.username}"></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="password" value="${param.password}"></td>
                </tr>
                <c:if test="${requestScope.message!=null}">
                    <tr>
                        <td></td>
                        <td><i style="color: red">${requestScope.message}</td>
                    </tr>
                </c:if>
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
