/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.export;

import controller.authentication.BaseAuthentication;
import dal.CustomerDBContext;
import dal.PersonDBContext;
import dal.ProductDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.Person;
import model.Product;

/**
 *
 * @author Admin
 */
public class ExportNewCustomer extends BaseAuthentication {

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
        ProductDBContext productDB = new ProductDBContext();
        ArrayList<Product> products = productDB.getProducts();
        request.setAttribute("products", products);
        request.getRequestDispatcher("../view/export/newCustomer.jsp").forward(request, response);
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
        if (id.isEmpty() || name.isEmpty() || raw_dob.isEmpty() || raw_gender.isEmpty()
                || phone.isEmpty() || address.isEmpty()) {
            request.setAttribute("msg", "Bạn cần điền đầy đủ thông tin!");
            request.getRequestDispatcher("../view/export/newCustomer.jsp").forward(request, response);
        }

        Date dob = Date.valueOf(request.getParameter("dob"));
        boolean gender = request.getParameter("gender").equals("male");
        

        PersonDBContext personDB = new PersonDBContext();
        for (Person person : personDB.getPerson()) {
            if ((person.getId() + "").equalsIgnoreCase(id)) {
                request.setAttribute("customerExisted", "Mã số khách hàng đã tồn tại!");
                request.getRequestDispatcher("../view/export/newCustomer.jsp").forward(request, response);
            }
        }

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

        personDB.insertPerson(person);
        customerDB.insertCustomer(customer.getPerson().getId());

        HttpSession session = request.getSession();
        session.setAttribute("customer", customer);

        response.sendRedirect("listProduct");
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
