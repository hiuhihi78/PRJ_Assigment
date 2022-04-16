/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Account {
    private String username;
    private String password;
    private String displayname;
    private ArrayList<Account_Group> groups = new ArrayList<>();

    public ArrayList<Account_Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Account_Group> groups) {
        this.groups = groups;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + 
                ", displayname=" + displayname + '}';
    }

    
    
}
