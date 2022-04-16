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
        
        <h2>Phân quyền truy cập</h2>
        <p>Tên người dùng: ${requestScope.account.displayname}</p>
        <form action="decentralization" method="POST">
            <input type="hidden" name="username" value="${requestScope.account.username}">
            <c:forEach items="${requestScope.groups}" var="g">
                <input type="checkbox"
                       <c:forEach items="${requestScope.account.groups}" var="ag">
                           <c:if test = "${g.id == ag.group.id}">
                               <%= "checked='checked'"%>
                           </c:if>
                       </c:forEach>
                       name="gid" value="${g.id}"> ${g.name} <br>
            </c:forEach>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
