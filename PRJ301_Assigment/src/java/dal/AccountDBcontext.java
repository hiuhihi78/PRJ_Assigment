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
import model.Account;

/**
 *
 * @author Admin
 */
public class AccountDBcontext extends DBContext {

    public Account getAccount(String username, String password) {
        try {
            String sql = "SELECT [username]\n"
                    + "      ,[password]\n"
                    + "      ,[displayname]\n"
                    + "  FROM [Account]\n"
                    + "  WHERE username=? AND password=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next() == true) {
                Account account = new Account();
                account.setUsername(username);
                account.setPassword(password);
                account.setDisplayname(rs.getString(3));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getNumberOfRoles(String username, String url) {
        String query = "select count(url) as total\n"
                + "from Account join Account_Group on Account.username = Account_Group.username\n"
                + "			join [Group] on Account_Group.gid = [Group].id\n"
                + "			join Group_Feature on [Group].id = Group_Feature.gid\n"
                + "			join Feature on Group_Feature.fid = Feature.id\n"
                + "where Account.username = ? and url = ?";
        try {
            PreparedStatement ps =connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2,url);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
