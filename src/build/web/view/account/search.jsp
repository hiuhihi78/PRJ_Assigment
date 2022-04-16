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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
              crossorigin="anonymous">
        <link href="../css/export/viewInvoice.css" rel="stylesheet" type="text/css"/>
        <link href="../css/header.css" rel="stylesheet" type="text/css"/>
        <link href="../css/order/search.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body style="background-color: #efecec;">

        <div class="container-fluid ">
            <div class="row text-center header">
                <a id="btn-home" class="btn btn-lg" href="../home">
                    <i class="fa fa-home fa-2x" aria-hidden="true"></i>
                    <span style="font-weight: bold;">Home</span>
                </a>    
                <h2 id="title">Danh sách khách hàng</h2>
            </div>
        </div>


        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-5">
                <form action="search" method="Get">
                    <b id="orderId">Tên đăng nhập: </b> 
                    <input type="text" name="username" value="${param.pname}">
                    <input class="input" type="submit" value="Searh">
                </form>
            </div>
        </div>

        <div class="row" style="margin-top: 30px;">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <table class="table table-bordered  text-center table-hover">
                    <tr style="background: linear-gradient(0deg, rgba(34,193,195,1) 0%, rgba(253,187,45,1) 100%); color: white; font-size: 15px;">
                        <th>Tên đăng nhập</th>
                        <th>Mật khẩu</th>
                        <th>Tên người dùng</th>
                        <th></th>
                    </tr>
                    <c:forEach items="${requestScope.accounts}" var="a">
                        <tr>
                            <td>${a.username}</td>
                            <td>${a.password}</td>
                            <td>${a.displayname}</td>
                            <c:if test="${a.username !='admin'}">
                                <td><a href="decentralization?username=${a.username}">Phân quyền</a></td>
        <!--                            <td><a href="delete?id=${a.username}">Delete</a></td>-->
                            </c:if>
                            <c:if test="${a.username=='admin'}">
                                <td></td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </table>
                <a href="insert" class="btn btn-info" role="button">Thêm tài khoản</a>

                </body>
                </html>