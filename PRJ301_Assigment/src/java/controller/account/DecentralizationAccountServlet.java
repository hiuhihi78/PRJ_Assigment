/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.account;

import controller.authentication.BaseAuthentication;
import dal.AccountDBcontext;
import dal.Account_GroupDBContext;
import dal.GroupDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Account_Group;
import model.Group;

/**
 *
 * @author Admin
 */
public class DecentralizationAccountServlet extends BaseAuthentication {

    
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
        String username = request.getParameter("username");
        AccountDBcontext accountDB = new AccountDBcontext();
        Account account = accountDB.getAccountByUsername(username);
        request.setAttribute("account", account);
        
        GroupDBContext groupDB = new GroupDBContext();
        ArrayList<Group> groups = groupDB.getGroups();
        request.setAttribute("groups", groups);
        request.getRequestDispatcher("../view/account/decentralization.jsp").forward(request, response);
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
        String username = request.getParameter("username");
        String[] groupIDs = request.getParameterValues("gid");
        if(groupIDs == null){
            groupIDs = new String[0];
        }
        AccountDBcontext accountDB = new AccountDBcontext();
        accountDB.updateAccount_Group(username, groupIDs);
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
