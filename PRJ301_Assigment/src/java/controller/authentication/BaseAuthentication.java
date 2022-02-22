/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.authentication;

import dal.AccountDBcontext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author Admin
 */
public abstract class BaseAuthentication extends HttpServlet {

    private boolean isAuthenticated(HttpServletRequest request) {
        Account account = (Account) request.getSession().getAttribute("account");
        if(account == null){
            return false;
        }else{
            String url = request.getServletPath();
            AccountDBcontext db = new AccountDBcontext();
            int total = db.getNumberOfRoles(account.getUsername(), url);
            return total > 0;
        }

    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isAuthenticated(request) == true) {
            processGet(request, response);
        } else {
            String url = request.getRequestURI().substring(request.getContextPath().length());
            String accessDenied = "accessDenied";
            if(url == null){
                response.sendRedirect("login");
            }
            String[] split_url = url.split("/");
            for(int i = 2; i < split_url.length ; i++){
                accessDenied = "../" + accessDenied;
            }
            response.sendRedirect(accessDenied);
        }
    }

    protected abstract void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    protected abstract void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isAuthenticated(request) == true) {
            processPost(request, response);
        } else {
             String url = request.getRequestURI().substring(request.getContextPath().length());
            String accessDenied = "accessDenied";
            if(url == null){
                response.sendRedirect("login");
            }
            String[] split_url = url.split("/");
            for(int i = 2; i < split_url.length ; i++){
                accessDenied = "../" + accessDenied;
            }
            response.sendRedirect(accessDenied);
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
