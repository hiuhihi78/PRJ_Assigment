/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.Order;
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
public class OrdersDBContext extends DBContext {

    public void insertOrder(Orders order) {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // insert record into order
            String sql_add_order = "INSERT INTO [Orders]\n"
                    + "           ([customerID]\n"
                    + "           ,[date]\n"
                    + "           ,[amout]\n"
                    + "           ,[paid]\n"
                    + "           ,[seller])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";

            PreparedStatement ps_add_order = connection.prepareStatement(sql_add_order);
            ps_add_order.setInt(1, order.getCustomer().getPerson().getId());
            ps_add_order.setTimestamp(2, order.getDate());
            ps_add_order.setFloat(3, order.getAmount());
            ps_add_order.setFloat(4, order.getPaid());
            ps_add_order.setString(5, order.getSeller().getUsername());
            ps_add_order.executeUpdate();

            // get order id
            int orderId = 0;
            String sql_getOrderId = "Select @@IDENTITY as OrderID";
            PreparedStatement ps_getOrderId = connection.prepareStatement(sql_getOrderId);
            ResultSet rs_getOrderId = ps_getOrderId.executeQuery();
            if (rs_getOrderId.next()) {
                orderId = rs_getOrderId.getInt(1);
            }
            // insert list order_product(order detail)
            for (Order_Product d : order.getOrder_Products()) {
                String sql_add_detail = "INSERT INTO [Order_Product]\n"
                        + "           ([orderID]\n"
                        + "           ,[productID]\n"
                        + "           ,[quantity]\n"
                        + "           ,[sellprice]\n"
                        + "           ,[discount])\n"
                        + "     VALUES\n"
                        + "           (?\n"
                        + "           ,?\n"
                        + "           ,?\n"
                        + "           ,?\n"
                        + "           ,?)";
                PreparedStatement ps_add_detail = connection.prepareStatement(sql_add_detail);
                ps_add_detail.setInt(1, orderId);
                ps_add_detail.setInt(2, d.getProduct().getId());
                ps_add_detail.setFloat(3, d.getQuantity());
                ps_add_detail.setFloat(4, d.getSellPrice());
                ps_add_detail.setFloat(5, d.getDiscount());
                ps_add_detail.executeUpdate();
            }

            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(OrdersDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(OrdersDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(OrdersDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<Orders> getOrders(int pagesize, int pageindex) {
        ArrayList<Orders> orders = new ArrayList<>();
        String sql = "select  orderID, customerID,t.name as customerName ,date, amout, paid, t.username,t.displayname \n"
                + "from (\n"
                + "	select ROW_NUMBER() over (order by orderID asc) as number, *\n"
                + "	from Orders join Customer on Orders.customerID = Customer.personID\n"
                + "		join Person on Person.id = Customer.personID\n"
                + "		join Account on Account.username = Orders.seller\n"
                + "	)t\n"
                + "where number >= ((? - 1) * ?) + 1 and number <= ? * ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, pageindex);
            ps.setInt(2, pagesize);
            ps.setInt(3, pageindex);
            ps.setInt(4, pagesize);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orders o = new Orders();
                o.setId(rs.getInt(1));
                Customer c = new Customer();
                Person p = new Person();
                p.setId(rs.getInt(2));
                p.setName(rs.getString(3));
                c.setPerson(p);
                o.setCustomer(c);
                o.setDate(Timestamp.valueOf(rs.getString(4)));
                o.setAmount(rs.getFloat(5));
                o.setPaid(rs.getFloat(6));
                Account a = new Account();
                a.setUsername(rs.getString(7));
                a.setDisplayname(rs.getString(8));
                o.setSeller(a);
                orders.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }

    public int getTotalRecord() {
        String sql = "select count(*) as total from Orders";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList<Orders> getOrders(int pagesize, int pageindex, int orderID,
            int customerID, String customerName, Date dateFrom, Date dateTo, String username) {
        ArrayList<Orders> orders = new ArrayList<>();
        String sql = "select  orderID, customerID,t.name ,date, amout, paid, t.username,t.displayname \n"
                + "from (\n"
                + "     select ROW_NUMBER() over (order by orderID asc) as number,*\n"
                + "     from Orders join Customer on Orders.customerID = Customer.personID\n"
                + "     join Person on Person.id = Customer.personID\n"
                + "     join Account on Account.username = Orders.seller\n"
                + "     )t\n"
                + "where (1=1)\n";
        try {
            int paramIndex = 0;
            HashMap<Integer, Object[]> params = new HashMap<>();

            if (orderID != -1) {
                sql += "and t.orderID = ?\n";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Integer.class.getName();
                param[1] = orderID;
                params.put(paramIndex, param);
            }

            if (customerID != -1) {
                sql += "and t.customerID = ?\n";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Integer.class.getName();
                param[1] = customerID;
                params.put(paramIndex, param);
            }

            if (customerName != null) {
                sql += "and t.name like ?\n";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = String.class.getName();
                param[1] = customerName;
                params.put(paramIndex, param);

            }
            if (dateFrom != null) {
                sql += "and t.date >= ? \n";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Date.class.getName();
                param[1] = dateFrom;
                params.put(paramIndex, param);
            }

            if (dateTo != null) {
                sql += "and t.date <= ?\n";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Date.class.getName();
                param[1] = dateTo;
                params.put(paramIndex, param);
            }

            if (username != null) {
                sql += "and t.username like ?\n";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = String.class.getName();
                param[1] = username;
                params.put(paramIndex, param);
            }

            if (pageindex != -1 || pagesize != -1) {
                sql += "and t.number >= ((? - 1) * ?) + 1 and t.number <= ? * ?\n";
            }

            PreparedStatement ps = connection.prepareStatement(sql);
            for (Map.Entry<Integer, Object[]> entry : params.entrySet()) {
                Integer index = entry.getKey();
                Object[] value = entry.getValue();
                String type = value[0].toString();
                if (type.equals(Integer.class.getName())) {
                    ps.setInt(index, (Integer) value[1]);
                } else if (type.equals(String.class.getName())) {
                    ps.setString(index, "%" + value[1].toString() + "%");
                } else if (type.equals(Date.class.getName())) {
                    ps.setDate(index, (Date) value[1]);
                }
            }

            if (pageindex != -1 || pagesize != -1) {
                ps.setInt(paramIndex + 1, pageindex);
                ps.setInt(paramIndex + 2, pagesize);
                ps.setInt(paramIndex + 3, pageindex);
                ps.setInt(paramIndex + 4, pagesize);
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orders o = new Orders();
                o.setId(rs.getInt(1));
                Customer c = new Customer();
                Person p = new Person();
                p.setId(rs.getInt(2));
                p.setName(rs.getString(3));
                c.setPerson(p);
                o.setCustomer(c);
                o.setDate(Timestamp.valueOf(rs.getString(4)));
                o.setAmount(rs.getFloat(5));
                o.setPaid(rs.getFloat(6));
                Account a = new Account();
                a.setUsername(rs.getString(7));
                a.setDisplayname(rs.getString(8));
                o.setSeller(a);
                orders.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }

   

    public int getTotalRecordForAQuerySearch(int orderID, int customerID, String customerName, Date dateFrom, Date dateTo, String username) {
        ArrayList<Orders> orders = new ArrayList<>();
        String sql = "select  orderID, customerID,t.name ,date, amout, paid, t.username,t.displayname \n"
                + "from (\n"
                + "     select ROW_NUMBER() over (order by orderID asc) as number,*\n"
                + "     from Orders join Customer on Orders.customerID = Customer.personID\n"
                + "     join Person on Person.id = Customer.personID\n"
                + "     join Account on Account.username = Orders.seller\n"
                + "     )t\n";

        try {
            int paramIndex = 4;
            HashMap<Integer, Object[]> params = new HashMap<>();

            if (orderID != -1) {
                sql += "and t.orderID = ?\n";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Integer.class.getName();
                param[1] = orderID;
                params.put(paramIndex, param);
            }

            if (customerID != -1) {
                sql += "and t.customerID = ?\n";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Integer.class.getName();
                param[1] = customerID;
                params.put(paramIndex, param);
            }

            if (customerName != null) {
                sql += "and t.name like ?\n";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = String.class.getName();
                param[1] = customerName;
                params.put(paramIndex, param);

            }
            if (dateFrom != null) {
                sql += "and t.date >= ? \n";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Date.class.getName();
                param[1] = dateFrom;
                params.put(paramIndex, param);
            }

            if (dateTo != null) {
                sql += "and t.date <= ?\n";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Date.class.getName();
                param[1] = dateTo;
                params.put(paramIndex, param);
            }

            if (username != null) {
                sql += "and t.username like ?\n";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = String.class.getName();
                param[1] = username;
                params.put(paramIndex, param);
            }

            PreparedStatement ps = connection.prepareStatement(sql);
            for (Map.Entry<Integer, Object[]> entry : params.entrySet()) {
                Integer index = entry.getKey();
                Object[] value = entry.getValue();
                String type = value[0].toString();
                if (type.equals(Integer.class.getName())) {
                    ps.setInt(index, (Integer) value[1]);
                } else if (type.equals(String.class.getName())) {
                    ps.setString(index, "%" + value[1].toString() + "%");
                } else if (type.equals(Date.class.getName())) {
                    ps.setDate(index, (Date) value[1]);
                }
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orders o = new Orders();
                o.setId(rs.getInt(1));
                Customer c = new Customer();
                Person p = new Person();
                p.setId(rs.getInt(2));
                p.setName(rs.getString(3));
                c.setPerson(p);
                o.setCustomer(c);
                o.setDate(Timestamp.valueOf(rs.getString(4)));
                o.setAmount(rs.getFloat(5));
                o.setPaid(rs.getFloat(6));
                Account a = new Account();
                a.setUsername(rs.getString(7));
                a.setDisplayname(rs.getString(8));
                o.setSeller(a);
                orders.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders.size();
    }

    public Orders getOrderDetail(int orderId) {
        String sql = "select Orders.orderID, Person.id, Person.name, Orders.date, Orders.seller, Orders.paid, Orders.amout,\n"
                + "Product.name, Order_Product.quantity, Order_Product.discount,Order_Product.sellprice\n"
                + "from Orders join Customer on Customer.personID = Orders.customerID\n"
                + "			join Person on Person.id = Customer.personID\n"
                + "			join Order_Product on Orders.orderID = Order_Product.orderID\n"
                + "			 left join Product on Order_Product.productID = Product.id\n"
                + "where Orders.orderID = ?";
        PreparedStatement ps;
        Orders order = new Orders();
        ArrayList<Order_Product> orderDetail = new ArrayList<>();

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                order.setId(orderId);
                Customer customer = new Customer();
                Person person = new Person();
                person.setId(rs.getInt(2));
                person.setName(rs.getString(3));
                customer.setPerson(person);
                order.setCustomer(customer);
                order.setDate(rs.getTimestamp(4));
                Account seller = new Account();
                seller.setDisplayname(rs.getString(5));
                order.setSeller(seller);
                order.setPaid(rs.getFloat(6));
                order.setAmount(rs.getFloat(7));
                
                Order_Product detail = new Order_Product();
                Product product = new Product();
                product.setName(rs.getString(8));
                detail.setProduct(product);
                detail.setQuantity(rs.getFloat(9));
                detail.setDiscount(rs.getFloat(10));
                detail.setSellPrice(rs.getFloat(11));
                orderDetail.add(detail);
                order.setOrder_Products(orderDetail);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return order;
    }
    
    public static void main(String[] args) {
        OrdersDBContext db = new OrdersDBContext();
//        for (Orders o : db.getOrders(1, 1, -1, -1, null, null, null, null)) {
//            System.out.println(o);
//        }
//        db.getOrders(4, 1, -1, -1, "Hieu", null, null, "");
//        System.out.println(db.getOrders(4, 1, -1, -1, "Hieu", null, null, ""));   
//        System.out.println(db.getTotalRecordForAQuerySearch(-1, -1, null, null, null, null));
//        System.out.println(21/10);
        System.out.println(db.getOrderDetail(30).getOrder_Products().size());
    }
}
