<%-- 
    Document   : search
    Created on : Mar 10, 2022, 11:58:31 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="../js/pagger.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
              crossorigin="anonymous">
        <link href="../css/export/viewInvoice.css" rel="stylesheet" type="text/css"/>
        <link href="../css/header.css" rel="stylesheet" type="text/css"/>
        <link href="../css/order/search.css" rel="stylesheet" type="text/css"/>
        <!--<script src="../js/paggerNomal.js" type="text/javascript"></script>-->
    </head>
    <body style="background-color: #efecec;">

        <div class="container-fluid ">
            <div class="row text-center header">
                <a id="btn-home" class="btn btn-lg" href="../home">
                    <i class="fa fa-home fa-2x" aria-hidden="true"></i>
                    <span style="font-weight: bold;">Home</span>
                </a>    
                <h2 id="title">Hóa đơn</h2>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-5">
                <form id="form" action="search" >
                    <b id="orderId">Mã số hóa đơn: </b> 
                    <input class="input" type="number" name="orderID" value="${param.orderID}">
                    <button type="button" class="btn btn-default" data-toggle="collapse" data-target="#advantageSearch">
                        <span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span> Nâng cao
                    </button>

                    <input type="submit" class="btn btn-success" value="Tìm kiếm">

                    <div id="advantageSearch" class="collapse">
                        <p>
                            <b id="cId">Mã số khách hàng: </b> 
                            <input class="input" type="number" name="customerID" value="${param.customerID}">
                        </p>
                        <p>
                            <b id="cName">Tên khách hàng:</b> 
                            <input class="input" type="text" name="customerName" value="${param.customerName}">
                        </p>
                        <p>
                            <b>Từ</b> 
                            <input class="input" type="date" name="dateFrom" min="${requestScope.dateFromset}" max="${requestScope.currentDate}" value="${param.dateFrom}">
                            <b>Đến</b> 
                            <input class="input" type="date" name="dateTo" max="${requestScope.currentDate}" value="${param.dateTo}"><br>
                        </p>
                        <p>
                            <b id="seller">Người bán:</b>
                            <input class="input" type="text" name="username" value="${param.username}">
                        </p>
                    </div>
                </form>
            </div>
        </div>

        <div class="row" style="margin-top: 30px;">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <table class="table table-bordered  text-center table-hover">
                    <tr style="background: linear-gradient(0deg, rgba(34,193,195,1) 0%, rgba(253,187,45,1) 100%); color: white; font-size: 15px;">
                        <th>Mã số hóa đơn</th>
                        <th>Mã số khách hàng</th>
                        <th>Tên khách hàng</th>
                        <th>Thời gian</th>
                        <th>Tổng tiền cẩn trả</th>
                        <th>Số tiền đã trả</th>
                        <th>Người bán</th>
                        <th></th>
                    </tr>
                    <c:forEach items="${requestScope.orders}" var="o">
                        <tr>
                            <td>${o.id}</td>
                            <td>${o.customer.person.id}</td>
                            <td>${o.customer.person.name}</td>
                            <td>${o.date}</td>
                            <td>${o.amount}</td>
                            <td>${o.paid}</td>
                            <td>${o.seller.displayname}</td>
                            <td><a href="detail?orderID=${o.id}">Chi tiết</a></td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="col-md-2"></div>
            </div>
        </div>

<!--        <div >
            <input type="text" onchange="location.href='search?page=' + ${requestScope.page}" 
                   id="paggerNomal" name="page" value="${requestScope.page}">/${requestScope.totaPage}
        </div>-->
    <div id="pagger"></div>
    <script>
            if (${requestScope.totalPage} > 2) {
                createPage('pagger', ${requestScope.page}, 2,${requestScope.totalPage});
            }
    </script>
</body>
</html>
