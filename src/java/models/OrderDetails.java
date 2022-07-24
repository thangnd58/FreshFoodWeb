/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


/**
 *
 * @author thang05082001
 */
public class OrderDetails {

    private int orderDetailID;
    private int orderID;
    private Products product;
    private int quantity;
    private double price;

    public OrderDetails() {
    }

    public OrderDetails(int orderDetailID, int orderID, Products product, int quantity, double price) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Products getProductID() {
        return product;
    }

    public void setProductID(Products product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceD() {
        return price;
    }
    
    public String getPrice() {
        return String.format("%,.0f", price);
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
