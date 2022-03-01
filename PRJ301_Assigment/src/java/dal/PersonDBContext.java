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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.Person;

/**
 *
 * @author Admin
 */
public class PersonDBContext extends DBContext {

    public ArrayList<Person> getPerson() {
        ArrayList<Person> persons = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[dob]\n"
                + "      ,[gender]\n"
                + "      ,[phone]\n"
                + "      ,[address]\n"
                + "  FROM [Person]";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                Person c = new Person();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setDob(rs.getDate(3));
                c.setGender(rs.getBoolean(4));
                c.setPhone(rs.getString(5));
                c.setAddress(rs.getString(6));
                persons.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persons;
    }

    public void insertPerson(Person person) {
        String sql = "INSERT INTO [Person]\n"
                + "           ([id]\n"
                + "           ,[name]\n"
                + "           ,[dob]\n"
                + "           ,[gender]\n"
                + "           ,[phone]\n"
                + "           ,[address])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, person.getId());
            ps.setString(2, person.getName());
            ps.setDate(3, person.getDob());
            ps.setBoolean(4, person.isGender());
            ps.setString(5, person.getPhone());
            ps.setString(6, person.getAddress());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        PersonDBContext db = new PersonDBContext();
        Person person = new Person();
        person.setId(12);
        person.setName("hieu");
        person.setDob(Date.valueOf("2001-01-01"));
        person.setGender(true);
        person.setPhone("0333");
        person.setAddress("ada");
        db.insertPerson(person);
        
    }

}
