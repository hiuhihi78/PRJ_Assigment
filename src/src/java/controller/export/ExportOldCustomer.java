/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.export;

import controller.authentication.BaseAuthentication;
import dal.CustomerDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;

/**
 *
 * @author Admin
 */
public class ExportOldCustomer extends BaseAuthentication {

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
        request.getRequestDispatcher("../view/export/oldCustomer.jsp").forward(request, response);
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
        if (request.getParameter("id").isEmpty()) {
            request.setAttribute("msgId", "Mã CMTND không được trống!");
            request.getRequestDispatcher("../view/export/oldCustomer.jsp").forward(request, response);
        }
        int id = Integer.parseInt(request.getParameter("id"));
        CustomerDBContext customerDB = new CustomerDBContext();
        Customer customer = customerDB.getCustomerById(id);
        if (customer == null) {
            request.setAttribute("alert", "Mã khách hàng không tồn tại!");
            request.getRequestDispatcher("../view/export/oldCustomer.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);
            response.sendRedirect("listProduct");
        }
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
