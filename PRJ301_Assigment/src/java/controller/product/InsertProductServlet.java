/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.product;

import controller.authentication.BaseAuthentication;
import dal.ProductDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author Admin
 */
public class InsertProductServlet extends BaseAuthentication {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("../view/product/insert.jsp").forward(request, response);
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
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDBContext productDB = new ProductDBContext();
        String raw_name = request.getParameter("name");
        String raw_price = request.getParameter("price");
        String raw_Quantity = request.getParameter("quantity");
        String raw_image = request.getParameter("image");
        
        //check product was existed
        if(productDB.getProductByName(raw_name)!= null){
            request.setAttribute("alter", "Product was existed!");
            request.getRequestDispatcher("../view/product/insert.jsp").forward(request, response);
            return;
        }
        Product product = new Product();
        product.setName(raw_name);
        product.setPrice(Float.parseFloat(raw_price));
        product.setQuantity(Float.parseFloat(raw_Quantity));
        product.setImage(raw_image);

        productDB.insertProduct(product);
        response.sendRedirect("search");
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
