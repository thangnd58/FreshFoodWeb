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
public class Products {

    private int ProductID;
    private Categories Category;
    private String ProductName;
    private double Original;
    private String Description;
    private int Quantity;
    private String imgURL1;
    private String imgURL2;

    public Products() {
    }

    public Products(int ProductID, Categories Category, String ProductName, double Original, String Description, int Quantity, String imgURL1, String imgURL2) {
        this.ProductID = ProductID;
        this.Category = Category;
        this.ProductName = ProductName;
        this.Original = Original;
        this.Description = Description;
        this.Quantity = Quantity;
        this.imgURL1 = imgURL1;
        this.imgURL2 = imgURL2;
    }
    public Products(int ProductID, String ProductName, double Original, String imgURL1) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.Original = Original;
        this.imgURL1 = imgURL1;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public Categories getCategory() {
        return Category;
    }

    public void setCategory(Categories Category) {
        this.Category = Category;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getOriginal() {
        return String.format("%,.0f", Original);
    }

    public double getOriginalD() {
        return Original;
    }

    public void setOriginal(double Original) {
        this.Original = Original;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getImgURL1() {
        return imgURL1;
    }

    public void setImgURL1(String imgURL1) {
        this.imgURL1 = imgURL1;
    }

    public String getImgURL2() {
        return imgURL2;
    }

    public void setImgURL2(String imgURL2) {
        this.imgURL2 = imgURL2;
    }

    @Override
    public String toString() {
        return "Products{" + "ProductID=" + ProductID + ", Category=" + Category + ", ProductName=" + ProductName + ", Original=" + Original + ", Description=" + Description + ", Quantity=" + Quantity + ", imgURL1=" + imgURL1 + ", imgURL2=" + imgURL2 + '}';
    }

}
