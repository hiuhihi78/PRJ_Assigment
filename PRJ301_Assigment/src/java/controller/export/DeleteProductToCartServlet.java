/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.export;

import dal.ProductDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Order_Product;
import model.Orders;
import model.Product;

/**
 *
 * @author Admin
 */
public class DeleteProductToCartServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Orders order = (Orders) session.getAttribute("cart");
        
        int productId = Integer.parseInt(request.getParameter("productid"));
       
        Order_Product remove = new Order_Product();
        int count = -1;
        for(Order_Product detail : order.getOrder_Products()){
            count++;
            if(detail.getProduct().getId() == productId){
                remove.setDiscount(detail.getDiscount());
                remove.setOrders(detail.getOrders());
                remove.setProduct(detail.getProduct());
                remove.setQuantity(detail.getQuantity());
                remove.setSellPrice(detail.getSellPrice());
                break;
            }
        }
        order.getOrder_Products().remove(count);
        
        session.setAttribute("cart", order);
//        request.getRequestDispatcher("checkout").forward(request, response);
        response.sendRedirect("checkout");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
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
