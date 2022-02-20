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
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, url);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public Account getAccountByUsername(String username) {

        try {
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            String sql = "SELECT [username]\n"
                    + "      ,[password]\n"
                    + "      ,[displayname]\n"
                    + "  FROM [Account]\n"
                    + "  WHERE username=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            Account account = new Account();
            if (rs.next() == true) {
                account.setUsername(username);
                account.setPassword(rs.getString(2));
                account.setDisplayname(rs.getString(3));
            }
            
            ArrayList<Account_Group> account_Groups = new ArrayList<>();
            String sql_getAccGroup = "SELECT [username]\n"
                    + "      ,[gid]\n"
                    + "  FROM [Account_Group]\n"
                    + "  WHERE username = ?";
            PreparedStatement ps_getAccGroup = connection.prepareStatement(sql_getAccGroup);
            ps_getAccGroup.setString(1, username);
            ResultSet rs_getAccGroup = ps.executeQuery();
            while(rs_getAccGroup.next()){
                Account_Group ag = new Account_Group();
                Account a = new Account();
                a.setUsername(rs_getAccGroup.getString(1));
                Group g = new Group();
                g.setId(rs_getAccGroup.getInt(2));
                ag.setAccount(a);
                ag.setGroup(g);
                account_Groups.add(ag);
            }
            account.setGroups(account_Groups);
            
            return account;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBcontext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(AccountDBcontext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(AccountDBcontext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public void insertAccount(Account account) {
        String query = "INSERT INTO [Account]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[displayname])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getDisplayname());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Account> getAccountByPartUsername(String username) {
        ArrayList<Account> accounts = new ArrayList<>();
        try {
            String sql = "SELECT [username]\n"
                    + "      ,[password]\n"
                    + "      ,[displayname]\n"
                    + "  FROM [Account]\n"
                    + "  WHERE username like ?";
            username = "%" + username + "%";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next() == true) {
                Account account = new Account();
                account.setUsername(rs.getString(1));
                account.setPassword(rs.getString(2));
                account.setDisplayname(rs.getString(3));
                accounts.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accounts;
    }

    public void deleteAccount(String username) {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            String query_deleteAccount_Group = "DELETE FROM [Account_Group]\n"
                    + "      WHERE username = ?";
            PreparedStatement ps_deleteAccount_Group = connection.prepareStatement(query_deleteAccount_Group);
            ps_deleteAccount_Group.setString(1, username);
            ps_deleteAccount_Group.executeUpdate();

            String query_deleteAccount = "DELETE FROM [Account]\n"
                    + "      WHERE username = ?";
            PreparedStatement ps_deleteAccount = connection.prepareStatement(query_deleteAccount);
            ps_deleteAccount.setString(1, username);
            ps_deleteAccount.executeUpdate();

            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBcontext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(AccountDBcontext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(AccountDBcontext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void main(String[] args) {
        AccountDBcontext db = new AccountDBcontext();
        ArrayList<Account> accounts = db.getAccountByPartUsername("admin");
        for (Account a : accounts) {
            System.out.println(a);
        }
    }

}
