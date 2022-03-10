<%-- 
    Document   : newCustomer
    Created on : Mar 1, 2022, 6:03:35 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/export/choseCustomer.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" 
              crossorigin="anonymous">
        <!--<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">-->
        <link href="../css/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container-fluid ">
            <div class="row text-center header">
                <a id="btn-home" class="btn btn-lg" href="../home">
                    <i class="fa fa-home fa-2x" aria-hidden="true"></i>
                    <span style="font-weight: bold;">Home</span>
                </a>    
                <h2 id="title">Nhập thông tin khách hàng</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 col-ms-4"></div>

            <div class="col-md-4 col-ms-4" style="margin-top: 30px;
                 border: 1px solid black; border-radius: 10px; padding: 20px 20px 20px 20px;
                 background-color: white; font-size: 15px;">

                <form action="newCustomer" method="POST"  >
                    <div class="form-group">
                        <label for="id">Mã số CMTND: </label>
                        <input type="text"  class="form-control" name="id" value="${param.id}">
                    </div>
                    <div class="form-group">
                        <label for="name">Họ và tên::</label>
                        <input type="text"  class="form-control" name="name" value="${param.name}">
                    </div>
                    <div class="form-group">
                        <label for="pwd">Ngày sinh: </label>
                        <input type="date" class="form-control" name="dob" value="${param.dob}">
                    </div>
                    <div class="form-check-inline">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input" name="gender" checked="checked" value="male"> Nam  
                        </label>
                    </div>
                    <div class="form-check-inline">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input" name="gender" value="female"> Nữ 
                        </label>
                    </div>
                       
                    <div class="form-group">
                        <label for="phone">Số điện thoại:</label>
                        <input type="text" class="form-control" name="phone" value="${param.phone}">
                    </div> 
                    <div class="form-group">
                        <label for="address"> Địa chỉ:</label>
                        <input type="text" class="form-control" name="address" value="${param.address}">
                    </div>

                    <c:if test="${requestScope.customerExisted != null}">
                        <i class="alert alert-danger">${requestScope.customerExisted}</i><br>
                    </c:if>
                    <c:if test="${requestScope.msg != null}">
                        <i class="alert alert-danger">${requestScope.msg}</i><br>
                    </c:if>
                    <input  class="btn btn-primary" style="margin-top: 10px;" type="submit" value="Save">
                </form>
            </div>
            <div class="col-md-4 col-ms-4"></div>
        </div>

    </body>
</html>
