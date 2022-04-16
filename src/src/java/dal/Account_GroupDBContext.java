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
import model.Account;
import model.Account_Group;
import model.Group;

/**
 *
 * @author Admin
 */
public class Account_GroupDBContext extends DBContext {

    public ArrayList<Account_Group> getAccount_Group(String username) {
        ArrayList<Account_Group> account_Groups = new ArrayList<>();
        String sql = "SELECT [username]\n"
                + "      ,[gid]\n"
                + "  FROM [Account_Group] where username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Account_Group account_Group = new Account_Group();
                Account a = new Account();
                a.setUsername(username);
                Group g = new Group();
                g.setId(rs.getInt(2));
                account_Group.setAccount(a);
                account_Group.setGroup(g);
                account_Groups.add(account_Group);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Account_GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account_Groups;
    }
    
    public static void main(String[] args) {
        Account_GroupDBContext db = new Account_GroupDBContext();
        for(Account_Group ag : db.getAccount_Group("admin")){
            System.out.println(ag);
        }
    }
}
