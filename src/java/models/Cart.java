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
public class Cart {
    private ArrayList<Items> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public Cart(ArrayList<Items> items) {
        this.items = items;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }
    
    public int getQuantityByID(int id){
        return getItemByID(id).getQuantity();
    }
    
    private Items getItemByID(int id){
        for (Items item : items) {
            if(item.getProduct().getProductID() == id){
                return item;
            }
        }
        return null;
    }
    
    public void addItem(Items i){
        if(getItemByID(i.getProduct().getProductID())!=null){
            Items m = getItemByID(i.getProduct().getProductID());
            if (i.getProduct().getQuantity() > m.getQuantity()) {
                m.setQuantity(m.getQuantity() + i.getQuantity());
            } else if(i.getQuantity() == -1){
                m.setQuantity(m.getQuantity() + i.getQuantity());
            }
        } else {
            items.add(i);
        }
    }
    
    public void removeItem(int id){
        if(getItemByID(id)!=null){
            items.remove(getItemByID(id));
        }
    }
    
    public String getSubMoney(int id){
       double total = 0;
       total = getQuantityByID(id) * getItemByID(id).getProduct().getOriginalD();
       return String.format("%,.0f", total);
    }
    
    public double getTotalMoneyD(){
        double total = 0;
        for (Items item : items) {
            total += (item.getQuantity() * item.getProduct().getOriginalD());
        }
        return total;
    }
    
    public String getTotalMoney(){
        double total = 0;
        for (Items item : items) {
            total += (item.getQuantity() * item.getProduct().getOriginalD());
        }
        return String.format("%,.0f", total);
    }
}
