/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.Person;

/**
 *
 * @author Admin
 */
public class CustomerDBContext extends DBContext {

    public ArrayList<Customer> getCustomers() {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Customer> customers = new ArrayList<>();

        String sql = "select id, name, dob, gender, phone, address\n"
                + "from Person join Customer on Person.id = Customer.personID";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer c = new Customer();
                Person p = new Person();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setDob(rs.getDate(3));
                p.setGender(rs.getBoolean(4));
                p.setPhone(rs.getString(5));
                p.setAddress(rs.getString(6));
                c.setPerson(p);
                customers.add(c);
            }

            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(CustomerDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(CustomerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(CustomerDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return customers;
    }

    public void insertCustomer(int id) {
        String sql = "INSERT INTO [Customer]\n"
                + "           ([personID])\n"
                + "     VALUES\n"
                + "           (?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Customer getCustomer(int id) {
        String sql = "  select id, name, dob, gender, phone , address\n"
                + "  from  Customer join Person on Customer.personID = Person.id\n"
                + "  where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Customer c = new Customer();
                Person p = new Person();
                p.setId(id);
                p.setName(rs.getString(2));
                p.setDob(rs.getDate(3));
                p.setGender(rs.getBoolean(4));
                p.setPhone(rs.getString(5));
                p.setAddress(rs.getString(6));
                c.setPerson(p);
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        CustomerDBContext db = new CustomerDBContext();
        for (Customer c : db.getCustomers()) {
            System.out.println(c);
        }
    }

}
