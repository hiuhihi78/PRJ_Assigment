<%-- 
    Document   : choseCustomer
    Created on : Mar 1, 2022, 5:43:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
      
    </head>
    <body>
        <form action="export" method="POST">
            <input type="hidden" name="customerType" value="new"/>
            <input type="submit" value="Khách hàng mới">
        </form>
        <form action="export" method="POST">
            <input type="hidden" name="customerType" value="old"/>
            <input type="submit" value="Khách cũ">
        </form>
    </body>
</html>
