/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author thang05082001
 */
public class Orders {

    private int orderID;
    private String userName;
    private String orderDate;
    private String fullName;
    private String address;
    private String email;
    private String phone;
    private double total;
    private ArrayList<OrderDetails> orderdetail;

    public Orders() {
    }

    public Orders(int orderID, String userName, String orderDate, String fullName, String address, String email, String phone, double total,ArrayList<OrderDetails> orderdetail) {
        this.orderID = orderID;
        this.userName = userName;
        this.orderDate = orderDate;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.total = total;
        this.orderdetail = orderdetail;
    }

    public ArrayList<OrderDetails> getOrderdetail() {
        return orderdetail;
    }

    public void setOrderdetail(ArrayList<OrderDetails> orderdetail) {
        this.orderdetail = orderdetail;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getTotalD() {
        return total;
    }
    
    public String getTotal() {
        return String.format("%,.0f", total);
    }


    public void setTotal(double total) {
        this.total = total;
    }
}
