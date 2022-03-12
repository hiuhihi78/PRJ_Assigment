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
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/header.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
              crossorigin="anonymous">
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/export/oldCustomer.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
        <div class="container-fluid ">
            <div class="row text-center header">
                <a id="btn-home" class="btn btn-lg" href="../home">
                    <i class="fa fa-home fa-2x" aria-hidden="true"></i>
                    <span style="font-weight: bold;">Home</span>
                </a>    
                <h2 id="title">Khách hàng</h2>
            </div>
        </div>
        <div class="body">
            <form action="oldCustomer" method="POST">
                <label for="id">Mã CMTND: </label>
                <input type="number" name="id" value="${param.id}">
                <input class="btn btn-danger " type="submit" value="search">
            </form>
                <c:if test="${requestScope.msgId!=null}">
                    <p id="message">${msgId}</p>
                </c:if>
                
                <c:if test="${requestScope.alert!=null}">
                    <p id="message">${alert}</p>
                </c:if>
        </div>
    </body>
</html>
