/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Customer {
    
    private Person person;
   
    private ArrayList<Orders> orders = new ArrayList<>();
    
    public float getTotalAmount(){
        float result = 0;
        for(Orders order : this.getOrders()){
            result = result + order.getAmount();
        }
        return result;
    }
    
    public float getTotalPaid(){
        float result = 0;
        for(Orders order : this.getOrders()){
            result = result + order.getPaid();
        }
        return result;
    }

    public ArrayList<Orders> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Orders> orders) {
        this.orders = orders;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Customer{" + "person=" + person.getId() + '}';
    }
    
   
    
}
