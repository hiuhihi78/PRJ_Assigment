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
public class Product {
    private int id;
    private String name;
    private float price;
    private float quantity;
    private String image;
    private ArrayList<ReceiptProduct> receiptProducts = new ArrayList<>();

    public ArrayList<ReceiptProduct> getReceiptProducts() {
        return receiptProducts;
    }
 
    public void setReceiptProducts(ArrayList<ReceiptProduct> receiptProducts) {
        this.receiptProducts = receiptProducts;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", image=" + image + '}';
    }
    
    
}
