/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Customer;
import model.Order_Product;
import model.Orders;
import model.Person;
import model.Product;

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

            // get Order for each customer
            for (Customer c : customers) {
                ArrayList<Orders> orders = new ArrayList<>();
                String sql_getOrder = "	select Orders.orderID\n"
                        + "	from Customer join Orders on Customer.personID = Orders.customerID\n"
                        + "	where Customer.personID = ?";
                PreparedStatement ps_getOrder = connection.prepareStatement(sql_getOrder);
                ps_getOrder.setInt(1, c.getPerson().getId());
                ResultSet rs_getOrder = ps_getOrder.executeQuery();
                while (rs_getOrder.next()) {
                    Orders o = new Orders();
                    o.setId(rs_getOrder.getInt(1));
                    orders.add(o);
                }
                c.getOrders().addAll(orders);
            }

            for (Customer customer : customers) {
                String sql_get_OrederDetail = "select \n"
                        + "		Orders.orderID, Orders.date, Orders.amout, Orders.paid, Orders.seller, Account.displayname,\n"
                        + "		Product.id, Product.name, Order_Product.quantity, Order_Product.discount, Order_Product.sellprice\n"
                        + "from  Customer join Orders on Customer.personID = Orders.customerID\n"
                        + "	join Order_Product on Orders.orderID = Order_Product.orderID\n"
                        + "	join Product on Order_Product.productID = Product.id\n"
                        + "	join Account on Orders.seller = Account.username\n"
                        + "	where Customer.personID = ?";
                PreparedStatement ps_get_OrederDetail = connection.prepareStatement(sql_get_OrederDetail);
                ps_get_OrederDetail.setInt(1, customer.getPerson().getId());
                ResultSet rs_get_Orders = ps_get_OrederDetail.executeQuery();
                while (rs_get_Orders.next()) {
                    for (Orders order : customer.getOrders()) {
                        if (order.getId() == (rs_get_Orders.getInt(1))) {
                            order.setDate(rs_get_Orders.getTimestamp(2));
                            order.setAmount(rs_get_Orders.getFloat(3));
                            order.setPaid(rs_get_Orders.getFloat(4));
                            Account seller = new Account();
                            seller.setUsername(rs_get_Orders.getString(5));
                            seller.setDisplayname(rs_get_Orders.getString(6));
                            order.setSeller(seller);

                            Order_Product orderDetail = new Order_Product();
                            Product product = new Product();
                            product.setId(rs_get_Orders.getInt(7));
                            product.setName(rs_get_Orders.getString(8));
                            orderDetail.setProduct(product);
                            orderDetail.setQuantity(rs_get_Orders.getFloat(9));
                            orderDetail.setDiscount(rs_get_Orders.getFloat(10));
                            orderDetail.setSellPrice(rs_get_Orders.getFloat(11));
                            order.getOrder_Products().add(orderDetail);
                        }
                    }

                }

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

        try {
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        Customer customer = new Customer();
        String sql = "  select id, name, dob, gender, phone , address\n"
                + "  from  Customer join Person on Customer.personID = Person.id\n"
                + "  where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                Person p = new Person();
                p.setId(id);
                p.setName(rs.getString(2));
                p.setDob(rs.getDate(3));
                p.setGender(rs.getBoolean(4));
                p.setPhone(rs.getString(5));
                p.setAddress(rs.getString(6));
                customer.setPerson(p);
            }

            String sql_getOrder = "	select Orders.orderID\n"
                    + "	from Customer join Orders on Customer.personID = Orders.customerID\n"
                    + "	where Customer.personID = ?";
            PreparedStatement ps_getOrder = connection.prepareStatement(sql_getOrder);
            ps_getOrder.setInt(1, customer.getPerson().getId());
            ResultSet rs_getOrder = ps_getOrder.executeQuery();
            while (rs_getOrder.next()) {
                Orders o = new Orders();
                o.setId(rs_getOrder.getInt(1));
                customer.getOrders().add(o);
            }

            String sql_get_OrederDetail = "select \n"
                    + "		Orders.orderID, Orders.date, Orders.amout, Orders.paid, Orders.seller, Account.displayname,\n"
                    + "		Product.id, Product.name, Order_Product.quantity, Order_Product.discount, Order_Product.sellprice\n"
                    + "from  Customer join Orders on Customer.personID = Orders.customerID\n"
                    + "	join Order_Product on Orders.orderID = Order_Product.orderID\n"
                    + "	join Product on Order_Product.productID = Product.id\n"
                    + "	join Account on Orders.seller = Account.username\n"
                    + "	where Customer.personID = ?";
            PreparedStatement ps_get_OrederDetail = connection.prepareStatement(sql_get_OrederDetail);
            ps_get_OrederDetail.setInt(1, customer.getPerson().getId());
            ResultSet rs_get_Orders = ps_get_OrederDetail.executeQuery();
            while (rs_get_Orders.next()) {
                for (Orders order : customer.getOrders()) {
                    if (order.getId() == (rs_get_Orders.getInt(1))) {
                        order.setDate(rs_get_Orders.getTimestamp(2));
                        order.setAmount(rs_get_Orders.getFloat(3));
                        order.setPaid(rs_get_Orders.getFloat(4));
                        Account seller = new Account();
                        seller.setUsername(rs_get_Orders.getString(5));
                        seller.setDisplayname(rs_get_Orders.getString(6));
                        order.setSeller(seller);

                        Order_Product orderDetail = new Order_Product();
                        Product product = new Product();
                        product.setId(rs_get_Orders.getInt(7));
                        product.setName(rs_get_Orders.getString(8));
                        orderDetail.setProduct(product);
                        orderDetail.setQuantity(rs_get_Orders.getFloat(9));
                        orderDetail.setDiscount(rs_get_Orders.getFloat(10));
                        orderDetail.setSellPrice(rs_get_Orders.getFloat(11));
                        order.getOrder_Products().add(orderDetail);
                    }
                }

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
        return customer;
    }

    public static void main(String[] args) {
        CustomerDBContext db = new CustomerDBContext();
//        for (Customer c : db.getCustomers()) {
//            for (Orders op : c.getOrders()) {
//                System.out.println(op);
//            }
//        }
        System.out.println(db.getCustomer(0));
    }

    public Customer getCustomerById(int id) {
        Customer customer = new Customer();
        try {
            String sql = "  select id, name, dob, gender, phone , address\n"
                    + "  from  Customer join Person on Customer.personID = Person.id\n"
                    + "  where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                Person p = new Person();
                p.setId(id);
                p.setName(rs.getString(2));
                p.setDob(rs.getDate(3));
                p.setGender(rs.getBoolean(4));
                p.setPhone(rs.getString(5));
                p.setAddress(rs.getString(6));
                customer.setPerson(p);
                        return customer;

            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
