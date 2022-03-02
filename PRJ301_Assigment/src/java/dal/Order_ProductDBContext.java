/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order_Product;

/**
 *
 * @author Admin
 */
public class Order_ProductDBContext extends DBContext {

    public void insertDetailOrder(ArrayList<Order_Product> details) {
        for (Order_Product d : details) {
            String sql = "INSERT INTO [Order_Product]\n"
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
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, 0);
            } catch (SQLException ex) {
                Logger.getLogger(Order_ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

}
