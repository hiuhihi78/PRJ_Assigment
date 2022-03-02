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
        Customer customer = (Customer) session.getAttribute("customer");
        Account seller = (Account) session.getAttribute("account");

        String[] raw_productId = request.getParameterValues("productid");
        String[] raw_quantity = request.getParameterValues("quantity");
        String[] raw_discount = request.getParameterValues("discount");
        String[] raw_sellPrice = request.getParameterValues("sellprice");
        String raw_paid = request.getParameter("paid");
        // create list order_product
        ArrayList<Order_Product> details = new ArrayList<>();
        for (String s : raw_productId) {
            Order_Product order_product = new Order_Product();
            details.add(order_product);
        }

        //set value for order_product
        int count = 0;
        ProductDBContext productDB = new ProductDBContext();
        for (Order_Product d : details) {
            d.setProduct(productDB.getProductById(Integer.parseInt(raw_productId[count])));
            d.setQuantity(Float.parseFloat(raw_quantity[count]));
            d.setDiscount(Float.parseFloat(raw_discount[count]));
            d.setSellPrice(Float.parseFloat(raw_sellPrice[count]));
            d.setOrders(order);
            count++;
        }
        
        //set value for order
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String currentDate = formatter.format(date);
        
        order.setCustomer(customer);
        order.setOrder_Products(details);
        order.setPaid(Integer.parseInt(raw_paid));
        order.setOrder_Products(details);
        order.setDate(java.sql.Date.valueOf(currentDate));
        order.setSeller(seller);
        
        // add record into Orders table and add records into Order_Product (1 transaction)
        OrdersDBContext orderDB = new OrdersDBContext();
        orderDB.insertOrder(order);
        
        request.getSession().removeAttribute("cart");

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
