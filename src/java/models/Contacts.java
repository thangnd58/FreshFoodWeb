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
public class Contacts {
    private int contactID;
    private String customerName;
    private String email;
    private String phone;
    private String socialNetwork;

    public Contacts() {
    }

    public Contacts(int contactID, String customerName, String email, String phone, String socialNetwork) {
        this.contactID = contactID;
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
        this.socialNetwork = socialNetwork;
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(String socialNetwork) {
        this.socialNetwork = socialNetwork;
    }
    
    
}
