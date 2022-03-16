/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.export;

import dal.OrdersDBContext;
import dal.ProductDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Customer;
import model.Order_Product;
import model.Orders;
import model.Product;

/**
 *
 * @author Admin
 */
public class CheckOutOrder extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Orders order = (Orders) session.getAttribute("cart");
        if (order == null || order.getOrder_Products().size() == 0) {
            ProductDBContext productDB = new ProductDBContext();
            request.setAttribute("productDB", productDB);
            request.setAttribute("cart", order);
            request.setAttribute("alter", "Bạn chưa chọn mặt hàng nào!");
            request.getRequestDispatcher("../export/listProduct").forward(request, response);
        }

        ProductDBContext productDB = new ProductDBContext();
        request.setAttribute("productDB", productDB);
        request.setAttribute("cart", order);
        request.getRequestDispatcher("../view/export/checkout.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Orders order = (Orders) session.getAttribute("cart");
        ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("products");

        //database
        // add record into Orders table and add records into Order_Product (1 transaction)
        OrdersDBContext orderDB = new OrdersDBContext();
        orderDB.insertOrder(order,products);

//        ProductDBContext productDB = new ProductDBContext();
//        productDB.updateQuantity(products);

        request.getSession().removeAttribute("cart");
        request.getSession().removeAttribute("products");
        request.getRequestDispatcher("../NewServlet").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
