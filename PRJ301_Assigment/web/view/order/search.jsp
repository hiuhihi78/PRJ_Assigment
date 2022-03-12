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
    </head>
    <body>
        <form action="search">
            orderID: <input type="number" name="orderID" value="${param.orderID}"><br>
            custoemrtID: <input type="number" name="customerID" value="${param.customerID}"><br>
            customerName: <input  type="text" name="customerName" value="${param.customerName}"><br>
            dateFrom: <input type="date" name="dateFrom" min="${requestScope.dateFromset}"
                             max="${requestScope.currentDate}" value="${param.dateFrom}">
            dateTo: <input type="date" name="dateTo" max="${requestScope.currentDate}" value="${param.dateTo}"><br>
            username: <input type="text" name="username" value="${param.username}"><br>
            <input type="submit" value="searhc">
        </form>

        <table>
            <tr>
                <th>orderID</th>
                <th>CustomerID</th>
                <th>CustomerName</th>
                <th>Time</th>
                <th>Amount</th>
                <th>Paid</th>
                <th>seller</th>
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
                    <td>Detail</td>
                </tr>
            </c:forEach>
        </table>
        <div id="pagger">
            
        </div>
        <script>
            createPage('pagger', ${requestScope.page}, 2,2);
        </script>
    </body>
</html>
