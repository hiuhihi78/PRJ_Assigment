/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.Order;
import model.Order_Product;
import model.Orders;

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

}
