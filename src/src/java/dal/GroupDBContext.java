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
import model.Group;

/**
 *
 * @author Admin
 */
public class GroupDBContext extends DBContext {

    public ArrayList<Group> getGroups() {
        ArrayList<Group> groups = new ArrayList<>();
        String qurey = "SELECT [id]\n"
                + "      ,[name]\n"
                + "  FROM [Group]";
        try {
            PreparedStatement ps = connection.prepareStatement(qurey);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Group g = new Group();
                g.setId(rs.getInt(1));
                g.setName(rs.getString(2));
                groups.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return groups;
    }
    
    public static void main(String[] args) {
        GroupDBContext db = new GroupDBContext();
        ArrayList<Group> groups = db.getGroups();
        for(Group g : groups){
            System.out.println(g);
        }
    }

}
