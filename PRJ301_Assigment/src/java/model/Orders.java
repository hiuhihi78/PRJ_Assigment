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
public class Orders {
    private int id;
    private Customer customer;
    private Date date;
    private ArrayList<Order_Product> order_Products = new ArrayList<>();
    private float paid;
    private float amount;
    private Account seller;
    
    
    public void deleteAOrderProduct(Order_Product d){
        order_Products.remove(d);
    }

    public float getPaid() {
        return paid;
    }

    public void setPaid(float paid) {
        this.paid = paid;
    }

    public Account getSeller() {
        return seller;
    }

    public void setSeller(Account seller) {
        this.seller = seller;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Order_Product> getOrder_Products() {
        return order_Products;
    }

    public void setOrder_Products(ArrayList<Order_Product> order_Products) {
        this.order_Products = order_Products;
    }

    public float getAmount() {
        float amount = 0;
        for(Order_Product p : order_Products){
            amount = amount + p.getQuantity()*p.getDiscount()*p.getSellPrice();
        }
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    
    
}
