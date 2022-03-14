/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.export;

import dal.ProductDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
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
public class ViewInvoiceServlert extends HttpServlet {

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

        // check input empty
        for (int i = 0; i < raw_productId.length; i++) {
            if (raw_productId[i].isEmpty() || raw_quantity[i].isEmpty()
                    || raw_discount[i].isEmpty() || raw_sellPrice[i].isEmpty()) {

                request.getRequestDispatcher("../cart/checkout").forward(request, response);
            }
        }
        //clear details order was created in cart/add
        order.getOrder_Products().clear();

        //configure detail order 
        ProductDBContext productDB = new ProductDBContext();
        for (int i = 0; i < raw_productId.length; i++) {
            Order_Product detail = new Order_Product();
            detail.setProduct(productDB.getProductById(Integer.parseInt(raw_productId[i])));
            detail.setQuantity(Float.parseFloat(raw_quantity[i]));
            detail.setSellPrice(Float.parseFloat(raw_sellPrice[i]));
            detail.setDiscount(Float.parseFloat(raw_discount[i]));
            order.getOrder_Products().add(detail);
        }

        //configure order
        Date date = new Date();
        Timestamp current = new Timestamp(date.getTime());
        order.setCustomer(customer);
        order.setPaid(Float.parseFloat(raw_paid));
        order.setDate(current);
        order.setSeller(seller);
        float amount = 0;
        for (Order_Product p : order.getOrder_Products()) {
//            response.getWriter().print(" discount " + p.getDiscount());
//            response.getWriter().print(" sellprice " + p.getSellPrice());
//            response.getWriter().println(" quantity " + p.getQuantity());
            amount = amount + (p.getQuantity() * p.getSellPrice() - p.getQuantity()
                    * p.getSellPrice() * p.getDiscount() / 100);
        }
        order.setAmount(amount);
//        response.getWriter().print(" amount  " + order.getAmount());

        // change quatity product in product table
        ArrayList<Product> products = new ArrayList<>();
        for (int i = 0; i < raw_productId.length; i++) {
            Product product = new Product();
            product.setId(Integer.parseInt(raw_productId[i]));
            product.setQuantity(Float.parseFloat(raw_quantity[i]));
            products.add(product);
        }

        session.setAttribute("cart", order);
        session.setAttribute("products", products);
        request.getRequestDispatcher("../view/export/viewInvoice.jsp").forward(request, response);
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
