/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.export;

import dal.ProductDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.Order_Product;
import model.Orders;
import model.Person;
import model.Product;

/**
 *
 * @author Admin
 */
public class AddProductToCartServlet extends HttpServlet {

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
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDBContext productDB = new ProductDBContext();
        Product product = productDB.getProductById(id);
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        
        HttpSession session = request.getSession();
        Orders order = (Orders) request.getSession().getAttribute("cart");
        if (order == null) {
            order = new Orders();
            order.setCustomer(customer);
        }else{ // check current customer match with customer in order
            if(customer.getPerson().getId() != order.getCustomer().getPerson().getId()){
                order.setOrder_Products(new ArrayList<>());
            }
        }

        boolean isExisted = false;
        for (Order_Product op : order.getOrder_Products()) {
            if (op.getProduct().getId() == id) {
                isExisted = true;
                op.setQuantity(op.getQuantity() + 1);
                break;
            }
        }

        if (isExisted == false) {
            Order_Product detail = new Order_Product();
            detail.setOrders(order);
            detail.setProduct(product);
            detail.setDiscount(0);
            detail.setSellPrice(product.getPrice());
            detail.setQuantity(1);
            
            order.getOrder_Products().add(detail);
        }
        request.getSession().setAttribute("cart", order);
        response.sendRedirect("../export/listProduct");
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
