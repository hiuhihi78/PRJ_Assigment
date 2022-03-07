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
    </head>
    <body>
        <form action="newCustomer" method="POST">
            Nhập thông tin khách hàng <br>
            Mã số CMTND: 
            <input type="text" name="id" value="${param.id}"><br>
            Họ và tên:
            <input type="text" name="name" value="${param.name}"><br>
            Ngày sinh: 
            <input type="date" name="dob" value="${param.dob}"><br>
            Giới tinh: 
            <input type="radio" name="gender" checked="checked" value="male"> Nam  
            <input type="radio" name="gender" value="female"> Nữ  <br>
            Số điện thoại:
            <input type="text" name="phone" value="${param.phone}"><br>
            Địa chỉ:
            <input type="text" name="address" value="${param.address}"><br>
            <c:if test="${requestScope.customerExisted != null}">
                <i style="color: red">${requestScope.customerExisted}</i><br>
            </c:if>
            <c:if test="${requestScope.msg != null}">
                <i style="color: red">${requestScope.msg}</i><br>
            </c:if>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
