/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.customer;

import controller.authentication.BaseAuthentication;
import dal.CustomerDBContext;
import dal.PersonDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.Person;

/**
 *
 * @author Admin
 */
public class UpdateCustomerServlet extends BaseAuthentication {

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
        String raw_id = request.getParameter("id");
        int id = Integer.parseInt(raw_id);
        if (raw_id == null || raw_id.isEmpty()) {
            response.getWriter().print("Khách hàng không tồn tại!");
            return;
        }
        CustomerDBContext db = new CustomerDBContext();
        Customer customer = db.getCustomer(id);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("../view/customer/update.jsp").forward(request, response);

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
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String raw_dob = request.getParameter("dob");
        String raw_gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        Date dob = Date.valueOf(request.getParameter("dob"));
        boolean gender = request.getParameter("gender").equals("male");

        CustomerDBContext customerDB = new CustomerDBContext();
        Customer customer = new Customer();
        Person person = new Person();
        person.setId(Integer.parseInt(id));
        person.setName(name);
        person.setDob(dob);
        person.setGender(gender);
        person.setPhone(phone);
        person.setAddress(address);
        customer.setPerson(person);

        if (id.isEmpty() || name.isEmpty() || raw_dob.isEmpty() || raw_gender.isEmpty()
                || phone.isEmpty() || address.isEmpty()) {
            request.setAttribute("customer", customer );
            request.setAttribute("msg", "Bạn cần điền đầy đủ thông tin!");
            request.getRequestDispatcher("../view/customer/update.jsp").forward(request, response);
        }

        PersonDBContext personDB = new PersonDBContext();
        personDB.updatePerson(person);
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
