<%-- 
    Document   : search
    Created on : Mar 17, 2022, 10:56:43 AM
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


        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-5">
                <form  action="search" id="form" method="GET">
                    <b id="orderId">Mã số khách hàng: </b> 
                    <input class="input" type="number" name="id" value="${param.id}">
                    <input type="submit" class="btn btn-success btn-sm" value="Tìm kiếm">
                </form>
            </div>
        </div>

        <div class="row" style="margin-top: 30px;">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <table class="table table-bordered  text-center table-hover">
                    <tr style="background: linear-gradient(0deg, rgba(34,193,195,1) 0%, rgba(253,187,45,1) 100%); color: white; font-size: 15px;">
                        <th>Mã số</th>
                        <th>Tên</th>
                        <th>Giới tính</th>
                        <th>Ngày sinh</th>
                        <th>Địa chỉ</th>
                        <th>Số ĐT</th>
                        <th></th>
                    </tr>
                    <c:if test="${requestScope.customers != null}">
                        <c:forEach items="${requestScope.customers}" var="customer">
                            <tr>
                                <td>${customer.person.id}</td>
                                <td>${customer.person.name}</td>
                                <td>${customer.person.gender == true ? "Nam" : "Nữ"}</td>
                                <td>${customer.person.dob}</td>
                                <td>${customer.person.address}</td>
                                <td>${customer.person.phone}</td>
                                <td><a href="update?id=${customer.person.id}">Chỉnh sửa</a></td>
                                <td><a href="detail?id=${customer.person.id}">Chi tiết</a></td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </table>
                <div class="col-md-2"></div>
            </div>
        </div>
    </body>
</html>
